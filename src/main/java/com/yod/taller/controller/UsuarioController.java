package com.yod.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yod.taller.exceptions.UserException;
import com.yod.taller.persistence.entity.UsuarioEntity;
import com.yod.taller.services.UsuarioService;
import com.yod.taller.services.dto.RespuestaDTO;
import com.yod.taller.services.dto.UsuarioDTO;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("")
    public RespuestaDTO createUser(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.createUser(usuarioDTO);
    }

    @GetMapping
    public List<UsuarioEntity> findAll() {
        return usuarioService.findAll();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id){
        RespuestaDTO respuesta = this.usuarioService.deleteUserById(id);
        if(respuesta.getRespuesta().equalsIgnoreCase("fallo")) {
            throw new UserException("Task not found", HttpStatus.NOT_FOUND); 
            
        }
        return ResponseEntity.noContent().build();
    }
    
    @PatchMapping("/mofificarUser/{id}")
    public void modificarUsuario(@PathVariable("id") Integer id) {
           this.usuarioService.modificarUsuario(id);
           
        
    }
    
}
