/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "empresa_has_actividad_economica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaHasActividadEconomica.findAll", query = "SELECT e FROM EmpresaHasActividadEconomica e"),
    @NamedQuery(name = "EmpresaHasActividadEconomica.findByIdEmpresa", query = "SELECT e FROM EmpresaHasActividadEconomica e WHERE e.empresaHasActividadEconomicaPK.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "EmpresaHasActividadEconomica.findByIdActividad", query = "SELECT e FROM EmpresaHasActividadEconomica e WHERE e.empresaHasActividadEconomicaPK.idActividad = :idActividad"),
    @NamedQuery(name = "EmpresaHasActividadEconomica.findByTipoActividad", query = "SELECT e FROM EmpresaHasActividadEconomica e WHERE e.tipoActividad = :tipoActividad"),
    @NamedQuery(name = "EmpresaHasActividadEconomica.findByFechaInicial", query = "SELECT e FROM EmpresaHasActividadEconomica e WHERE e.fechaInicial = :fechaInicial")})
public class EmpresaHasActividadEconomica implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpresaHasActividadEconomicaPK empresaHasActividadEconomicaPK;
    @Size(max = 20)
    @Column(name = "tipo_actividad")
    private String tipoActividad;
    @Column(name = "fecha_inicial")
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ActividadEconomica actividadEconomica;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;

    public EmpresaHasActividadEconomica() {
    }

    public EmpresaHasActividadEconomica(EmpresaHasActividadEconomicaPK empresaHasActividadEconomicaPK) {
        this.empresaHasActividadEconomicaPK = empresaHasActividadEconomicaPK;
    }

    public EmpresaHasActividadEconomica(int idEmpresa, int idActividad) {
        this.empresaHasActividadEconomicaPK = new EmpresaHasActividadEconomicaPK(idEmpresa, idActividad);
    }

    public EmpresaHasActividadEconomicaPK getEmpresaHasActividadEconomicaPK() {
        return empresaHasActividadEconomicaPK;
    }

    public void setEmpresaHasActividadEconomicaPK(EmpresaHasActividadEconomicaPK empresaHasActividadEconomicaPK) {
        this.empresaHasActividadEconomicaPK = empresaHasActividadEconomicaPK;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public ActividadEconomica getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(ActividadEconomica actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empresaHasActividadEconomicaPK != null ? empresaHasActividadEconomicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaHasActividadEconomica)) {
            return false;
        }
        EmpresaHasActividadEconomica other = (EmpresaHasActividadEconomica) object;
        if ((this.empresaHasActividadEconomicaPK == null && other.empresaHasActividadEconomicaPK != null) || (this.empresaHasActividadEconomicaPK != null && !this.empresaHasActividadEconomicaPK.equals(other.empresaHasActividadEconomicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.EmpresaHasActividadEconomica[ empresaHasActividadEconomicaPK=" + empresaHasActividadEconomicaPK + " ]";
    }
    
}
