package com.apirest.efi.models.dao;

import com.apirest.efi.models.entity.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarioDao extends JpaRepository<Calendario, Long> {

}