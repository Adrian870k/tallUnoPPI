package com.yod.taller.mapper;

import org.springframework.stereotype.Component;

import com.yod.taller.persistence.entity.FilaEntity;
import com.yod.taller.services.dto.FilaDTO;

@Component
public class FilaInDTOToFila implements IMapper<FilaDTO, FilaEntity> {

    @Override
    public FilaEntity map(FilaDTO in) {
        FilaEntity fila = new FilaEntity();
        fila.setDuracion(in.getDuracion());
        fila.setTarea(in.getTarea());
        return fila;
    }
    
    
}
