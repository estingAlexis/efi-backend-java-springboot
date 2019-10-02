package com.apirest.efi.models.dao;

import com.apirest.efi.models.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaDao extends JpaRepository<Empresa, Long> {

}