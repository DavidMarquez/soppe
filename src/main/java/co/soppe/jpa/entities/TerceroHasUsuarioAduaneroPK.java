/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author adsi1
 */
@Embeddable
public class TerceroHasUsuarioAduaneroPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuarios_aduaneros")
    private int idUsuariosAduaneros;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_terceros")
    private int idTerceros;

    public TerceroHasUsuarioAduaneroPK() {
    }

    public TerceroHasUsuarioAduaneroPK(int idUsuariosAduaneros, int idTerceros) {
        this.idUsuariosAduaneros = idUsuariosAduaneros;
        this.idTerceros = idTerceros;
    }

    public int getIdUsuariosAduaneros() {
        return idUsuariosAduaneros;
    }

    public void setIdUsuariosAduaneros(int idUsuariosAduaneros) {
        this.idUsuariosAduaneros = idUsuariosAduaneros;
    }

    public int getIdTerceros() {
        return idTerceros;
    }

    public void setIdTerceros(int idTerceros) {
        this.idTerceros = idTerceros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuariosAduaneros;
        hash += (int) idTerceros;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TerceroHasUsuarioAduaneroPK)) {
            return false;
        }
        TerceroHasUsuarioAduaneroPK other = (TerceroHasUsuarioAduaneroPK) object;
        if (this.idUsuariosAduaneros != other.idUsuariosAduaneros) {
            return false;
        }
        if (this.idTerceros != other.idTerceros) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.TerceroHasUsuarioAduaneroPK[ idUsuariosAduaneros=" + idUsuariosAduaneros + ", idTerceros=" + idTerceros + " ]";
    }
    
}
