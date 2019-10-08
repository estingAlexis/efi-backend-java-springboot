
package com.apirest.efi.models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "indicador_variables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndicadorVariables.findAll", query = "SELECT i FROM IndicadorVariables i")
    , @NamedQuery(name = "IndicadorVariables.findByIdVariable", query = "SELECT i FROM IndicadorVariables i WHERE i.idVariable = :idVariable")
    , @NamedQuery(name = "IndicadorVariables.findByNombreVariable", query = "SELECT i FROM IndicadorVariables i WHERE i.nombreVariable = :nombreVariable")
    , @NamedQuery(name = "IndicadorVariables.findByFkEmpresa", query = "SELECT i FROM IndicadorVariables i WHERE i.fkEmpresa = :fkEmpresa")
    , @NamedQuery(name = "IndicadorVariables.findByEstado", query = "SELECT i FROM IndicadorVariables i WHERE i.estado = :estado")
    , @NamedQuery(name = "IndicadorVariables.findByCodigoFut", query = "SELECT i FROM IndicadorVariables i WHERE i.codigoFut = :codigoFut")})
public class IndicadorVariables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_variable")
    private Integer idVariable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_variable")
    private String nombreVariable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_empresa")
    private int fkEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Column(name = "codigo_fut")
    private Integer codigoFut;
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "fk_grupo", referencedColumnName = "id_grupo")
    @ManyToOne(optional = false)
    private IndicadorGrupo fkGrupo;
    

    public IndicadorVariables() {
    }

    public IndicadorVariables(Integer idVariable) {
        this.idVariable = idVariable;
    }

    public IndicadorVariables(Integer idVariable, String nombreVariable, int fkEmpresa, int estado) {
        this.idVariable = idVariable;
        this.nombreVariable = nombreVariable;
        this.fkEmpresa = fkEmpresa;
        this.estado = estado;
    }

    public Integer getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Integer idVariable) {
        this.idVariable = idVariable;
    }

    public String getNombreVariable() {
        return nombreVariable;
    }

    public void setNombreVariable(String nombreVariable) {
        this.nombreVariable = nombreVariable;
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

    public Integer getCodigoFut() {
        return codigoFut;
    }

    public void setCodigoFut(Integer codigoFut) {
        this.codigoFut = codigoFut;
    }

    public IndicadorGrupo getFkGrupo() {
        return fkGrupo;
    }

    public void setFkGrupo(IndicadorGrupo fkGrupo) {
        this.fkGrupo = fkGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVariable != null ? idVariable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndicadorVariables)) {
            return false;
        }
        IndicadorVariables other = (IndicadorVariables) object;
        if ((this.idVariable == null && other.idVariable != null) || (this.idVariable != null && !this.idVariable.equals(other.idVariable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.IndicadorVariables[ idVariable=" + idVariable + " ]";
    }
    
}
