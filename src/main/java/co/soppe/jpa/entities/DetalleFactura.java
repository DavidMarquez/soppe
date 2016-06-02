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
@Table(name = "detalles_facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByIdDetallesFacturas", query = "SELECT d FROM DetalleFactura d WHERE d.idDetallesFacturas = :idDetallesFacturas"),
    @NamedQuery(name = "DetalleFactura.findByDetallesFacturas", query = "SELECT d FROM DetalleFactura d WHERE d.detallesFacturas = :detallesFacturas"),
    @NamedQuery(name = "DetalleFactura.findByCantidad", query = "SELECT d FROM DetalleFactura d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleFactura.findByDescuentoAdicional", query = "SELECT d FROM DetalleFactura d WHERE d.descuentoAdicional = :descuentoAdicional")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalles_facturas")
    private Integer idDetallesFacturas;
    @Size(max = 45)
    @Column(name = "detalles_facturas")
    private String detallesFacturas;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descuento_adicional")
    private Double descuentoAdicional;
    @JoinColumn(name = "id_facturas", referencedColumnName = "id_facturas")
    @ManyToOne(optional = false)
    private Factura idFacturas;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public DetalleFactura() {
    }

    public DetalleFactura(Integer idDetallesFacturas) {
        this.idDetallesFacturas = idDetallesFacturas;
    }

    public Integer getIdDetallesFacturas() {
        return idDetallesFacturas;
    }

    public void setIdDetallesFacturas(Integer idDetallesFacturas) {
        this.idDetallesFacturas = idDetallesFacturas;
    }

    public String getDetallesFacturas() {
        return detallesFacturas;
    }

    public void setDetallesFacturas(String detallesFacturas) {
        this.detallesFacturas = detallesFacturas;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getDescuentoAdicional() {
        return descuentoAdicional;
    }

    public void setDescuentoAdicional(Double descuentoAdicional) {
        this.descuentoAdicional = descuentoAdicional;
    }

    public Factura getIdFacturas() {
        return idFacturas;
    }

    public void setIdFacturas(Factura idFacturas) {
        this.idFacturas = idFacturas;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetallesFacturas != null ? idDetallesFacturas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.idDetallesFacturas == null && other.idDetallesFacturas != null) || (this.idDetallesFacturas != null && !this.idDetallesFacturas.equals(other.idDetallesFacturas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.DetalleFactura[ idDetallesFacturas=" + idDetallesFacturas + " ]";
    }
    
}
