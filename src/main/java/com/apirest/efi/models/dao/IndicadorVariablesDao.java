package com.apirest.efi.models.dao;

import java.util.List;

import com.apirest.efi.models.entity.IndicadorVariables;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IndicadorVariablesDao extends JpaRepository<IndicadorVariables, Integer> {

    @Query("SELECT i FROM IndicadorVariables i WHERE i.estado = :estado")
    List<IndicadorVariables> findByEstado(@Param("estado") Integer estado);
    
}

