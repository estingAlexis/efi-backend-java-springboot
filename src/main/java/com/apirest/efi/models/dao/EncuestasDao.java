package com.apirest.efi.models.dao;

import com.apirest.efi.models.entity.Encuestas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EncuestasDao extends JpaRepository<Encuestas, Long> {

        @Query("SELECT e FROM Encuestas e WHERE (e.idEmpresa.id = :idEmpresa) and  e.estado = 0")
        public List<Encuestas> filterByEmpresa(@Param("idEmpresa") Long idEmpresa);

    
}