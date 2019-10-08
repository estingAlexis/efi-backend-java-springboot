package com.apirest.efi.models.dao;

import com.apirest.efi.models.entity.ResultadoEncuesta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResultadoEncuestaDao extends JpaRepository<ResultadoEncuesta, Long> {

        @Query("SELECT r FROM ResultadoEncuesta r WHERE (r.idEmpresa.id = :idEmpresa)")
        public List<ResultadoEncuesta> findByEmpresa(@Param("idEmpresa") Long idEmpresa);
    
}