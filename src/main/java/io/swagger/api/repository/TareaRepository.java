package io.swagger.api.repository;

import io.swagger.api.util.JavaUtil;
import io.swagger.entity.EntityTarea;
import io.swagger.model.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Repository
public class TareaRepository {
    @Autowired
    private EntityTareaRepository entityTareaRepository;

    public EntityTarea crearTarea(Tarea tarea) throws ParseException {
        EntityTarea entityTarea = new EntityTarea(tarea.getIdentificador(), tarea.getDescripcion(),
                JavaUtil.stringToSqlDate(tarea),tarea.isVigente());
        return entityTareaRepository.save(entityTarea);
    }


    public EntityTarea modificarTarea(Tarea tarea){
        EntityTarea entityTarea = findByIdentificador(tarea.getIdentificador());
        entityTarea.setDescripcion(tarea.getDescripcion());
        entityTarea.setVigente(tarea.isVigente());
        return entityTareaRepository.save(entityTarea);

    }

    public void  deleteTarea(Tarea tarea){
        EntityTarea entityTarea = findByIdentificador(tarea.getIdentificador());
        entityTareaRepository.delete(entityTarea);

    }
    public EntityTarea findByIdentificador(BigDecimal identificador){
        return entityTareaRepository.findByIdentificador(identificador);
    }
}
