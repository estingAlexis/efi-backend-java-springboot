package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.EncuestaDetalle;
import com.apirest.efi.models.dao.EncuestaDetalleDao;

@Service
public class EncuestaDetalleService {

    @Autowired
    private EncuestaDetalleDao encuestaDetalleDao;
    
    public List<EncuestaDetalle> findAll(){
        return encuestaDetalleDao.findAll();
    }

    public EncuestaDetalle findById(Long id){
        return encuestaDetalleDao.findById(id).orElse(null);
    }

    public EncuestaDetalle save(EncuestaDetalle encuestaDetalle){
        return encuestaDetalleDao.save(encuestaDetalle);
    }
}
