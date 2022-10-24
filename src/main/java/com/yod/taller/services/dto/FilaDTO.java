package com.yod.taller.services.dto;

import com.yod.taller.persistence.entity.TareaEntity;

public class FilaDTO {
    private TareaEntity tarea;
    private Integer duracion;

    public TareaEntity getTarea() {
        return tarea;
    }

    public void setTarea(TareaEntity tarea) {
        this.tarea = tarea;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

}
