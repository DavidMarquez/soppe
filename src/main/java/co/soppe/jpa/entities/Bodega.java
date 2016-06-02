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
@Table(name = "bodegas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b"),
    @NamedQuery(name = "Bodega.findByIdBodega", query = "SELECT b FROM Bodega b WHERE b.idBodega = :idBodega"),
    @NamedQuery(name = "Bodega.findByNombre", query = "SELECT b FROM Bodega b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "Bodega.findByCosto", query = "SELECT b FROM Bodega b WHERE b.costo = :costo")})
public class Bodega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bodega")
    private Integer idBodega;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "costo")
    private Integer costo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bodega")
    private List<ProductoHasBodega> productoHasBodegaList;
    @JoinColumn(name = "id_categoria_productos", referencedColumnName = "id_categoria_productos")
    @ManyToOne
    private CategoriaProducto idCategoriaProductos;
    @JoinColumn(name = "id_sedes", referencedColumnName = "id_sedes")
    @ManyToOne(optional = false)
    private Sede idSedes;

    public Bodega() {
    }

    public Bodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    @XmlTransient
    public List<ProductoHasBodega> getProductoHasBodegaList() {
        return productoHasBodegaList;
    }

    public void setProductoHasBodegaList(List<ProductoHasBodega> productoHasBodegaList) {
        this.productoHasBodegaList = productoHasBodegaList;
    }

    public CategoriaProducto getIdCategoriaProductos() {
        return idCategoriaProductos;
    }

    public void setIdCategoriaProductos(CategoriaProducto idCategoriaProductos) {
        this.idCategoriaProductos = idCategoriaProductos;
    }

    public Sede getIdSedes() {
        return idSedes;
    }

    public void setIdSedes(Sede idSedes) {
        this.idSedes = idSedes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBodega != null ? idBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.idBodega == null && other.idBodega != null) || (this.idBodega != null && !this.idBodega.equals(other.idBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.Bodega[ idBodega=" + idBodega + " ]";
    }
    
}
