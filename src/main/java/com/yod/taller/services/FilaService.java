package com.yod.taller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yod.taller.mapper.FilaInDTOToFila;
import com.yod.taller.persistence.entity.FilaEntity;
import com.yod.taller.persistence.repository.FilaRepository;
import com.yod.taller.services.dto.FilaDTO;
import com.yod.taller.services.dto.RespuestaDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilaService {

    @Autowired
    private FilaRepository filaRepository;

    @Autowired
    private FilaInDTOToFila dtoToFila;

    public RespuestaDTO createFila(FilaDTO filaDTO) {

        RespuestaDTO respuesta = new RespuestaDTO();
        FilaEntity fila = dtoToFila.map(filaDTO);
        if (fila.getDuracion() > 60 || fila.getDuracion() < 1) {
            respuesta.setRespuesta("Fallo");
            respuesta.setDescripcion("La duración debe ser en un rango entre 1-60");
            return respuesta;
        }
        this.filaRepository.save(fila);
        respuesta.setRespuesta("Exitoso");
        respuesta.setDescripcion("Resultado exitoso");
        return respuesta;
    }

    public List<FilaEntity> findAll() {
        return this.filaRepository.findAll();
    }

}
