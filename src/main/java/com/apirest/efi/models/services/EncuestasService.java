package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.Encuestas;
import com.apirest.efi.models.dao.EncuestasDao;

@Service
public class EncuestasService {

    @Autowired
    private EncuestasDao encuestasDao;
    
    public List<Encuestas> findAll(){
        return encuestasDao.findAll();
    }

    public Encuestas findById(Long id){
        return encuestasDao.findById(id).orElse(null);
    }

    public Encuestas save(Encuestas encuestas){
        return encuestasDao.save(encuestas);
    }
    
    public List<Encuestas> findByEmpresa(Long idEmpresa){
        return encuestasDao.filterByEmpresa(idEmpresa);
    }
}