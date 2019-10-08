package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.Entidades;
import com.apirest.efi.models.dao.EntidadesDao;

@Service
public class EntidadesService {

    @Autowired
    private EntidadesDao entidadesDao;
    
    public List<Entidades> findAll(){
        return entidadesDao.findAll();
    }

    public Entidades findById(Long id){
        return entidadesDao.findById(id).orElse(null);
    }

    public Entidades save(Entidades entidades){
        return entidadesDao.save(entidades);
    }
    
    
    public List<Entidades> getEntidadesEmpresa(Long idEntidad){
        return entidadesDao.filterByEmpresa(idEntidad);
    }

}
