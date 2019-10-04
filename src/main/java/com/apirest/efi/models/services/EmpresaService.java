package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.Empresa;
import com.apirest.efi.models.dao.EmpresaDao;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaDao empresaDao;
    
    public List<Empresa> findAll(){
        return empresaDao.findAll();
    }

    public Empresa findById(Long id){
        return empresaDao.findById(id).orElse(null);
    }

    public Empresa save(Empresa empresa){
        return empresaDao.save(empresa);
    }

}
