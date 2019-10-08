package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.IndicadorGrupo;
import com.apirest.efi.models.dao.IndicadorGrupoDao;

@Service
public class IndicadorGrupoService {

    @Autowired
    private IndicadorGrupoDao indicadorGrupoDao;
    
    public List<IndicadorGrupo> findAll(){
        return indicadorGrupoDao.findAll();
    }

    public IndicadorGrupo findById(Integer id){
        return indicadorGrupoDao.findById(id).orElse(null);
    }

    public IndicadorGrupo save(IndicadorGrupo indicadorGrupo){
        return indicadorGrupoDao.save(indicadorGrupo);
    }

}
