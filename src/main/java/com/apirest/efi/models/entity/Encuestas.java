package com.apirest.efi.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "encuestas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuestas.findAll", query = "SELECT e FROM Encuestas e")
    , @NamedQuery(name = "Encuestas.findById", query = "SELECT e FROM Encuestas e WHERE e.id = :id")
    , @NamedQuery(name = "Encuestas.findByFecha", query = "SELECT e FROM Encuestas e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "Encuestas.findByEstado", query = "SELECT e FROM Encuestas e WHERE e.estado = :estado")})
public class Encuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEncuesta")
    private List<EncuestaDetalle> encuestaDetalleList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEncuesta")
    private List<ResultadoEncuesta> resultadoEncuestaList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEncuesta")
    private List<ResultadoEncuestaDetalle> resultadoEncuestaDetalleList;

    public Encuestas() {
    }

    public Encuestas(Long id) {
        this.id = id;
    }

    public Encuestas(Long id, String nombre, Date fecha, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.estado = estado;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    @JsonIgnore
    public List<EncuestaDetalle> getEncuestaDetalleList() {
        return encuestaDetalleList;
    }

    public void setEncuestaDetalleList(List<EncuestaDetalle> encuestaDetalleList) {
        this.encuestaDetalleList = encuestaDetalleList;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    @JsonIgnore
    public List<ResultadoEncuesta> getResultadoEncuestaList() {
        return resultadoEncuestaList;
    }

    public void setResultadoEncuestaList(List<ResultadoEncuesta> resultadoEncuestaList) {
        this.resultadoEncuestaList = resultadoEncuestaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<ResultadoEncuestaDetalle> getResultadoEncuestaDetalleList() {
        return resultadoEncuestaDetalleList;
    }

    public void setResultadoEncuestaDetalleList(List<ResultadoEncuestaDetalle> resultadoEncuestaDetalleList) {
        this.resultadoEncuestaDetalleList = resultadoEncuestaDetalleList;
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
        if (!(object instanceof Encuestas)) {
            return false;
        }
        Encuestas other = (Encuestas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.Encuestas[ id=" + id + " ]";
    }
    
}
