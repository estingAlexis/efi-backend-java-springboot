package com.apirest.efi.models.dao;

import com.apirest.efi.models.entity.Encuestas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncuestasDao extends JpaRepository<Encuestas, Long> {

}