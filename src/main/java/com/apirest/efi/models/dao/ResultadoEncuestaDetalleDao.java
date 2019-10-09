package com.apirest.efi.models.dao;

import com.apirest.efi.models.entity.ResultadoEncuestaDetalle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ResultadoEncuestaDetalleDao extends JpaRepository<ResultadoEncuestaDetalle, Long> {
    
     @Query("SELECT r FROM ResultadoEncuestaDetalle r WHERE (r.idResultadoEncuesta.id = :idResultadoEncuesta) AND (r.estado = 0)")
     public List<ResultadoEncuestaDetalle> findByResultadoEncuesta(@Param("idResultadoEncuesta") Long idResultadoEncuesta);

     @Transactional
     @Modifying
     @Query("UPDATE ResultadoEncuestaDetalle r SET r.estado = 1 WHERE  r.idResultadoEncuesta.id = :idResultadoEncuesta")
     public void deletePreguntas(@Param("idResultadoEncuesta") Long idResultadoEncuesta);
}