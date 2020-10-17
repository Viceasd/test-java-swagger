package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Tarea
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-17T06:36:53.383Z")




public class Tarea   {
  @JsonProperty("identificador")
  private BigDecimal identificador = null;

  @JsonProperty("descripcion")
  private String descripcion = null;

  @JsonProperty("fechaCreacion")
  private String fechaCreacion = null;

  @JsonProperty("vigente")
  private Boolean vigente = null;

  public Tarea identificador(BigDecimal identificador) {
    this.identificador = identificador;
    return this;
  }

  /**
   * Get identificador
   * @return identificador
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getIdentificador() {
    return identificador;
  }

  public void setIdentificador(BigDecimal identificador) {
    this.identificador = identificador;
  }

  public Tarea descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * @return descripcion
  **/
  @ApiModelProperty(value = "")


  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Tarea fechaCreacion(String fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
    return this;
  }

  /**
   * Get fechaCreacion
   * @return fechaCreacion
  **/
  @ApiModelProperty(value = "")


  public String getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(String fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public Tarea vigente(Boolean vigente) {
    this.vigente = vigente;
    return this;
  }

  /**
   * Get vigente
   * @return vigente
  **/
  @ApiModelProperty(value = "")


  public Boolean isVigente() {
    return vigente;
  }

  public void setVigente(Boolean vigente) {
    this.vigente = vigente;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tarea tarea = (Tarea) o;
    return Objects.equals(this.identificador, tarea.identificador) &&
        Objects.equals(this.descripcion, tarea.descripcion) &&
        Objects.equals(this.fechaCreacion, tarea.fechaCreacion) &&
        Objects.equals(this.vigente, tarea.vigente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identificador, descripcion, fechaCreacion, vigente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tarea {\n");
    
    sb.append("    identificador: ").append(toIndentedString(identificador)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    fechaCreacion: ").append(toIndentedString(fechaCreacion)).append("\n");
    sb.append("    vigente: ").append(toIndentedString(vigente)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

