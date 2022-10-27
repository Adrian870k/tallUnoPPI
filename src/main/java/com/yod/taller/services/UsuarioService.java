package com.yod.taller.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yod.taller.mapper.UsuarioInDTOToUsuario;
import com.yod.taller.persistence.entity.FilaEntity;
import com.yod.taller.persistence.entity.UsuarioEntity;
import com.yod.taller.persistence.repository.FilaRepository;
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

    @Autowired
    private FilaRepository filaRepository;
    
    public RespuestaDTO createUser(UsuarioDTO usuarioDTO) {
        RespuestaDTO respuesta = new RespuestaDTO();
        try {
            UsuarioEntity user = dtoUsuario.map(usuarioDTO);
            if (this.validacionEdad(user) < 18) {
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
    
    private Integer validacionEdad(UsuarioEntity user) {
        LocalDate year = LocalDate.now();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String fechaFormat = formatter.format(user.getFechaNacimiento());
        int yearActual = year.getYear(); 
        int edad = yearActual - Integer.parseInt(fechaFormat);
        return edad;
    }

    public List<UsuarioEntity> findAll() {
        return this.usuarioRepository.findAll();
    }

    @Transactional
    public RespuestaDTO deleteUserById(Integer id) {
        RespuestaDTO respuesta = new RespuestaDTO();
        Optional<UsuarioEntity> user = this.usuarioRepository.findById(id);
        List<FilaEntity> fila = user.get().getFila();
        if(!user.isPresent()) {
            respuesta.setRespuesta("Fallo");
            respuesta.setDescripcion("El usuario no fue posible ser encontrado");
            return respuesta;
        }
        for (int i = 0; i < fila.size(); i++) {
            this.filaRepository.delete(fila.remove(i));
        }
                 
        this.usuarioRepository.deleteUsuarioById(id);
        respuesta.setRespuesta("Exitoso");
        respuesta.setDescripcion("Usuario eliminado");
        return respuesta;
        
    }
    
    @Transactional
    public RespuestaDTO modificarUsuario(Integer id) {
        RespuestaDTO respuesta = new RespuestaDTO();
        Optional<UsuarioEntity> user = this.usuarioRepository.findById(id);
        if(!user.isPresent()) {
            respuesta.setRespuesta("Fallo");
            respuesta.setDescripcion("El usuario no se encuantra en el sistema");
            return respuesta;
        }
        this.usuarioRepository.modificarUsuarioById(id);
        respuesta.setRespuesta("Respuesta exitosa");
        respuesta.setDescripcion("Se modifico correctamente el usuario");
        return respuesta;
        
    }
    
}
