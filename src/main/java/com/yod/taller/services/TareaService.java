package com.yod.taller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yod.taller.mapper.TareaInDTOToTarea;
import com.yod.taller.persistence.entity.TareaEntity;
import com.yod.taller.persistence.repository.TareaRepository;
import com.yod.taller.services.dto.RespuestaDTO;
import com.yod.taller.services.dto.TareDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private TareaInDTOToTarea dtoToTarea;

    public RespuestaDTO createTask(TareDTO taskDTO) {
        RespuestaDTO answer = new RespuestaDTO();
        TareaEntity task = dtoToTarea.map(taskDTO);
        this.tareaRepository.save(task);
        answer.setRespuesta("Exitoso");
        answer.setDescripcion("Resultado exitoso");
        return answer;
    }
    
    public List<TareaEntity> findAll(){
       return this.tareaRepository.findAll();
    }

}
