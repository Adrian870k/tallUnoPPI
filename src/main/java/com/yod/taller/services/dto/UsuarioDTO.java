package com.yod.taller.services.dto;

import java.util.Date;
import java.util.List;

import com.yod.taller.persistence.entity.Dependencia;
import com.yod.taller.persistence.entity.FilaEntity;
import com.yod.taller.persistence.entity.Perfil;

public class UsuarioDTO {
	private Date fecha_nacimiento;
	private Dependencia dependencia;
	private Perfil perfil;
	private List<FilaEntity> fila;

	public List<FilaEntity> getFila() {
		return fila;
	}

	public void setFila(List<FilaEntity> fila) {
		this.fila = fila;
	}

	public Dependencia getDependencia() {
		return dependencia;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
