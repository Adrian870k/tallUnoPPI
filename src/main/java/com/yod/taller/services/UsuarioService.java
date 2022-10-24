package com.yod.taller.services;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yod.taller.mapper.UsuarioInDTOToUsuario;
import com.yod.taller.persistence.entity.UsuarioEntity;
import com.yod.taller.persistence.repository.UsuarioRepository;
import com.yod.taller.services.dto.RespuestaDTO;
import com.yod.taller.services.dto.UsuarioDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioInDTOToUsuario dtoUsuario;

    public RespuestaDTO createUser(UsuarioDTO usuarioDTO) {
        RespuestaDTO respuesta = new RespuestaDTO();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            UsuarioEntity user = dtoUsuario.map(usuarioDTO);
            String fechaFormat = formatter.format(user.getFechaNacimiento());
            if (Integer.parseInt(fechaFormat) > 2004) {
                respuesta.setRespuesta("Fallo");
                respuesta.setDescripcion("El usuario a registrar es menor de edad");
                return respuesta;
            }
            this.usuarioRepository.save(user);
            respuesta.setRespuesta("Exitoso");
            respuesta.setDescripcion("Insercion exitosa");
            return respuesta;

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return respuesta;
        }
    }

    public List<UsuarioEntity> findAll() {
        return this.usuarioRepository.findAll();
    }

    @Transactional
    public RespuestaDTO deleteUserById(Integer id) {
        RespuestaDTO respuesta = new RespuestaDTO();
        Optional<UsuarioEntity> user = this.usuarioRepository.findById(id);
        if(!user.isPresent()) {
            respuesta.setRespuesta("Fallo");
            respuesta.setDescripcion("El usuario no fue posible ser encontrado");
            return respuesta;
        }
        this.usuarioRepository.deleteUsuarioById(id);
        respuesta.setRespuesta("Exitoso");
        respuesta.setDescripcion("Usuario eliminado");
        return respuesta;
        
    }
}
