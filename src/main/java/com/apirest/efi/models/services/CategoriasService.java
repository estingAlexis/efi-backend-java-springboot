package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.Categorias;
import com.apirest.efi.models.dao.CategoriasDao;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasDao categoriasDao;
    
    public List<Categorias> findAll(){
        return categoriasDao.findAll();
    }

    public Categorias findById(Long id){
        return categoriasDao.findById(id).orElse(null);
    }

    public Categorias save(Categorias categorias){
        return categoriasDao.save(categorias);
    }

}