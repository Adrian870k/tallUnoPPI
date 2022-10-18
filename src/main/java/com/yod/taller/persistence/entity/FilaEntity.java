package com.yod.taller.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "TBL_FILA")
public class FilaEntity {
	@Id
	@Column
	private Integer idTarea;
	@Column(name = "duracion")
	private Integer duracion;
}
