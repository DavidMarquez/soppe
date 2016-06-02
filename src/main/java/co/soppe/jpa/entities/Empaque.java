/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1
 */
@Entity
@Table(name = "empaques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empaque.findAll", query = "SELECT e FROM Empaque e"),
    @NamedQuery(name = "Empaque.findByIdEmpaque", query = "SELECT e FROM Empaque e WHERE e.idEmpaque = :idEmpaque"),
    @NamedQuery(name = "Empaque.findByUnidadMedida", query = "SELECT e FROM Empaque e WHERE e.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "Empaque.findByCantidad", query = "SELECT e FROM Empaque e WHERE e.cantidad = :cantidad")})
public class Empaque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empaque")
    private Integer idEmpaque;
    @Size(max = 45)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Column(name = "cantidad")
    private Integer cantidad;
    @OneToMany(mappedBy = "idEmpaque")
    private List<Producto> productoList;

    public Empaque() {
    }

    public Empaque(Integer idEmpaque) {
        this.idEmpaque = idEmpaque;
    }

    public Integer getIdEmpaque() {
        return idEmpaque;
    }

    public void setIdEmpaque(Integer idEmpaque) {
        this.idEmpaque = idEmpaque;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpaque != null ? idEmpaque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empaque)) {
            return false;
        }
        Empaque other = (Empaque) object;
        if ((this.idEmpaque == null && other.idEmpaque != null) || (this.idEmpaque != null && !this.idEmpaque.equals(other.idEmpaque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.Empaque[ idEmpaque=" + idEmpaque + " ]";
    }
    
}
