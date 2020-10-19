package io.swagger.api;

import io.swagger.api.repository.TareaRepository;
import io.swagger.entity.EntityTarea;
import io.swagger.model.Tarea;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.DataInput;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-17T06:36:53.383Z")

@Controller
public class TareaApiController implements TareaApi {

    private static final Logger log = LoggerFactory.getLogger(TareaApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private TareaRepository tareaRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public TareaApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Tarea> addTarea(@ApiParam(value = "Tarea object that needs to be added to the store" ,required=true )  @Valid @RequestBody Tarea body) throws ParseException {
        String accept = request.getHeader("Accept");
        EntityTarea entityTarea = tareaRepository.crearTarea(body);
        Tarea tarea = parseToTarea(entityTarea);
        return  ResponseEntity.accepted().body(tarea);
    }

    private Tarea parseToTarea(EntityTarea entityTarea) {
        Tarea tarea = new Tarea();
        tarea.setDescripcion(entityTarea.getDescripcion());
        tarea.setFechaCreacion(entityTarea.getFechaCreacion().toString());
        tarea.setIdentificador(entityTarea.getIdentificador());
        tarea.setVigente(entityTarea.getVigente());
        return tarea;
    }

    public ResponseEntity<String> deleteTarea(@ApiParam(value = "Tarea id to delete",required=true) @PathVariable("identificador") Long identificador, @ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey) {
        String accept = request.getHeader("Accept");
        Tarea tarea = parseToTarea(tareaRepository.findByIdentificador(BigDecimal.valueOf(identificador)));
        tareaRepository.deleteTarea(tarea);
        return new ResponseEntity<String>("Tarea Eliminada", HttpStatus.OK);
    }

    public ResponseEntity<Tarea> getTareaById(@ApiParam(value = "ID of tarea to return",required=true) @PathVariable("identificador") Long identificador) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {

            return  ResponseEntity.accepted().body(parseToTarea(tareaRepository.findByIdentificador(BigDecimal.valueOf(identificador))));
        }

        if (accept != null && accept.contains("application/json")) {
            return ResponseEntity.accepted().body(parseToTarea(tareaRepository.findByIdentificador(BigDecimal.valueOf(identificador))));
        }

        return new ResponseEntity<Tarea>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Tarea> updateTarea(@ApiParam(value = "Tarea object that needs to be added to the store" ,required=true )  @Valid @RequestBody Tarea body) {
        String accept = request.getHeader("Accept");
        EntityTarea tareaEntity = tareaRepository.modificarTarea(body);
        Tarea tarea = parseToTarea(tareaEntity);
        return  ResponseEntity.accepted().body(tarea);
    }

}
