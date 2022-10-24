package com.yod.taller.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yod.taller.persistence.entity.FilaEntity;
import com.yod.taller.persistence.entity.TareaEntity;

@Repository
public interface FilaRepository extends JpaRepository<FilaEntity, Integer> {
    List<FilaEntity> findAllByTarea(TareaEntity tarea);
    List<FilaEntity> findAll();
}
