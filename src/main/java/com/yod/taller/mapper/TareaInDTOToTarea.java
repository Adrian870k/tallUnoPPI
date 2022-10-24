package com.yod.taller.mapper;

import org.springframework.stereotype.Component;

import com.yod.taller.persistence.entity.TareaEntity;
import com.yod.taller.services.dto.TareDTO;

@Component
public class TareaInDTOToTarea implements IMapper<TareDTO, TareaEntity> {

    @Override
    public TareaEntity map(TareDTO in) {
        TareaEntity task = new TareaEntity();
        task.setId(in.getId());
        task.setNombre(in.getNombre());
        return task;
    }

}
