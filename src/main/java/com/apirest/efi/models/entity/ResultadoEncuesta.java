package com.apirest.efi.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "resultado_encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoEncuesta.findAll", query = "SELECT r FROM ResultadoEncuesta r")
    , @NamedQuery(name = "ResultadoEncuesta.findById", query = "SELECT r FROM ResultadoEncuesta r WHERE r.id = :id")
    , @NamedQuery(name = "ResultadoEncuesta.findByIdEntidad", query = "SELECT r FROM ResultadoEncuesta r WHERE r.idEntidad = :idEntidad")
    , @NamedQuery(name = "ResultadoEncuesta.findByFecha", query = "SELECT r FROM ResultadoEncuesta r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "ResultadoEncuesta.findByPeriodo", query = "SELECT r FROM ResultadoEncuesta r WHERE r.periodo = :periodo")})
public class ResultadoEncuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id" )
    private Long id;
    @Basic(optional = false)
    @NotNull
     @JoinColumn(name = "id_entidad", referencedColumnName = "id_entidad")
    @ManyToOne(optional = false)
    private Entidades idEntidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "periodo")
    private String periodo;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;
    @JoinColumn(name = "id_encuesta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Encuestas idEncuesta;
    
    @NotNull
    @Column(name = "estado")
    private int estado;
    

    public ResultadoEncuesta() {
    }

    public ResultadoEncuesta(Long id) {
        this.id = id;
    }

    public ResultadoEncuesta(Long id, Entidades idEntidad, Date fecha, String periodo) {
        this.id = id;
        this.idEntidad = idEntidad;
        this.fecha = fecha;
        this.periodo = periodo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Encuestas getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Encuestas idEncuesta) {
        this.idEncuesta = idEncuesta;
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
        if (!(object instanceof ResultadoEncuesta)) {
            return false;
        }
        ResultadoEncuesta other = (ResultadoEncuesta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.ResultadoEncuesta[ id=" + id + " ]";
    }

    /**
     * @return the idEntidad
     */
    public Entidades getIdEntidad() {
        return idEntidad;
    }

    /**
     * @param idEntidad the idEntidad to set
     */
    public void setIdEntidad(Entidades idEntidad) {
        this.idEntidad = idEntidad;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
