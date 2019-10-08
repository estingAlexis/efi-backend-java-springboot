package com.apirest.efi.models.dao;

import com.apirest.efi.models.entity.ResultadoEncuestaDetalle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResultadoEncuestaDetalleDao extends JpaRepository<ResultadoEncuestaDetalle, Long> {
    
     @Query("SELECT r FROM ResultadoEncuestaDetalle r WHERE (r.idResultadoEncuesta.id = :idResultadoEncuesta)")
     public List<ResultadoEncuestaDetalle> findByResultadoEncuesta(@Param("idResultadoEncuesta") Long idResultadoEncuesta);

}