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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1
 */
@Entity
@Table(name = "lista_descuentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaDescuento.findAll", query = "SELECT l FROM ListaDescuento l"),
    @NamedQuery(name = "ListaDescuento.findByIdListaDescuentos", query = "SELECT l FROM ListaDescuento l WHERE l.idListaDescuentos = :idListaDescuentos"),
    @NamedQuery(name = "ListaDescuento.findByPorcentaje", query = "SELECT l FROM ListaDescuento l WHERE l.porcentaje = :porcentaje")})
public class ListaDescuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lista_descuentos")
    private Integer idListaDescuentos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private Double porcentaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listaDescuento")
    private List<ProductoHasListaDescuento> productoHasListaDescuentoList;

    public ListaDescuento() {
    }

    public ListaDescuento(Integer idListaDescuentos) {
        this.idListaDescuentos = idListaDescuentos;
    }

    public Integer getIdListaDescuentos() {
        return idListaDescuentos;
    }

    public void setIdListaDescuentos(Integer idListaDescuentos) {
        this.idListaDescuentos = idListaDescuentos;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @XmlTransient
    public List<ProductoHasListaDescuento> getProductoHasListaDescuentoList() {
        return productoHasListaDescuentoList;
    }

    public void setProductoHasListaDescuentoList(List<ProductoHasListaDescuento> productoHasListaDescuentoList) {
        this.productoHasListaDescuentoList = productoHasListaDescuentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idListaDescuentos != null ? idListaDescuentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaDescuento)) {
            return false;
        }
        ListaDescuento other = (ListaDescuento) object;
        if ((this.idListaDescuentos == null && other.idListaDescuentos != null) || (this.idListaDescuentos != null && !this.idListaDescuentos.equals(other.idListaDescuentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.ListaDescuento[ idListaDescuentos=" + idListaDescuentos + " ]";
    }
    
}
