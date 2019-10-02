package com.apirest.efi.models.dao;

import com.apirest.efi.models.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipioDao extends JpaRepository<Municipio, Long> {

}