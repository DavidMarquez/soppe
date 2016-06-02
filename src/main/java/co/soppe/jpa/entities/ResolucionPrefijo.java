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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1
 */
@Entity
@Table(name = "resolucion_prefijos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResolucionPrefijo.findAll", query = "SELECT r FROM ResolucionPrefijo r"),
    @NamedQuery(name = "ResolucionPrefijo.findByIdResolucionPrefijos", query = "SELECT r FROM ResolucionPrefijo r WHERE r.idResolucionPrefijos = :idResolucionPrefijos"),
    @NamedQuery(name = "ResolucionPrefijo.findByDesde", query = "SELECT r FROM ResolucionPrefijo r WHERE r.desde = :desde"),
    @NamedQuery(name = "ResolucionPrefijo.findByHasta", query = "SELECT r FROM ResolucionPrefijo r WHERE r.hasta = :hasta"),
    @NamedQuery(name = "ResolucionPrefijo.findByAutorizacion", query = "SELECT r FROM ResolucionPrefijo r WHERE r.autorizacion = :autorizacion"),
    @NamedQuery(name = "ResolucionPrefijo.findByFechaResolucion", query = "SELECT r FROM ResolucionPrefijo r WHERE r.fechaResolucion = :fechaResolucion")})
public class ResolucionPrefijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_resolucion_prefijos")
    private Integer idResolucionPrefijos;
    @Column(name = "desde")
    private Integer desde;
    @Column(name = "hasta")
    private Integer hasta;
    @Column(name = "autorizacion")
    private Boolean autorizacion;
    @Column(name = "fecha_resolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaResolucion;
    @JoinTable(name = "resolucion_prefijos_has_sedes", joinColumns = {
        @JoinColumn(name = "id_resolucion_prefijos", referencedColumnName = "id_resolucion_prefijos")}, inverseJoinColumns = {
        @JoinColumn(name = "id_sedes", referencedColumnName = "id_sedes")})
    @ManyToMany
    private List<Sede> sedeList;
    @JoinColumn(name = "prefijos_id_prefijos", referencedColumnName = "id_prefijos")
    @ManyToOne(optional = false)
    private Prefijo prefijosIdPrefijos;

    public ResolucionPrefijo() {
    }

    public ResolucionPrefijo(Integer idResolucionPrefijos) {
        this.idResolucionPrefijos = idResolucionPrefijos;
    }

    public Integer getIdResolucionPrefijos() {
        return idResolucionPrefijos;
    }

    public void setIdResolucionPrefijos(Integer idResolucionPrefijos) {
        this.idResolucionPrefijos = idResolucionPrefijos;
    }

    public Integer getDesde() {
        return desde;
    }

    public void setDesde(Integer desde) {
        this.desde = desde;
    }

    public Integer getHasta() {
        return hasta;
    }

    public void setHasta(Integer hasta) {
        this.hasta = hasta;
    }

    public Boolean getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(Boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    @XmlTransient
    public List<Sede> getSedeList() {
        return sedeList;
    }

    public void setSedeList(List<Sede> sedeList) {
        this.sedeList = sedeList;
    }

    public Prefijo getPrefijosIdPrefijos() {
        return prefijosIdPrefijos;
    }

    public void setPrefijosIdPrefijos(Prefijo prefijosIdPrefijos) {
        this.prefijosIdPrefijos = prefijosIdPrefijos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResolucionPrefijos != null ? idResolucionPrefijos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResolucionPrefijo)) {
            return false;
        }
        ResolucionPrefijo other = (ResolucionPrefijo) object;
        if ((this.idResolucionPrefijos == null && other.idResolucionPrefijos != null) || (this.idResolucionPrefijos != null && !this.idResolucionPrefijos.equals(other.idResolucionPrefijos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.ResolucionPrefijo[ idResolucionPrefijos=" + idResolucionPrefijos + " ]";
    }
    
}
