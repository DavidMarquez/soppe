/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1
 */
@Entity
@Table(name = "responsabilidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsabilidad.findAll", query = "SELECT r FROM Responsabilidad r"),
    @NamedQuery(name = "Responsabilidad.findByIdResponsabilidad", query = "SELECT r FROM Responsabilidad r WHERE r.idResponsabilidad = :idResponsabilidad"),
    @NamedQuery(name = "Responsabilidad.findByDescripcion", query = "SELECT r FROM Responsabilidad r WHERE r.descripcion = :descripcion")})
public class Responsabilidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_responsabilidad")
    private Integer idResponsabilidad;
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_terceros", referencedColumnName = "id_terceros")
    @ManyToOne
    private Tercero idTerceros;

    public Responsabilidad() {
    }

    public Responsabilidad(Integer idResponsabilidad) {
        this.idResponsabilidad = idResponsabilidad;
    }

    public Integer getIdResponsabilidad() {
        return idResponsabilidad;
    }

    public void setIdResponsabilidad(Integer idResponsabilidad) {
        this.idResponsabilidad = idResponsabilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tercero getIdTerceros() {
        return idTerceros;
    }

    public void setIdTerceros(Tercero idTerceros) {
        this.idTerceros = idTerceros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResponsabilidad != null ? idResponsabilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsabilidad)) {
            return false;
        }
        Responsabilidad other = (Responsabilidad) object;
        if ((this.idResponsabilidad == null && other.idResponsabilidad != null) || (this.idResponsabilidad != null && !this.idResponsabilidad.equals(other.idResponsabilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.Responsabilidad[ idResponsabilidad=" + idResponsabilidad + " ]";
    }
    
}
