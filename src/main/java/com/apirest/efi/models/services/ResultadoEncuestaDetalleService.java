package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.ResultadoEncuestaDetalle;
import com.apirest.efi.models.dao.ResultadoEncuestaDetalleDao;

@Service
public class ResultadoEncuestaDetalleService {

    @Autowired
    private ResultadoEncuestaDetalleDao resultadoEncuestaDetalleDao;
    
    public List<ResultadoEncuestaDetalle> findAll(){
        return resultadoEncuestaDetalleDao.findAll();
    }

    public ResultadoEncuestaDetalle findById(Long id){
        return resultadoEncuestaDetalleDao.findById(id).orElse(null);
    }

    public ResultadoEncuestaDetalle save(ResultadoEncuestaDetalle resultadoEncuestaDetalle){
        return resultadoEncuestaDetalleDao.save(resultadoEncuestaDetalle);
    }

}