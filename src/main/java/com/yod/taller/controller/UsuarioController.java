package com.yod.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yod.taller.persistence.entity.UsuarioEntity;
import com.yod.taller.services.UsuarioService;
import com.yod.taller.services.dto.UsuarioDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("")
	public UsuarioEntity createUser(@RequestBody UsuarioDTO usuarioDTO)
	{
		return usuarioService.createUser(usuarioDTO);
	}
	
	@GetMapping
	public List<UsuarioEntity> findAll(){
		return usuarioService.findAll();
	}
}
