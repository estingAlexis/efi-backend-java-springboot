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
@Table(name = "calendario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendario.findAll", query = "SELECT c FROM Calendario c")
    , @NamedQuery(name = "Calendario.findByIdCalendario", query = "SELECT c FROM Calendario c WHERE c.idCalendario = :idCalendario")
    , @NamedQuery(name = "Calendario.findByPeriodo", query = "SELECT c FROM Calendario c WHERE c.periodo = :periodo")
    , @NamedQuery(name = "Calendario.findByCodigoChip", query = "SELECT c FROM Calendario c WHERE c.codigoChip = :codigoChip")
    , @NamedQuery(name = "Calendario.findByDescripcionChip", query = "SELECT c FROM Calendario c WHERE c.descripcionChip = :descripcionChip")
    , @NamedQuery(name = "Calendario.findByFechaInicio", query = "SELECT c FROM Calendario c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Calendario.findByFechaFinal", query = "SELECT c FROM Calendario c WHERE c.fechaFinal = :fechaFinal")
    , @NamedQuery(name = "Calendario.findByOportuno", query = "SELECT c FROM Calendario c WHERE c.oportuno = :oportuno")
    , @NamedQuery(name = "Calendario.findByExtemporaneo", query = "SELECT c FROM Calendario c WHERE c.extemporaneo = :extemporaneo")})
public class Calendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_calendario")
    private Integer idCalendario;
    @Size(max = 10)
    @Column(name = "periodo")
    private String periodo;
    @Size(max = 10)
    @Column(name = "codigo_chip")
    private String codigoChip;
    @Size(max = 20)
    @Column(name = "descripcion_chip")
    private String descripcionChip;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Column(name = "oportuno")
    @Temporal(TemporalType.DATE)
    private Date oportuno;
    @Column(name = "extemporaneo")
    @Temporal(TemporalType.DATE)
    private Date extemporaneo;

    public Calendario() {
    }

    public Calendario(Integer idCalendario) {
        this.idCalendario = idCalendario;
    }

    public Integer getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(Integer idCalendario) {
        this.idCalendario = idCalendario;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCodigoChip() {
        return codigoChip;
    }

    public void setCodigoChip(String codigoChip) {
        this.codigoChip = codigoChip;
    }

    public String getDescripcionChip() {
        return descripcionChip;
    }

    public void setDescripcionChip(String descripcionChip) {
        this.descripcionChip = descripcionChip;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getOportuno() {
        return oportuno;
    }

    public void setOportuno(Date oportuno) {
        this.oportuno = oportuno;
    }

    public Date getExtemporaneo() {
        return extemporaneo;
    }

    public void setExtemporaneo(Date extemporaneo) {
        this.extemporaneo = extemporaneo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalendario != null ? idCalendario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendario)) {
            return false;
        }
        Calendario other = (Calendario) object;
        if ((this.idCalendario == null && other.idCalendario != null) || (this.idCalendario != null && !this.idCalendario.equals(other.idCalendario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.Calendario[ idCalendario=" + idCalendario + " ]";
    }
    
}
