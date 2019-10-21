package com.apirest.efi.models.dao;

import java.util.List;

import com.apirest.efi.models.entity.CategoriasPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriasPreguntaDao extends JpaRepository<CategoriasPregunta, Long> {

}