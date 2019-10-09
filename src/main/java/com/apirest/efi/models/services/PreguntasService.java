package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.Preguntas;
import com.apirest.efi.models.dao.PreguntasDao;

@Service
public class PreguntasService {

    @Autowired
    private PreguntasDao preguntasDao;
    
    public List<Preguntas> findAll() {
        return preguntasDao.findAll();
    }

    public List<Object> findAllNative() {
        return preguntasDao.find();
    }

    public Preguntas findById(Long id) {
        return preguntasDao.findById(id).orElse(null);
    }

    public Preguntas save(Preguntas preguntas){
        return preguntasDao.save(preguntas);
    }

}