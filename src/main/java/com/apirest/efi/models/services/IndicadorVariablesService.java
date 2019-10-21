package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.IndicadorVariables;
import com.apirest.efi.models.dao.IndicadorVariablesDao;

@Service
public class IndicadorVariablesService {

    @Autowired
    private IndicadorVariablesDao indicadorVariablesDao;
    
    public List<IndicadorVariables> findAll(){
        return indicadorVariablesDao.findAll();
    }

    public List<IndicadorVariables> findByEstado(Integer estado) {
        return indicadorVariablesDao.findByEstado(estado);
    }

    public IndicadorVariables findById(Integer id){
        return indicadorVariablesDao.findById(id).orElse(null);
    }

    public IndicadorVariables save(IndicadorVariables indicadorVariables){
        return indicadorVariablesDao.save(indicadorVariables);
    }

}