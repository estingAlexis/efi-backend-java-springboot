package com.apirest.efi.models.dao;

import java.util.List;

import com.apirest.efi.models.entity.Preguntas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PreguntasDao extends JpaRepository<Preguntas, Long> {

    @Query(value="SELECT p.[id] ,[descripcion] ,[responsable] ,[referencia] ,[periodo] ,[id_grupo] ,[id_categoria] ,[id_empresa] ,[codigo] ,gp.nombre as grupo_nombre ,cp.nombre as cat_nombre FROM [efi_dev].[dbo].preguntas as p, [efi_dev].[dbo].grupos_pregunta as gp, [efi_dev].[dbo].categorias_pregunta as cp", nativeQuery = true)
    List<Object> find();

}