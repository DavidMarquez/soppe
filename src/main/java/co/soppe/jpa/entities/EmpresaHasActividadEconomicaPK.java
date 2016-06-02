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
 * @author Luis
 */
@Embeddable
public class EmpresaHasActividadEconomicaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empresa")
    private int idEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_actividad")
    private int idActividad;

    public EmpresaHasActividadEconomicaPK() {
    }

    public EmpresaHasActividadEconomicaPK(int idEmpresa, int idActividad) {
        this.idEmpresa = idEmpresa;
        this.idActividad = idActividad;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEmpresa;
        hash += (int) idActividad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaHasActividadEconomicaPK)) {
            return false;
        }
        EmpresaHasActividadEconomicaPK other = (EmpresaHasActividadEconomicaPK) object;
        if (this.idEmpresa != other.idEmpresa) {
            return false;
        }
        if (this.idActividad != other.idActividad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.EmpresaHasActividadEconomicaPK[ idEmpresa=" + idEmpresa + ", idActividad=" + idActividad + " ]";
    }
    
}
