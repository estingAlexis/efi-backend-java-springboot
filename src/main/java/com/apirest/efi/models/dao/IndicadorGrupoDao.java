package com.apirest.efi.models.dao;

import java.util.List;

import com.apirest.efi.models.entity.IndicadorGrupo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IndicadorGrupoDao extends JpaRepository<IndicadorGrupo, Integer> {

   @Query("SELECT i FROM IndicadorGrupo i WHERE i.estado = :estado")
   List<IndicadorGrupo> findByEstado();
 
}