package com.apirest.efi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.apirest.efi.models.entity.PlanCuentas;
import com.apirest.efi.models.services.PlanCuentasService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class PlanCuentasController {

    @Autowired
    private PlanCuentasService planCuentasService;

    @GetMapping("planCuentas")
    public List<PlanCuentas> findAll() {
		return planCuentasService.findAll();
    }
    
    @GetMapping("planCuentas/{id}")
    public PlanCuentas findById(@PathVariable("id") Integer id) {
		return planCuentasService.findById(id);
    }
    
    @PostMapping("planCuentas")
    public PlanCuentas save(@RequestBody PlanCuentas planCuentas) {
		return planCuentasService.save(planCuentas);
    }
    
    @PutMapping("planCuentas")
    public PlanCuentas edit(@RequestBody PlanCuentas planCuentas) {
        PlanCuentas planCuentasActual = new PlanCuentas();
        PlanCuentas planCuentasUpdate = new PlanCuentas();
        planCuentasActual = planCuentasService.findById(planCuentas.getIdCuenta());

        if (planCuentasActual != null) {
            planCuentasUpdate = planCuentasService.save(planCuentas);
        }
        return planCuentasUpdate;
	}
}
