package com.apirest.efi.models.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "plan_cuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanCuentas.findAll", query = "SELECT p FROM PlanCuentas p")
    , @NamedQuery(name = "PlanCuentas.findByIdCuenta", query = "SELECT p FROM PlanCuentas p WHERE p.idCuenta = :idCuenta")
    , @NamedQuery(name = "PlanCuentas.findByTipoPlan", query = "SELECT p FROM PlanCuentas p WHERE p.tipoPlan = :tipoPlan")
    , @NamedQuery(name = "PlanCuentas.findByOrden", query = "SELECT p FROM PlanCuentas p WHERE p.orden = :orden")
    , @NamedQuery(name = "PlanCuentas.findByCodigo", query = "SELECT p FROM PlanCuentas p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "PlanCuentas.findByDescripcion", query = "SELECT p FROM PlanCuentas p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "PlanCuentas.findByTipo", query = "SELECT p FROM PlanCuentas p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "PlanCuentas.findByNivel", query = "SELECT p FROM PlanCuentas p WHERE p.nivel = :nivel")
    , @NamedQuery(name = "PlanCuentas.findByEntidad", query = "SELECT p FROM PlanCuentas p WHERE p.entidad = :entidad")
    , @NamedQuery(name = "PlanCuentas.findByEstado", query = "SELECT p FROM PlanCuentas p WHERE p.estado = :estado")})
public class PlanCuentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cuenta")
    private Integer idCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipo_plan")
    private String tipoPlan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private int orden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 10)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 10)
    @Column(name = "nivel")
    private String nivel;
    @Size(max = 10)
    @Column(name = "entidad")
    private String entidad;
    @Column(name = "estado")
    @NotNull
    private Integer estado;

    public PlanCuentas() {
    }

    public PlanCuentas(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public PlanCuentas(Integer idCuenta, String tipoPlan, int orden, String codigo, String descripcion) {
        this.idCuenta = idCuenta;
        this.tipoPlan = tipoPlan;
        this.orden = orden;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanCuentas)) {
            return false;
        }
        PlanCuentas other = (PlanCuentas) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.PlanCuentas[ idCuenta=" + idCuenta + " ]";
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
}
