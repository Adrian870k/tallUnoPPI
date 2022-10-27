package com.yod.taller.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yod.taller.persistence.entity.Perfil;
import com.yod.taller.persistence.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    List<UsuarioEntity> findAllByPerfil(Perfil perfil);

    List<UsuarioEntity> findAll();

    @Modifying
    @Query(value = "UPDATE TBL_USUARIO SET activo = true where ID=:id", nativeQuery = true)
    void modificarUsuarioById(@Param("id") Integer id);

    void deleteUsuarioById(Integer id);
}
