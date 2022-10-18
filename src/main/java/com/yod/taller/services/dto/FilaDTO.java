package com.yod.taller.services.dto;

public class FilaDTO {
	private TareDTO tarea;
	private Integer duracion;
	public TareDTO getTarea() {
		return tarea;
	}
	public void setTarea(TareDTO tarea) {
		this.tarea = tarea;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	
}
