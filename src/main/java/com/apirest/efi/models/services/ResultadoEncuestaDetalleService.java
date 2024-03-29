package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.ResultadoEncuestaDetalle;
import com.apirest.efi.models.dao.ResultadoEncuestaDetalleDao;
import org.springframework.data.jpa.repository.Query;

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
    
    public List<ResultadoEncuestaDetalle> findByResultadoEncuesta(Long idResultadoEncuesta){
        return resultadoEncuestaDetalleDao.findByResultadoEncuesta(idResultadoEncuesta);
    }
    
    public void deletePreguntasByEncuesta(Long idResultadoEncuesta){
        System.out.println(idResultadoEncuesta);
        
       resultadoEncuestaDetalleDao.deletePreguntas(idResultadoEncuesta);
    }       
   
}