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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1
 */
@Entity
@Table(name = "entradas_almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntradaAlmacen.findAll", query = "SELECT e FROM EntradaAlmacen e"),
    @NamedQuery(name = "EntradaAlmacen.findByIdEntradasAlmacen", query = "SELECT e FROM EntradaAlmacen e WHERE e.idEntradasAlmacen = :idEntradasAlmacen"),
    @NamedQuery(name = "EntradaAlmacen.findByFecha", query = "SELECT e FROM EntradaAlmacen e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "EntradaAlmacen.findByValor", query = "SELECT e FROM EntradaAlmacen e WHERE e.valor = :valor")})
public class EntradaAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entradas_almacen")
    private Integer idEntradasAlmacen;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "valor")
    private Integer valor;
    @JoinColumn(name = "id_proveedores", referencedColumnName = "id_proveedores")
    @ManyToOne
    private Proveedor idProveedores;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntradasAlmacen")
    private List<ProductoHasBodega> productoHasBodegaList;

    public EntradaAlmacen() {
    }

    public EntradaAlmacen(Integer idEntradasAlmacen) {
        this.idEntradasAlmacen = idEntradasAlmacen;
    }

    public Integer getIdEntradasAlmacen() {
        return idEntradasAlmacen;
    }

    public void setIdEntradasAlmacen(Integer idEntradasAlmacen) {
        this.idEntradasAlmacen = idEntradasAlmacen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Proveedor getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(Proveedor idProveedores) {
        this.idProveedores = idProveedores;
    }

    @XmlTransient
    public List<ProductoHasBodega> getProductoHasBodegaList() {
        return productoHasBodegaList;
    }

    public void setProductoHasBodegaList(List<ProductoHasBodega> productoHasBodegaList) {
        this.productoHasBodegaList = productoHasBodegaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntradasAlmacen != null ? idEntradasAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaAlmacen)) {
            return false;
        }
        EntradaAlmacen other = (EntradaAlmacen) object;
        if ((this.idEntradasAlmacen == null && other.idEntradasAlmacen != null) || (this.idEntradasAlmacen != null && !this.idEntradasAlmacen.equals(other.idEntradasAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.EntradaAlmacen[ idEntradasAlmacen=" + idEntradasAlmacen + " ]";
    }
    
}
