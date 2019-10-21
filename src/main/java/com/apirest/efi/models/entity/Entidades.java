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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "entidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidades.findAll", query = "SELECT e FROM Entidades e")
    , @NamedQuery(name = "Entidades.findByIdEntidad", query = "SELECT e FROM Entidades e WHERE e.idEntidad = :idEntidad")
    , @NamedQuery(name = "Entidades.findByCodigoChip", query = "SELECT e FROM Entidades e WHERE e.codigoChip = :codigoChip")
    , @NamedQuery(name = "Entidades.findByCodigoDane", query = "SELECT e FROM Entidades e WHERE e.codigoDane = :codigoDane")
    , @NamedQuery(name = "Entidades.findByTipo", query = "SELECT e FROM Entidades e WHERE e.tipo = :tipo")
    , @NamedQuery(name = "Entidades.findByEntidad", query = "SELECT e FROM Entidades e WHERE e.entidad = :entidad")
    , @NamedQuery(name = "Entidades.findByNit", query = "SELECT e FROM Entidades e WHERE e.nit = :nit")
    , @NamedQuery(name = "Entidades.findByDepartamento", query = "SELECT e FROM Entidades e WHERE e.departamento = :departamento")
    , @NamedQuery(name = "Entidades.findByCiudad", query = "SELECT e FROM Entidades e WHERE e.ciudad = :ciudad")
    , @NamedQuery(name = "Entidades.findByDireccion", query = "SELECT e FROM Entidades e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Entidades.findByCodigoPostal", query = "SELECT e FROM Entidades e WHERE e.codigoPostal = :codigoPostal")
    , @NamedQuery(name = "Entidades.findByTelefonos", query = "SELECT e FROM Entidades e WHERE e.telefonos = :telefonos")
    , @NamedQuery(name = "Entidades.findByFax", query = "SELECT e FROM Entidades e WHERE e.fax = :fax")
    , @NamedQuery(name = "Entidades.findByCorreo", query = "SELECT e FROM Entidades e WHERE e.correo = :correo")
    , @NamedQuery(name = "Entidades.findBySector", query = "SELECT e FROM Entidades e WHERE e.sector = :sector")
    , @NamedQuery(name = "Entidades.findByNaturaleza", query = "SELECT e FROM Entidades e WHERE e.naturaleza = :naturaleza")
    , @NamedQuery(name = "Entidades.findByPaginaWeb", query = "SELECT e FROM Entidades e WHERE e.paginaWeb = :paginaWeb")
    , @NamedQuery(name = "Entidades.findByFkCategoria", query = "SELECT e FROM Entidades e WHERE e.fkCategoria = :fkCategoria")})
public class Entidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_entidad")
    private Long idEntidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_chip")
    private int codigoChip;
    @Size(max = 50)
    @Column(name = "codigo_dane")
    private String codigoDane;
    @Size(max = 10)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Entidad")
    private String entidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private Integer estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Departamento")
    private String departamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Codigo_Postal")
    private Integer codigoPostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Telefonos")
    private String telefonos;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Fax")
    private String fax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Sector")
    private String sector;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Naturaleza")
    private String naturaleza;
    @Size(max = 100)
    @Column(name = "pagina_web")
    private String paginaWeb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_categoria")
    private long fkCategoria;

    public Entidades() {
    }

    public Entidades(Long idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Entidades(Long idEntidad, int codigoChip, String entidad, Integer estado, String nit, String departamento, String ciudad, String direccion, String telefonos, String fax, String correo, String sector, String naturaleza, long fkCategoria) {
        this.idEntidad = idEntidad;
        this.codigoChip = codigoChip;
        this.entidad = entidad;
        this.estado = estado;
        this.nit = nit;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.fax = fax;
        this.correo = correo;
        this.sector = sector;
        this.naturaleza = naturaleza;
        this.fkCategoria = fkCategoria;
    }

    public Long getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Long idEntidad) {
        this.idEntidad = idEntidad;
    }

    public int getCodigoChip() {
        return codigoChip;
    }

    public void setCodigoChip(int codigoChip) {
        this.codigoChip = codigoChip;
    }

    public String getCodigoDane() {
        return codigoDane;
    }

    public void setCodigoDane(String codigoDane) {
        this.codigoDane = codigoDane;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public long getFkCategoria() {
        return fkCategoria;
    }

    public void setFkCategoria(long fkCategoria) {
        this.fkCategoria = fkCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidad != null ? idEntidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidades)) {
            return false;
        }
        Entidades other = (Entidades) object;
        if ((this.idEntidad == null && other.idEntidad != null) || (this.idEntidad != null && !this.idEntidad.equals(other.idEntidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.Entidades[ idEntidad=" + idEntidad + " ]";
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
}
