package com.apirest.efi.models.dao;

import com.apirest.efi.models.entity.EncuestaDetalle;
import com.apirest.efi.models.entity.Encuestas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EncuestaDetalleDao extends JpaRepository<EncuestaDetalle, Long> {

          
    @Query("SELECT e FROM EncuestaDetalle e WHERE (e.idEncuesta.id = :idEncuesta OR :idEncuesta = 0)"
            + " AND (e.idPregunta.idGrupo.id = :idGrupo OR :idGrupo = 0 )"
            + " AND (e.idPregunta.idCategoria.id = :idCategoria OR :idCategoria = 0 )"
            + " AND (e.idPregunta.idEmpresa.id = :idEmpresa OR :idEmpresa = 0 )"
            + " AND (e.idPregunta.codigo = :codigo OR :codigo = '0') "
            + " AND (e.estado = 0)")
    public List<EncuestaDetalle> filterByVarios(@Param("idEncuesta") Long idEncuesta, @Param("idGrupo") Long idGrupo, @Param("idCategoria") Long idCategoria, @Param("idEmpresa") Long idEmpresa, @Param("codigo") String codigo);
    
    
}