package com.yod.taller.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_FILA")
public class FilaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idFila;

    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tarea", referencedColumnName = "id_tarea")
    @NotNull
    private TareaEntity tarea;

    @Column(name = "duracion")
    private Integer duracion;

    public Integer getDuracion() {
        return duracion;
    }

    public TareaEntity getTarea() {
        return tarea;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public void setTarea(TareaEntity tarea) {
        this.tarea = tarea;
    }

}
