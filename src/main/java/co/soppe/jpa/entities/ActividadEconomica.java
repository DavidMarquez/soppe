/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1
 */
@Entity
@Table(name = "actividad_economica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadEconomica.findAll", query = "SELECT a FROM ActividadEconomica a"),
    @NamedQuery(name = "ActividadEconomica.findByIdActividad", query = "SELECT a FROM ActividadEconomica a WHERE a.idActividad = :idActividad"),
    @NamedQuery(name = "ActividadEconomica.findByActividadPrincipal", query = "SELECT a FROM ActividadEconomica a WHERE a.actividadPrincipal = :actividadPrincipal"),
    @NamedQuery(name = "ActividadEconomica.findByActividadSecundaria", query = "SELECT a FROM ActividadEconomica a WHERE a.actividadSecundaria = :actividadSecundaria"),
    @NamedQuery(name = "ActividadEconomica.findByOtrasActividades", query = "SELECT a FROM ActividadEconomica a WHERE a.otrasActividades = :otrasActividades"),
    @NamedQuery(name = "ActividadEconomica.findByFechaInicioPrincipal", query = "SELECT a FROM ActividadEconomica a WHERE a.fechaInicioPrincipal = :fechaInicioPrincipal"),
    @NamedQuery(name = "ActividadEconomica.findByFechaInicioSecundaria", query = "SELECT a FROM ActividadEconomica a WHERE a.fechaInicioSecundaria = :fechaInicioSecundaria")})
public class ActividadEconomica implements Serializable {
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadEconomica")
    private List<EmpresaHasActividadEconomica> empresaHasActividadEconomicaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actividad")
    private Integer idActividad;
    @Size(max = 20)
    @Column(name = "actividad_principal")
    private String actividadPrincipal;
    @Size(max = 20)
    @Column(name = "actividad_secundaria")
    private String actividadSecundaria;
    @Size(max = 20)
    @Column(name = "otras_actividades")
    private String otrasActividades;
    @Column(name = "fecha_inicio_principal")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioPrincipal;
    @Column(name = "fecha_inicio_secundaria")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioSecundaria;
    @JoinTable(name = "actividad_economica_has_terceros", joinColumns = {
        @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad")}, inverseJoinColumns = {
        @JoinColumn(name = "id_terceros", referencedColumnName = "id_terceros")})
    @ManyToMany
    private List<Tercero> terceroList;
    @JoinTable(name = "empresa_has_actividad_economica", joinColumns = {
        @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad")}, inverseJoinColumns = {
        @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")})
    @ManyToMany
    private List<Empresa> empresaList;

    public ActividadEconomica() {
    }

    public ActividadEconomica(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public void setActividadPrincipal(String actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }

    public String getActividadSecundaria() {
        return actividadSecundaria;
    }

    public void setActividadSecundaria(String actividadSecundaria) {
        this.actividadSecundaria = actividadSecundaria;
    }

    public String getOtrasActividades() {
        return otrasActividades;
    }

    public void setOtrasActividades(String otrasActividades) {
        this.otrasActividades = otrasActividades;
    }

    public Date getFechaInicioPrincipal() {
        return fechaInicioPrincipal;
    }

    public void setFechaInicioPrincipal(Date fechaInicioPrincipal) {
        this.fechaInicioPrincipal = fechaInicioPrincipal;
    }

    public Date getFechaInicioSecundaria() {
        return fechaInicioSecundaria;
    }

    public void setFechaInicioSecundaria(Date fechaInicioSecundaria) {
        this.fechaInicioSecundaria = fechaInicioSecundaria;
    }

    @XmlTransient
    public List<Tercero> getTerceroList() {
        return terceroList;
    }

    public void setTerceroList(List<Tercero> terceroList) {
        this.terceroList = terceroList;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividad != null ? idActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadEconomica)) {
            return false;
        }
        ActividadEconomica other = (ActividadEconomica) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.ActividadEconomica[ idActividad=" + idActividad + " ]";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<EmpresaHasActividadEconomica> getEmpresaHasActividadEconomicaList() {
        return empresaHasActividadEconomicaList;
    }

    public void setEmpresaHasActividadEconomicaList(List<EmpresaHasActividadEconomica> empresaHasActividadEconomicaList) {
        this.empresaHasActividadEconomicaList = empresaHasActividadEconomicaList;
    }
    
}
