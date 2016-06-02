/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Size(max = 45)
    @Column(name = "nombre")
    public String nombre;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "productoList")
    private List<Compra> compraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<DetalleFactura> detalleFacturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<ListaPrecio> listaPrecioList;
    @JoinColumn(name = "id_categoria_productos", referencedColumnName = "id_categoria_productos")
    @ManyToOne
    private CategoriaProducto idCategoriaProductos;
    @JoinColumn(name = "id_empaque", referencedColumnName = "id_empaque")
    @ManyToOne
    private Empaque idEmpaque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<ProductoHasListaDescuento> productoHasListaDescuentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<ProductoHasBodega> productoHasBodegaList;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @XmlTransient
    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    @XmlTransient
    public List<ListaPrecio> getListaPrecioList() {
        return listaPrecioList;
    }

    public void setListaPrecioList(List<ListaPrecio> listaPrecioList) {
        this.listaPrecioList = listaPrecioList;
    }

    public CategoriaProducto getIdCategoriaProductos() {
        return idCategoriaProductos;
    }

    public void setIdCategoriaProductos(CategoriaProducto idCategoriaProductos) {
        this.idCategoriaProductos = idCategoriaProductos;
    }

    public Empaque getIdEmpaque() {
        return idEmpaque;
    }

    public void setIdEmpaque(Empaque idEmpaque) {
        this.idEmpaque = idEmpaque;
    }

    @XmlTransient
    public List<ProductoHasListaDescuento> getProductoHasListaDescuentoList() {
        return productoHasListaDescuentoList;
    }

    public void setProductoHasListaDescuentoList(List<ProductoHasListaDescuento> productoHasListaDescuentoList) {
        this.productoHasListaDescuentoList = productoHasListaDescuentoList;
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
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
