package com.yod.taller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yod.taller.mapper.UsuarioInDTOToUsuario;
import com.yod.taller.persistence.entity.UsuarioEntity;
import com.yod.taller.persistence.repository.UsuarioRepository;
import com.yod.taller.services.dto.UsuarioDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioInDTOToUsuario dtoUsuario;

	public UsuarioEntity createUser(UsuarioDTO usuarioDTO) {
		try {
			UsuarioEntity user = dtoUsuario.map(usuarioDTO);
			return this.usuarioRepository.save(user);
		} catch (Exception e) {
			System.out.println("Error: "+e);
			return null;
		}
		
		
	}
	
	public List<UsuarioEntity> findAll(){
		return this.usuarioRepository.findAll();
	}

}
