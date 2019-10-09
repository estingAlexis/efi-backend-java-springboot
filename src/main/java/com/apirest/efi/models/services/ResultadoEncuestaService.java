package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.ResultadoEncuesta;
import com.apirest.efi.models.dao.ResultadoEncuestaDao;

@Service
public class ResultadoEncuestaService {

    @Autowired
    private ResultadoEncuestaDao resultadoEncuestaDao;
    
    public List<ResultadoEncuesta> findAll(){
        return resultadoEncuestaDao.findAll();
    }

    public ResultadoEncuesta findById(Long id){
        return resultadoEncuestaDao.findById(id).orElse(null);
    }

    public ResultadoEncuesta save(ResultadoEncuesta resultadoEncuesta){
        return resultadoEncuestaDao.save(resultadoEncuesta);
    }
    
    public List<ResultadoEncuesta> findByEmpresa(Long idEmpresa){
        return resultadoEncuestaDao.findByEmpresa(idEmpresa);
    }

}