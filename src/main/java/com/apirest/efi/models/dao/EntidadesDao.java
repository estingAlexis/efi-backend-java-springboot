package com.apirest.efi.models.dao;

import com.apirest.efi.models.entity.Entidades;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EntidadesDao extends JpaRepository<Entidades, Long> {

        @Query(value = "SELECT * from entidades\n" +
        "WHERE Departamento in (SELECT departamento from entidades e where e.id_entidad = :idEntidad)\n" +
        "ORDER BY id_entidad;", nativeQuery = true)
        public List<Entidades> filterByEmpresa(@Param("idEntidad") Long idEntidad);

    
}