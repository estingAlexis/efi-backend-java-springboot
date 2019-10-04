package com.apirest.efi.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "categorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c")
    , @NamedQuery(name = "Categorias.findByIdCategoria", query = "SELECT c FROM Categorias c WHERE c.idCategoria = :idCategoria")
    , @NamedQuery(name = "Categorias.findByCategoria", query = "SELECT c FROM Categorias c WHERE c.categoria = :categoria")
    , @NamedQuery(name = "Categorias.findByDescripcionCategoria", query = "SELECT c FROM Categorias c WHERE c.descripcionCategoria = :descripcionCategoria")
    , @NamedQuery(name = "Categorias.findByLimiteGasto", query = "SELECT c FROM Categorias c WHERE c.limiteGasto = :limiteGasto")
    , @NamedQuery(name = "Categorias.findByHabitantesInferior", query = "SELECT c FROM Categorias c WHERE c.habitantesInferior = :habitantesInferior")
    , @NamedQuery(name = "Categorias.findByHabitantesSuperior", query = "SELECT c FROM Categorias c WHERE c.habitantesSuperior = :habitantesSuperior")
    , @NamedQuery(name = "Categorias.findByIngresosCorrientes", query = "SELECT c FROM Categorias c WHERE c.ingresosCorrientes = :ingresosCorrientes")})
public class Categorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_categoria")
    private Long idCategoria;
    @Size(max = 50)
    @Column(name = "categoria")
    private String categoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion_categoria")
    private String descripcionCategoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limite_gasto")
    private BigDecimal limiteGasto;
    @Column(name = "habitantes_inferior")
    private BigDecimal habitantesInferior;
    @Column(name = "habitantes_superior")
    private BigDecimal habitantesSuperior;
    @Column(name = "ingresos_corrientes")
    private Long ingresosCorrientes;

    public Categorias() {
    }

    public Categorias(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categorias(Long idCategoria, String descripcionCategoria) {
        this.idCategoria = idCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public BigDecimal getLimiteGasto() {
        return limiteGasto;
    }

    public void setLimiteGasto(BigDecimal limiteGasto) {
        this.limiteGasto = limiteGasto;
    }

    public BigDecimal getHabitantesInferior() {
        return habitantesInferior;
    }

    public void setHabitantesInferior(BigDecimal habitantesInferior) {
        this.habitantesInferior = habitantesInferior;
    }

    public BigDecimal getHabitantesSuperior() {
        return habitantesSuperior;
    }

    public void setHabitantesSuperior(BigDecimal habitantesSuperior) {
        this.habitantesSuperior = habitantesSuperior;
    }

    public Long getIngresosCorrientes() {
        return ingresosCorrientes;
    }

    public void setIngresosCorrientes(Long ingresosCorrientes) {
        this.ingresosCorrientes = ingresosCorrientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.Categorias[ idCategoria=" + idCategoria + " ]";
    }
    
}
