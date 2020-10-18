package io.swagger.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="Tarea")
public class EntityTarea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "identificador")
    private BigDecimal identificador;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_creacion")
    private java.sql.Date fechaCreacion;

    @Column(name = "vigente")
    private Boolean vigente;

    public EntityTarea(){
    }

    public EntityTarea(BigDecimal identificador, String descripcion, Date fechaCreacion, Boolean vigente) {

        this.identificador = identificador;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.vigente = vigente;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getIdentificador() {
        return identificador;
    }

    public void setIdentificador(BigDecimal identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityTarea that = (EntityTarea) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(identificador, that.identificador) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(vigente, that.vigente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identificador, descripcion, fechaCreacion, vigente);
    }

    @Override
    public String toString() {
        return "EntityTarea{" +
                "id=" + id +
                ", identificador=" + identificador +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", vigente=" + vigente +
                '}';
    }
}
