/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "encuesta_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EncuestaDetalle.findAll", query = "SELECT e FROM EncuestaDetalle e")
    , @NamedQuery(name = "EncuestaDetalle.findById", query = "SELECT e FROM EncuestaDetalle e WHERE e.id = :id")
    , @NamedQuery(name = "EncuestaDetalle.findByRequerido", query = "SELECT e FROM EncuestaDetalle e WHERE e.requerido = :requerido")})
public class EncuestaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requerido")
    private short requerido;
    @JoinColumn(name = "id_encuesta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Encuestas idEncuesta;
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Preguntas idPregunta;

    public EncuestaDetalle() {
    }

    public EncuestaDetalle(Long id) {
        this.id = id;
    }

    public EncuestaDetalle(Long id, short requerido) {
        this.id = id;
        this.requerido = requerido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getRequerido() {
        return requerido;
    }

    public void setRequerido(short requerido) {
        this.requerido = requerido;
    }

    public Encuestas getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Encuestas idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public Preguntas getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Preguntas idPregunta) {
        this.idPregunta = idPregunta;
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
        if (!(object instanceof EncuestaDetalle)) {
            return false;
        }
        EncuestaDetalle other = (EncuestaDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.EncuestaDetalle[ id=" + id + " ]";
    }
    
}