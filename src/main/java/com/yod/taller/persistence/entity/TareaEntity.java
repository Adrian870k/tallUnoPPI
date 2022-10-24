package com.yod.taller.persistence.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_TAREA")
public class TareaEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tarea")
    private Integer idTarea;
    @Column(name = "nombre")
    private String nombre;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TareaEntity other = (TareaEntity) obj;
        return Objects.equals(idTarea, other.idTarea);
    }

    public Integer getId() {
        return idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTarea);
    }

    public void setId(Integer id) {
        this.idTarea = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
