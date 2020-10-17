package io.swagger.api;

import io.swagger.model.Tarea;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-17T06:36:53.383Z")

@Controller
public class TareaApiController implements TareaApi {

    private static final Logger log = LoggerFactory.getLogger(TareaApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TareaApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addTarea(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true )  @Valid @RequestBody Tarea body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteTarea(@ApiParam(value = "Tarea id to delete",required=true) @PathVariable("identificador") Long identificador,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Tarea> getPetById(@ApiParam(value = "ID of tarea to return",required=true) @PathVariable("identificador") Long identificador) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Tarea>(objectMapper.readValue("<null>  <identificador>1.3579</identificador>  <descripcion>aeiou</descripcion>  <fechaCreacion>aeiou</fechaCreacion>  <vigente>true</vigente></null>", Tarea.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Tarea>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Tarea>(objectMapper.readValue("{  \"descripcion\" : \"descripcion\",  \"fechaCreacion\" : \"fechaCreacion\",  \"vigente\" : true,  \"identificador\" : 0.80082819046101150206595775671303272247314453125}", Tarea.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Tarea>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Tarea>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateTarea(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true )  @Valid @RequestBody Tarea body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}