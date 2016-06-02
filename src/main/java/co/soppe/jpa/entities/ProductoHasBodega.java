/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "productos_has_bodegas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoHasBodega.findAll", query = "SELECT p FROM ProductoHasBodega p"),
    @NamedQuery(name = "ProductoHasBodega.findByIdProducto", query = "SELECT p FROM ProductoHasBodega p WHERE p.productoHasBodegaPK.idProducto = :idProducto"),
    @NamedQuery(name = "ProductoHasBodega.findByIdBodega", query = "SELECT p FROM ProductoHasBodega p WHERE p.productoHasBodegaPK.idBodega = :idBodega"),
    @NamedQuery(name = "ProductoHasBodega.findByCantidad", query = "SELECT p FROM ProductoHasBodega p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "ProductoHasBodega.findByPrecio", query = "SELECT p FROM ProductoHasBodega p WHERE p.precio = :precio"),
    @NamedQuery(name = "ProductoHasBodega.findByEstado", query = "SELECT p FROM ProductoHasBodega p WHERE p.estado = :estado")})
public class ProductoHasBodega implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoHasBodegaPK productoHasBodegaPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "id_bodega", referencedColumnName = "id_bodega", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bodega bodega;
    @JoinColumn(name = "id_entradas_almacen", referencedColumnName = "id_entradas_almacen")
    @ManyToOne(optional = false)
    private EntradaAlmacen idEntradasAlmacen;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public ProductoHasBodega() {
    }

    public ProductoHasBodega(ProductoHasBodegaPK productoHasBodegaPK) {
        this.productoHasBodegaPK = productoHasBodegaPK;
    }

    public ProductoHasBodega(int idProducto, int idBodega) {
        this.productoHasBodegaPK = new ProductoHasBodegaPK(idProducto, idBodega);
    }

    public ProductoHasBodegaPK getProductoHasBodegaPK() {
        return productoHasBodegaPK;
    }

    public void setProductoHasBodegaPK(ProductoHasBodegaPK productoHasBodegaPK) {
        this.productoHasBodegaPK = productoHasBodegaPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public EntradaAlmacen getIdEntradasAlmacen() {
        return idEntradasAlmacen;
    }

    public void setIdEntradasAlmacen(EntradaAlmacen idEntradasAlmacen) {
        this.idEntradasAlmacen = idEntradasAlmacen;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoHasBodegaPK != null ? productoHasBodegaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoHasBodega)) {
            return false;
        }
        ProductoHasBodega other = (ProductoHasBodega) object;
        if ((this.productoHasBodegaPK == null && other.productoHasBodegaPK != null) || (this.productoHasBodegaPK != null && !this.productoHasBodegaPK.equals(other.productoHasBodegaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.ProductoHasBodega[ productoHasBodegaPK=" + productoHasBodegaPK + " ]";
    }
    
}
