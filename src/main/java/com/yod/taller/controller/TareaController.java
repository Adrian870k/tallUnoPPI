package com.yod.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yod.taller.persistence.entity.TareaEntity;
import com.yod.taller.services.TareaService;
import com.yod.taller.services.dto.RespuestaDTO;
import com.yod.taller.services.dto.TareDTO;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Task")
@RequiredArgsConstructor
public class TareaController {
    @Autowired
    TareaService tareaService;

    @PostMapping("")
    public RespuestaDTO createTask(@RequestBody TareDTO tareDTO) {
        return tareaService.createTask(tareDTO);

    }

    @GetMapping
    public List<TareaEntity> findAll() {
        return tareaService.findAll();
    }
}
