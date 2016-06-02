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
public class CiudadPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_ciudad")
    private int idCiudad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_departamentos")
    private int idDepartamentos;

    public CiudadPK() {
    }

    public CiudadPK(int idCiudad, int idDepartamentos) {
        this.idCiudad = idCiudad;
        this.idDepartamentos = idDepartamentos;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getIdDepartamentos() {
        return idDepartamentos;
    }

    public void setIdDepartamentos(int idDepartamentos) {
        this.idDepartamentos = idDepartamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCiudad;
        hash += (int) idDepartamentos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CiudadPK)) {
            return false;
        }
        CiudadPK other = (CiudadPK) object;
        if (this.idCiudad != other.idCiudad) {
            return false;
        }
        if (this.idDepartamentos != other.idDepartamentos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.CiudadPK[ idCiudad=" + idCiudad + ", idDepartamentos=" + idDepartamentos + " ]";
    }
    
}
