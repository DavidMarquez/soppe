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
 * @author adsi1
 */
@Embeddable
public class ProductoHasListaDescuentoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_lista_descuentos")
    private int idListaDescuentos;

    public ProductoHasListaDescuentoPK() {
    }

    public ProductoHasListaDescuentoPK(int idProducto, int idListaDescuentos) {
        this.idProducto = idProducto;
        this.idListaDescuentos = idListaDescuentos;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdListaDescuentos() {
        return idListaDescuentos;
    }

    public void setIdListaDescuentos(int idListaDescuentos) {
        this.idListaDescuentos = idListaDescuentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idListaDescuentos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoHasListaDescuentoPK)) {
            return false;
        }
        ProductoHasListaDescuentoPK other = (ProductoHasListaDescuentoPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idListaDescuentos != other.idListaDescuentos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.ProductoHasListaDescuentoPK[ idProducto=" + idProducto + ", idListaDescuentos=" + idListaDescuentos + " ]";
    }
    
}
