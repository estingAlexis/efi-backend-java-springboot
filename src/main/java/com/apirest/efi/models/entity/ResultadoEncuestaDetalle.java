/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.efi.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "resultado_encuesta_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoEncuestaDetalle.findAll", query = "SELECT r FROM ResultadoEncuestaDetalle r")
    , @NamedQuery(name = "ResultadoEncuestaDetalle.findById", query = "SELECT r FROM ResultadoEncuestaDetalle r WHERE r.id = :id")
    , @NamedQuery(name = "ResultadoEncuestaDetalle.findByResultado", query = "SELECT r FROM ResultadoEncuestaDetalle r WHERE r.resultado = :resultado")
    , @NamedQuery(name = "ResultadoEncuestaDetalle.findBySeguimiento", query = "SELECT r FROM ResultadoEncuestaDetalle r WHERE r.seguimiento = :seguimiento")
    , @NamedQuery(name = "ResultadoEncuestaDetalle.findByFechaSeguimiento", query = "SELECT r FROM ResultadoEncuestaDetalle r WHERE r.fechaSeguimiento = :fechaSeguimiento")})
public class ResultadoEncuestaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resultado")
    private short resultado;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seguimiento")
    private short seguimiento;
    @Column(name = "fecha_seguimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSeguimiento;
    @JoinColumn(name = "id_encuesta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Encuestas idEncuesta;
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Preguntas idPregunta;

    public ResultadoEncuestaDetalle() {
    }

    public ResultadoEncuestaDetalle(Long id) {
        this.id = id;
    }

    public ResultadoEncuestaDetalle(Long id, short resultado, String observacion, short seguimiento) {
        this.id = id;
        this.resultado = resultado;
        this.observacion = observacion;
        this.seguimiento = seguimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getResultado() {
        return resultado;
    }

    public void setResultado(short resultado) {
        this.resultado = resultado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public short getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(short seguimiento) {
        this.seguimiento = seguimiento;
    }

    public Date getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(Date fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
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
        if (!(object instanceof ResultadoEncuestaDetalle)) {
            return false;
        }
        ResultadoEncuestaDetalle other = (ResultadoEncuestaDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.ResultadoEncuestaDetalle[ id=" + id + " ]";
    }
    
}
