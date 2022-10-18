package com.yod.taller.mapper;

import org.springframework.stereotype.Component;

import com.yod.taller.persistence.entity.UsuarioEntity;
import com.yod.taller.services.dto.UsuarioDTO;

@Component
public class UsuarioInDTOToUsuario implements IMapper<UsuarioDTO, UsuarioEntity > {

	@Override
	public UsuarioEntity map(UsuarioDTO in) {
		UsuarioEntity user = new UsuarioEntity();
		user.setFechaNacimiento(in.getFecha_nacimiento());
		user.setDependencia(in.getDependencia());
		user.setPerfil(in.getPerfil());
		user.setActivo(false);
		user.setFila(in.getFila());
		return user;
	}
	
	
}
