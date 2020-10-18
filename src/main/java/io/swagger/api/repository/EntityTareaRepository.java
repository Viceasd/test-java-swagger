package io.swagger.api.repository;

import io.swagger.entity.EntityTarea;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface EntityTareaRepository  extends CrudRepository<EntityTarea, Long> {
    EntityTarea findByIdentificador(BigDecimal identificador);
}