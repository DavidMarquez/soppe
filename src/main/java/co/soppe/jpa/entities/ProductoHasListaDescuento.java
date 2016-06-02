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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1
 */
@Entity
@Table(name = "productos_has_lista_descuentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoHasListaDescuento.findAll", query = "SELECT p FROM ProductoHasListaDescuento p"),
    @NamedQuery(name = "ProductoHasListaDescuento.findByFechaInicioDescuento", query = "SELECT p FROM ProductoHasListaDescuento p WHERE p.fechaInicioDescuento = :fechaInicioDescuento"),
    @NamedQuery(name = "ProductoHasListaDescuento.findByFechaFinDescuento", query = "SELECT p FROM ProductoHasListaDescuento p WHERE p.fechaFinDescuento = :fechaFinDescuento"),
    @NamedQuery(name = "ProductoHasListaDescuento.findByIdProducto", query = "SELECT p FROM ProductoHasListaDescuento p WHERE p.productoHasListaDescuentoPK.idProducto = :idProducto"),
    @NamedQuery(name = "ProductoHasListaDescuento.findByIdListaDescuentos", query = "SELECT p FROM ProductoHasListaDescuento p WHERE p.productoHasListaDescuentoPK.idListaDescuentos = :idListaDescuentos")})
public class ProductoHasListaDescuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoHasListaDescuentoPK productoHasListaDescuentoPK;
    @Column(name = "fecha_inicio_descuento")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioDescuento;
    @Column(name = "fecha_fin_descuento")
    @Temporal(TemporalType.DATE)
    private Date fechaFinDescuento;
    @JoinColumn(name = "id_lista_descuentos", referencedColumnName = "id_lista_descuentos", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ListaDescuento listaDescuento;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public ProductoHasListaDescuento() {
    }

    public ProductoHasListaDescuento(ProductoHasListaDescuentoPK productoHasListaDescuentoPK) {
        this.productoHasListaDescuentoPK = productoHasListaDescuentoPK;
    }

    public ProductoHasListaDescuento(int idProducto, int idListaDescuentos) {
        this.productoHasListaDescuentoPK = new ProductoHasListaDescuentoPK(idProducto, idListaDescuentos);
    }

    public ProductoHasListaDescuentoPK getProductoHasListaDescuentoPK() {
        return productoHasListaDescuentoPK;
    }

    public void setProductoHasListaDescuentoPK(ProductoHasListaDescuentoPK productoHasListaDescuentoPK) {
        this.productoHasListaDescuentoPK = productoHasListaDescuentoPK;
    }

    public Date getFechaInicioDescuento() {
        return fechaInicioDescuento;
    }

    public void setFechaInicioDescuento(Date fechaInicioDescuento) {
        this.fechaInicioDescuento = fechaInicioDescuento;
    }

    public Date getFechaFinDescuento() {
        return fechaFinDescuento;
    }

    public void setFechaFinDescuento(Date fechaFinDescuento) {
        this.fechaFinDescuento = fechaFinDescuento;
    }

    public ListaDescuento getListaDescuento() {
        return listaDescuento;
    }

    public void setListaDescuento(ListaDescuento listaDescuento) {
        this.listaDescuento = listaDescuento;
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
        hash += (productoHasListaDescuentoPK != null ? productoHasListaDescuentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoHasListaDescuento)) {
            return false;
        }
        ProductoHasListaDescuento other = (ProductoHasListaDescuento) object;
        if ((this.productoHasListaDescuentoPK == null && other.productoHasListaDescuentoPK != null) || (this.productoHasListaDescuentoPK != null && !this.productoHasListaDescuentoPK.equals(other.productoHasListaDescuentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.ProductoHasListaDescuento[ productoHasListaDescuentoPK=" + productoHasListaDescuentoPK + " ]";
    }
    
}
