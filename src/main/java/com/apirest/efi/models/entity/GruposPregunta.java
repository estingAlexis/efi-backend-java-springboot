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


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "grupos_pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GruposPregunta.findAll", query = "SELECT g FROM GruposPregunta g")
    , @NamedQuery(name = "GruposPregunta.findById", query = "SELECT g FROM GruposPregunta g WHERE g.id = :id")
    , @NamedQuery(name = "GruposPregunta.findByNombre", query = "SELECT g FROM GruposPregunta g WHERE g.nombre = :nombre")})
public class GruposPregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    

    public GruposPregunta() {
    }

    public GruposPregunta(Long id) {
        this.id = id;
    }

    public GruposPregunta(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GruposPregunta)) {
            return false;
        }
        GruposPregunta other = (GruposPregunta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.GruposPregunta[ id=" + id + " ]";
    }
    
}
