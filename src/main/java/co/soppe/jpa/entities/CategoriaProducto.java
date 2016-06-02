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
@Table(name = "categoria_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaProducto.findAll", query = "SELECT c FROM CategoriaProducto c"),
    @NamedQuery(name = "CategoriaProducto.findByIdCategoriaProductos", query = "SELECT c FROM CategoriaProducto c WHERE c.idCategoriaProductos = :idCategoriaProductos"),
    @NamedQuery(name = "CategoriaProducto.findByCategoria", query = "SELECT c FROM CategoriaProducto c WHERE c.categoria = :categoria")})
public class CategoriaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria_productos")
    private Integer idCategoriaProductos;
    @Size(max = 45)
    @Column(name = "categoria")
    private String categoria;
    @OneToMany(mappedBy = "idCategoriaProductos")
    private List<Producto> productoList;
    @OneToMany(mappedBy = "idCategoriaProductos")
    private List<Bodega> bodegaList;

    public CategoriaProducto() {
    }

    public CategoriaProducto(Integer idCategoriaProductos) {
        this.idCategoriaProductos = idCategoriaProductos;
    }

    public Integer getIdCategoriaProductos() {
        return idCategoriaProductos;
    }

    public void setIdCategoriaProductos(Integer idCategoriaProductos) {
        this.idCategoriaProductos = idCategoriaProductos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @XmlTransient
    public List<Bodega> getBodegaList() {
        return bodegaList;
    }

    public void setBodegaList(List<Bodega> bodegaList) {
        this.bodegaList = bodegaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaProductos != null ? idCategoriaProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaProducto)) {
            return false;
        }
        CategoriaProducto other = (CategoriaProducto) object;
        if ((this.idCategoriaProductos == null && other.idCategoriaProductos != null) || (this.idCategoriaProductos != null && !this.idCategoriaProductos.equals(other.idCategoriaProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.CategoriaProducto[ idCategoriaProductos=" + idCategoriaProductos + " ]";
    }
    
}
