package com.apirest.efi.models.entity;

import java.io.Serializable;
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
@Table(name = "indicador_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndicadorGrupo.findAll", query = "SELECT i FROM IndicadorGrupo i")
    , @NamedQuery(name = "IndicadorGrupo.findByIdGrupo", query = "SELECT i FROM IndicadorGrupo i WHERE i.idGrupo = :idGrupo")
    , @NamedQuery(name = "IndicadorGrupo.findByNombreGrupo", query = "SELECT i FROM IndicadorGrupo i WHERE i.nombreGrupo = :nombreGrupo")
    , @NamedQuery(name = "IndicadorGrupo.findByFkTipo", query = "SELECT i FROM IndicadorGrupo i WHERE i.fkTipo = :fkTipo")
    , @NamedQuery(name = "IndicadorGrupo.findByFkEmpresa", query = "SELECT i FROM IndicadorGrupo i WHERE i.fkEmpresa = :fkEmpresa")
    , @NamedQuery(name = "IndicadorGrupo.findByEstado", query = "SELECT i FROM IndicadorGrupo i WHERE i.estado = :estado")})
public class IndicadorGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_grupo")
    private Integer idGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_grupo")
    private String nombreGrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_tipo")
    private int fkTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_empresa")
    private int fkEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;

    public IndicadorGrupo() {
    }

    public IndicadorGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public IndicadorGrupo(Integer idGrupo, String nombreGrupo, int fkTipo, int fkEmpresa, int estado) {
        this.idGrupo = idGrupo;
        this.nombreGrupo = nombreGrupo;
        this.fkTipo = fkTipo;
        this.fkEmpresa = fkEmpresa;
        this.estado = estado;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public int getFkTipo() {
        return fkTipo;
    }

    public void setFkTipo(int fkTipo) {
        this.fkTipo = fkTipo;
    }

    public int getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(int fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndicadorGrupo)) {
            return false;
        }
        IndicadorGrupo other = (IndicadorGrupo) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.IndicadorGrupo[ idGrupo=" + idGrupo + " ]";
    }
    
}
