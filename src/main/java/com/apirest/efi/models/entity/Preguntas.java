package com.apirest.efi.models.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "preguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p")
    , @NamedQuery(name = "Preguntas.findById", query = "SELECT p FROM Preguntas p WHERE p.id = :id")
    , @NamedQuery(name = "Preguntas.findByCodigo", query = "SELECT p FROM Preguntas p WHERE p.codigo = :codigo")})
public class Preguntas implements Serializable {

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
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "responsable")
    private String responsable;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "periodo")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codigo")
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPregunta")
    private List<EncuestaDetalle> encuestaDetalleList;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CategoriasPregunta idCategoria;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GruposPregunta idGrupo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPregunta")
    private List<ResultadoEncuestaDetalle> resultadoEncuestaDetalleList;

    public Preguntas() {
    }

    public Preguntas(Long id) {
        this.id = id;
    }

    public Preguntas(Long id, String descripcion, String responsable, String referencia, String periodo, String codigo) {
        this.id = id;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.referencia = referencia;
        this.periodo = periodo;
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

/*     @XmlTransient
    @JsonIgnore
    public List<EncuestaDetalle> getEncuestaDetalleList() {
        return encuestaDetalleList;
    }

    public void setEncuestaDetalleList(List<EncuestaDetalle> encuestaDetalleList) {
        this.encuestaDetalleList = encuestaDetalleList;
    }

    public CategoriasPregunta getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(CategoriasPregunta idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public GruposPregunta getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(GruposPregunta idGrupo) {
        this.idGrupo = idGrupo;
    }

    @XmlTransient
    @JsonIgnore
    public List<ResultadoEncuestaDetalle> getResultadoEncuestaDetalleList() {
        return resultadoEncuestaDetalleList;
    }

    public void setResultadoEncuestaDetalleList(List<ResultadoEncuestaDetalle> resultadoEncuestaDetalleList) {
        this.resultadoEncuestaDetalleList = resultadoEncuestaDetalleList;
    } */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preguntas)) {
            return false;
        }
        Preguntas other = (Preguntas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.Preguntas[ id=" + id + " ]";
    }
    
}
