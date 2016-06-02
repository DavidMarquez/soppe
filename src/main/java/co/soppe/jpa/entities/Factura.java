/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1
 */
@Entity
@Table(name = "facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdFacturas", query = "SELECT f FROM Factura f WHERE f.idFacturas = :idFacturas"),
    @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Factura.findByTotal", query = "SELECT f FROM Factura f WHERE f.total = :total"),
    @NamedQuery(name = "Factura.findByIva", query = "SELECT f FROM Factura f WHERE f.iva = :iva"),
    @NamedQuery(name = "Factura.findByIdTurnos", query = "SELECT f FROM Factura f WHERE f.idTurnos = :idTurnos")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_facturas")
    private Integer idFacturas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Column(name = "iva")
    private Double iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_turnos")
    private int idTurnos;
    @JoinColumn(name = "prefijos_id_prefijos", referencedColumnName = "id_prefijos")
    @ManyToOne(optional = false)
    private Prefijo prefijosIdPrefijos;
    @JoinColumn(name = "id_terceros", referencedColumnName = "id_terceros")
    @ManyToOne(optional = false)
    private Tercero idTerceros;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFacturas")
    private List<DetalleFactura> detalleFacturaList;

    public Factura() {
    }

    public Factura(Integer idFacturas) {
        this.idFacturas = idFacturas;
    }

    public Factura(Integer idFacturas, Date fecha, int idTurnos) {
        this.idFacturas = idFacturas;
        this.fecha = fecha;
        this.idTurnos = idTurnos;
    }

    public Integer getIdFacturas() {
        return idFacturas;
    }

    public void setIdFacturas(Integer idFacturas) {
        this.idFacturas = idFacturas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public int getIdTurnos() {
        return idTurnos;
    }

    public void setIdTurnos(int idTurnos) {
        this.idTurnos = idTurnos;
    }

    public Prefijo getPrefijosIdPrefijos() {
        return prefijosIdPrefijos;
    }

    public void setPrefijosIdPrefijos(Prefijo prefijosIdPrefijos) {
        this.prefijosIdPrefijos = prefijosIdPrefijos;
    }

    public Tercero getIdTerceros() {
        return idTerceros;
    }

    public void setIdTerceros(Tercero idTerceros) {
        this.idTerceros = idTerceros;
    }

    @XmlTransient
    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturas != null ? idFacturas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFacturas == null && other.idFacturas != null) || (this.idFacturas != null && !this.idFacturas.equals(other.idFacturas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.Factura[ idFacturas=" + idFacturas + " ]";
    }
    
}
