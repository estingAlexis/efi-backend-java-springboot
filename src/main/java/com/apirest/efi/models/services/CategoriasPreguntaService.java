package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.CategoriasPregunta;
import com.apirest.efi.models.dao.CategoriasPreguntaDao;

@Service
public class CategoriasPreguntaService {

    @Autowired
    private CategoriasPreguntaDao categoriasPreguntaDao;
    
    public List<CategoriasPregunta> findAll(){
        return categoriasPreguntaDao.findAll();
    }

    public CategoriasPregunta findById(Long id){
        return categoriasPreguntaDao.findById(id).orElse(null);
    }

    public CategoriasPregunta save(CategoriasPregunta categoriasPregunta){
        return categoriasPreguntaDao.save(categoriasPregunta);
    }
}
