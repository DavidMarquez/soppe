/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Luis
 */
@Embeddable
public class ProductoHasBodegaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_bodega")
    private int idBodega;

    public ProductoHasBodegaPK() {
    }

    public ProductoHasBodegaPK(int idProducto, int idBodega) {
        this.idProducto = idProducto;
        this.idBodega = idBodega;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idBodega;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoHasBodegaPK)) {
            return false;
        }
        ProductoHasBodegaPK other = (ProductoHasBodegaPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idBodega != other.idBodega) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.ProductoHasBodegaPK[ idProducto=" + idProducto + ", idBodega=" + idBodega + " ]";
    }
    
}
