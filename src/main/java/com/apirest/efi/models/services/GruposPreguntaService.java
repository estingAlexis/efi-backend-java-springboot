package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.GruposPregunta;
import com.apirest.efi.models.dao.GruposPreguntaDao;

@Service
public class GruposPreguntaService {

    @Autowired
    private GruposPreguntaDao gruposPreguntaDao;
    
    public List<GruposPregunta> findAll(){
        return gruposPreguntaDao.findAll();
    }

    public GruposPregunta findById(Long id){
        return gruposPreguntaDao.findById(id).orElse(null);
    }

    public GruposPregunta save(GruposPregunta gruposPregunta){
        return gruposPreguntaDao.save(gruposPregunta);
    }

}