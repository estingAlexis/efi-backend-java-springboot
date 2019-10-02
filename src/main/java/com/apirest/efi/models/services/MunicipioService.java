package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.Municipio;
import com.apirest.efi.models.dao.MunicipioDao;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioDao municipioDao;
    
    public List<Municipio> findAll(){
        return municipioDao.findAll();
    }

    public Municipio findById(Long id){
        return municipioDao.findById(id).orElse(null);
    }

    public Municipio save(Municipio municipio){
        return municipioDao.save(municipio);
    }

}