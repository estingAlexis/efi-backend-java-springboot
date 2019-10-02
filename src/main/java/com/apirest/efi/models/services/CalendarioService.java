package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.Calendario;
import com.apirest.efi.models.dao.CalendarioDao;

@Service
public class CalendarioService {

    @Autowired
    private CalendarioDao calendarioDao;
    
    public List<Calendario> findAll(){
        return calendarioDao.findAll();
    }

    public Calendario findById(Long id){
        return calendarioDao.findById(id).orElse(null);
    }

    public Calendario save(Calendario calendario){
        return calendarioDao.save(calendario);
    }

}