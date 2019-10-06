package com.apirest.efi.models.dao;

import java.util.List;

import com.apirest.efi.models.entity.IndicadorGrupo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IndicadorGrupoDao extends JpaRepository<IndicadorGrupo, Integer> {

   @Query(value = "SELECT grupo.*, tipo.nombre_tipo from  [efi_dev].[dbo].[indicador_grupo] as grupo, [efi_dev].[dbo].[indicador_tipo] as tipo where grupo.fk_tipo = tipo.id_tipo_indicador ", nativeQuery = true)
   List<Object> findWithNombreTipo();
 
}