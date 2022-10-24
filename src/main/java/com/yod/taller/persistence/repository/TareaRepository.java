package com.yod.taller.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yod.taller.persistence.entity.TareaEntity;

@Repository
public interface TareaRepository extends JpaRepository<TareaEntity, Integer>{
    //List<TareaEntity> findById(Integer id);
    List<TareaEntity> findAll();
}
