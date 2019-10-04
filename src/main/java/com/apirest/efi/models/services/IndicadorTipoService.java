package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.IndicadorTipo;
import com.apirest.efi.models.dao.IndicadorTipoDao;

@Service
public class IndicadorTipoService {

    @Autowired
    private IndicadorTipoDao indicadorTipoDao;
    
    public List<IndicadorTipo> findAll(){
        return indicadorTipoDao.findAll();
    }

    public IndicadorTipo findById(Integer id){
        return indicadorTipoDao.findById(id).orElse(null);
    }

    public IndicadorTipo save(IndicadorTipo indicadorTipo){
        return indicadorTipoDao.save(indicadorTipo);
    }

}