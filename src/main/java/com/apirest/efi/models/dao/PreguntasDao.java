package com.apirest.efi.models.dao;

import com.apirest.efi.models.entity.Preguntas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntasDao extends JpaRepository<Preguntas, Long> {

}