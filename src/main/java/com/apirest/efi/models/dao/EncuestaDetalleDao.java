package com.apirest.efi.models.dao;

import java.util.List;

import com.apirest.efi.models.entity.EncuestaDetalle;
import com.apirest.efi.models.entity.Encuestas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EncuestaDetalleDao extends JpaRepository<EncuestaDetalle, Long> {

    @Query(value="SELECT TOP (1000) [id],[id_encuesta],[id_pregunta],[requerido],[estado] FROM [efi_dev].[dbo].[encuesta_detalle] where id_encuesta = :id", nativeQuery = true)
    List<EncuestaDetalle> findByIdEncuesta(@Param("id") Integer id);

}