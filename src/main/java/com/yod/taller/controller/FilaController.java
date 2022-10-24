package com.yod.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yod.taller.persistence.entity.FilaEntity;
import com.yod.taller.services.FilaService;
import com.yod.taller.services.dto.FilaDTO;
import com.yod.taller.services.dto.RespuestaDTO;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Fila")
@RequiredArgsConstructor
public class FilaController {
    @Autowired
    private FilaService filaService;

    @PostMapping("")
    public RespuestaDTO createFila(@RequestBody FilaDTO filaDTO) {
        return filaService.createFila(filaDTO);
    }

    @GetMapping
    public List<FilaEntity> findAll() {
        return filaService.findAll();
    }
}
