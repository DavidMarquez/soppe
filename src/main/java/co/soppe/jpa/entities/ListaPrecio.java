/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1
 */
@Entity
@Table(name = "lista_precios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaPrecio.findAll", query = "SELECT l FROM ListaPrecio l"),
    @NamedQuery(name = "ListaPrecio.findByIdListaPrecios", query = "SELECT l FROM ListaPrecio l WHERE l.idListaPrecios = :idListaPrecios"),
    @NamedQuery(name = "ListaPrecio.findByFechaActualPrecios", query = "SELECT l FROM ListaPrecio l WHERE l.fechaActualPrecios = :fechaActualPrecios"),
    @NamedQuery(name = "ListaPrecio.findByPrecio", query = "SELECT l FROM ListaPrecio l WHERE l.precio = :precio")})
public class ListaPrecio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lista_precios")
    private Integer idListaPrecios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_actual_precios")
    @Temporal(TemporalType.DATE)
    private Date fechaActualPrecios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public ListaPrecio() {
    }

    public ListaPrecio(Integer idListaPrecios) {
        this.idListaPrecios = idListaPrecios;
    }

    public ListaPrecio(Integer idListaPrecios, Date fechaActualPrecios, int precio) {
        this.idListaPrecios = idListaPrecios;
        this.fechaActualPrecios = fechaActualPrecios;
        this.precio = precio;
    }

    public Integer getIdListaPrecios() {
        return idListaPrecios;
    }

    public void setIdListaPrecios(Integer idListaPrecios) {
        this.idListaPrecios = idListaPrecios;
    }

    public Date getFechaActualPrecios() {
        return fechaActualPrecios;
    }

    public void setFechaActualPrecios(Date fechaActualPrecios) {
        this.fechaActualPrecios = fechaActualPrecios;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
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
        hash += (idListaPrecios != null ? idListaPrecios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaPrecio)) {
            return false;
        }
        ListaPrecio other = (ListaPrecio) object;
        if ((this.idListaPrecios == null && other.idListaPrecios != null) || (this.idListaPrecios != null && !this.idListaPrecios.equals(other.idListaPrecios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.ListaPrecio[ idListaPrecios=" + idListaPrecios + " ]";
    }
    
}
