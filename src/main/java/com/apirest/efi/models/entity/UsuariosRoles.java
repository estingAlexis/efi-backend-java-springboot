/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.efi.models.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "usuarios_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosRoles.findAll", query = "SELECT u FROM UsuariosRoles u")
    , @NamedQuery(name = "UsuariosRoles.findByUsuarioId", query = "SELECT u FROM UsuariosRoles u WHERE u.usuariosRolesPK.usuarioId = :usuarioId")
    , @NamedQuery(name = "UsuariosRoles.findByRolesId", query = "SELECT u FROM UsuariosRoles u WHERE u.usuariosRolesPK.rolesId = :rolesId")})
public class UsuariosRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosRolesPK usuariosRolesPK;

    public UsuariosRoles() {
    }

    public UsuariosRoles(UsuariosRolesPK usuariosRolesPK) {
        this.usuariosRolesPK = usuariosRolesPK;
    }

    public UsuariosRoles(long usuarioId, long rolesId) {
        this.usuariosRolesPK = new UsuariosRolesPK(usuarioId, rolesId);
    }

    public UsuariosRolesPK getUsuariosRolesPK() {
        return usuariosRolesPK;
    }

    public void setUsuariosRolesPK(UsuariosRolesPK usuariosRolesPK) {
        this.usuariosRolesPK = usuariosRolesPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosRolesPK != null ? usuariosRolesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosRoles)) {
            return false;
        }
        UsuariosRoles other = (UsuariosRoles) object;
        if ((this.usuariosRolesPK == null && other.usuariosRolesPK != null) || (this.usuariosRolesPK != null && !this.usuariosRolesPK.equals(other.usuariosRolesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.UsuariosRoles[ usuariosRolesPK=" + usuariosRolesPK + " ]";
    }
    
}
