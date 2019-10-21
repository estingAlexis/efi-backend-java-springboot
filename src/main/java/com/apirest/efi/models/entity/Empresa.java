package com.apirest.efi.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "contacto_nombre")
    private String contactoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contacto_cargo")
    private String contactoCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contacto_telefono")
    private String contactoTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contacto_email")
    private String contactoEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "licencia")
    private String licencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "orden")
    private String orden;
    @Column(name = "estado")
    private Integer estado;
    @Size(max = 200)
    @Column(name = "logo")
    private String logo;
    /* @Basic(optional = false)
    @NotNull
    @Column(name = "fk_entidad")
    private long Entidades; */
    @JoinColumn(name = "fk_entidad", referencedColumnName = "id_entidad")
    @ManyToOne(optional = false)
    private Entidades fkEntidad;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<Encuestas> encuestasList;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<ResultadoEncuesta> resultadoEncuestaList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<Preguntas> preguntasList;;

    public Empresa() {
    }

    public Empresa(Long id) {
        this.id = id;
    }

    public Empresa(Long id, String direccion, String telefono, String nit, String contactoNombre, String contactoCargo, String contactoTelefono, String contactoEmail, String licencia, String orden, long fkEntidad) {
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
        this.contactoNombre = contactoNombre;
        this.contactoCargo = contactoCargo;
        this.contactoTelefono = contactoTelefono;
        this.contactoEmail = contactoEmail;
        this.licencia = licencia;
        this.orden = orden;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getContactoNombre() {
        return contactoNombre;
    }

    public void setContactoNombre(String contactoNombre) {
        this.contactoNombre = contactoNombre;
    }

    public String getContactoCargo() {
        return contactoCargo;
    }

    public void setContactoCargo(String contactoCargo) {
        this.contactoCargo = contactoCargo;
    }

    public String getContactoTelefono() {
        return contactoTelefono;
    }

    public void setContactoTelefono(String contactoTelefono) {
        this.contactoTelefono = contactoTelefono;
    }

    public String getContactoEmail() {
        return contactoEmail;
    }

    public void setContactoEmail(String contactoEmail) {
        this.contactoEmail = contactoEmail;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

/*     public long getFkEntidad() {
        return fkEntidad;
    }

    public void setFkEntidad(long fkEntidad) {
        this.fkEntidad = fkEntidad;
    } */

/*     @XmlTransient
    @JsonIgnore
    public List<Encuestas> getEncuestasList() {
        return encuestasList;
    }

    public void setEncuestasList(List<Encuestas> encuestasList) {
        this.encuestasList = encuestasList;
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
    public List<Preguntas> getPreguntasList() {
        return preguntasList;
    }

    public void setPreguntasList(List<Preguntas> preguntasList) {
        this.preguntasList = preguntasList;
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
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.Empresa[ id=" + id + " ]";
    }

    public Entidades getFkEntidad() {
        return fkEntidad;
    }

    public void setFkEntidad(Entidades fkEntidad) {
        this.fkEntidad = fkEntidad;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
