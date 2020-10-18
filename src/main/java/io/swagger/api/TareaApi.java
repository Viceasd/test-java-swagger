/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Tarea;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-17T06:36:53.383Z")

@Api(value = "tarea", description = "the tarea API")
@RequestMapping(value = "/v2")
public interface TareaApi {

    @ApiOperation(value = "Add a new Tarea", nickname = "addTarea", notes = "", authorizations = {
        @Authorization(value = "tareastore_auth", scopes = {
            @AuthorizationScope(scope = "write:tareas", description = "modify tareas in your account"),
            @AuthorizationScope(scope = "read:tareas", description = "read your tareas")
            })
    }, tags={ "Tareas", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/tarea",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<Tarea> addTarea(@ApiParam(value = "Tarea object that needs to be added to the store" ,required=true )  @Valid @RequestBody Tarea body);


    @ApiOperation(value = "Deletes a tarea", nickname = "deleteTarea", notes = "", authorizations = {
        @Authorization(value = "tareastore_auth", scopes = {
            @AuthorizationScope(scope = "write:tareas", description = "modify tareas in your account"),
            @AuthorizationScope(scope = "read:tareas", description = "read your tareas")
            })
    }, tags={ "tarea", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Tarea not found") })
    @RequestMapping(value = "/tarea/{identificador}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTarea(@ApiParam(value = "Tarea id to delete",required=true) @PathVariable("identificador") Long identificador,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey);


    @ApiOperation(value = "Find tarea by ID", nickname = "getTareaById", notes = "Returns a single tarea", response = Tarea.class, authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "Tarea", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Tarea.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Tarea not found") })
    @RequestMapping(value = "/tarea/{identificador}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Tarea> getTareaById(@ApiParam(value = "ID of tarea to return",required=true) @PathVariable("identificador") Long identificador);


    @ApiOperation(value = "Update an existing tarea", nickname = "updateTarea", notes = "", authorizations = {
        @Authorization(value = "tareastore_auth", scopes = {
            @AuthorizationScope(scope = "write:tareas", description = "modify tareas in your account"),
            @AuthorizationScope(scope = "read:tareas", description = "read your tareas")
            })
    }, tags={ "tarea", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Tarea not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/tarea",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateTarea(@ApiParam(value = "Tarea object that needs to be added to the store" ,required=true )  @Valid @RequestBody Tarea body);

}
