/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.efi.models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ricardo
 */
@Embeddable
public class UsuariosRolesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id")
    private long usuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roles_id")
    private long rolesId;

    public UsuariosRolesPK() {
    }

    public UsuariosRolesPK(long usuarioId, long rolesId) {
        this.usuarioId = usuarioId;
        this.rolesId = rolesId;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public long getRolesId() {
        return rolesId;
    }

    public void setRolesId(long rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioId;
        hash += (int) rolesId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosRolesPK)) {
            return false;
        }
        UsuariosRolesPK other = (UsuariosRolesPK) object;
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        if (this.rolesId != other.rolesId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apirest.efi.models.entity.UsuariosRolesPK[ usuarioId=" + usuarioId + ", rolesId=" + rolesId + " ]";
    }
    
}
