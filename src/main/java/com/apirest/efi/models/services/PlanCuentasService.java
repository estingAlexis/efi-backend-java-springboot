package com.apirest.efi.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.efi.models.entity.PlanCuentas;
import com.apirest.efi.models.dao.PlanCuentasDao;

@Service
public class PlanCuentasService {

    @Autowired
    private PlanCuentasDao PlanCuentasDao;
    
    public List<PlanCuentas> findAll(){
        return PlanCuentasDao.findAll();
    }

    public PlanCuentas findById(Integer id){
        return PlanCuentasDao.findById(id).orElse(null);
    }

    public PlanCuentas save(PlanCuentas planCuentas){
        return PlanCuentasDao.save(planCuentas);
    }

}
