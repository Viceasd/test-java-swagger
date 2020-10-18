package io.swagger.api.repository;

import io.swagger.entity.EntityTarea;
import io.swagger.model.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Repository
public class TareaRepository {
    @Autowired
    private EntityTareaRepository entityTareaRepository;

    public EntityTarea crearTarea(Tarea tarea){
        EntityTarea entityTarea = new EntityTarea(tarea.getIdentificador(), tarea.getDescripcion(),
                Date.valueOf(tarea.getFechaCreacion()),tarea.isVigente());
        return entityTareaRepository.save(entityTarea);
    }

    public EntityTarea modificarTarea(Tarea tarea){
        EntityTarea entityTarea = new EntityTarea();
        entityTarea = findByIdentificador(tarea.getIdentificador());
        entityTarea.setDescripcion(tarea.getDescripcion());
        entityTarea.setVigente(tarea.isVigente());
        return entityTareaRepository.save(entityTarea);

    }

    public void  deleteTarea(Tarea tarea){
        EntityTarea entityTarea = new EntityTarea();
        entityTarea = findByIdentificador(tarea.getIdentificador());
        entityTareaRepository.delete(entityTarea);

    }
    public EntityTarea findByIdentificador(BigDecimal identificador){
        return entityTareaRepository.findByIdentificador(identificador);
    }
}
