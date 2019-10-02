package com.apirest.efi.models.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findById", query = "SELECT e FROM Empresa e WHERE e.id = :id")
    , @NamedQuery(name = "Empresa.findByNombre", query = "SELECT e FROM Empresa e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empresa.findByDireccion", query = "SELECT e FROM Empresa e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Empresa.findByTelefono", query = "SELECT e FROM Empresa e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Empresa.findByNit", query = "SELECT e FROM Empresa e WHERE e.nit = :nit")
    , @NamedQuery(name = "Empresa.findByContactoNombre", query = "SELECT e FROM Empresa e WHERE e.contactoNombre = :contactoNombre")
    , @NamedQuery(name = "Empresa.findByContactoCargo", query = "SELECT e FROM Empresa e WHERE e.contactoCargo = :contactoCargo")
    , @NamedQuery(name = "Empresa.findByContactoTelefono", query = "SELECT e FROM Empresa e WHERE e.contactoTelefono = :contactoTelefono")
    , @NamedQuery(name = "Empresa.findByContactoEmail", query = "SELECT e FROM Empresa e WHERE e.contactoEmail = :contactoEmail")
    , @NamedQuery(name = "Empresa.findByLicencia", query = "SELECT e FROM Empresa e WHERE e.licencia = :licencia")
    , @NamedQuery(name = "Empresa.findByOrden", query = "SELECT e FROM Empresa e WHERE e.orden = :orden")
    , @NamedQuery(name = "Empresa.findByEstado", query = "SELECT e FROM Empresa e WHERE e.estado = :estado")
    , @NamedQuery(name = "Empresa.findByLogo", query = "SELECT e FROM Empresa e WHERE e.logo = :logo")
    , @NamedQuery(name = "Empresa.findByFkEntidad", query = "SELECT e FROM Empresa e WHERE e.fkEntidad = :fkEntidad")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
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
    @Size(max = 2)
    @Column(name = "estado")
    private String estado;
    @Size(max = 200)
    @Column(name = "logo")
    private String logo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_entidad")
    private long fkEntidad;
/*     @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<Encuestas> encuestasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<ResultadoEncuesta> resultadoEncuestaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<Preguntas> preguntasList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empresa1")
    private Empresa empresa;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false) */
    //private Empresa empresa1;*/

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
        this.fkEntidad = fkEntidad;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public long getFkEntidad() {
        return fkEntidad;
    }

    public void setFkEntidad(long fkEntidad) {
        this.fkEntidad = fkEntidad;
    }

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
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empresa getEmpresa1() {
        return empresa1;
    }

    public void setEmpresa1(Empresa empresa1) {
        this.empresa1 = empresa1;
    }
    */

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
    
}
