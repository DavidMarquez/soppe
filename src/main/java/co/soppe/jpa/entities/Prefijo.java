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
 * @author adsi1
 */
@Entity
@Table(name = "prefijos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prefijo.findAll", query = "SELECT p FROM Prefijo p"),
    @NamedQuery(name = "Prefijo.findByIdPrefijos", query = "SELECT p FROM Prefijo p WHERE p.idPrefijos = :idPrefijos"),
    @NamedQuery(name = "Prefijo.findByPrefijos", query = "SELECT p FROM Prefijo p WHERE p.prefijos = :prefijos")})
public class Prefijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prefijos")
    private Integer idPrefijos;
    @Size(max = 4)
    @Column(name = "prefijos")
    private String prefijos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefijosIdPrefijos")
    private List<Factura> facturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefijosIdPrefijos")
    private List<ResolucionPrefijo> resolucionPrefijoList;
    @JoinColumn(name = "id_categoria_prefijos", referencedColumnName = "id_categoria_prefijos")
    @ManyToOne
    private CategoriaPrefijo idCategoriaPrefijos;

    public Prefijo() {
    }

    public Prefijo(Integer idPrefijos) {
        this.idPrefijos = idPrefijos;
    }

    public Integer getIdPrefijos() {
        return idPrefijos;
    }

    public void setIdPrefijos(Integer idPrefijos) {
        this.idPrefijos = idPrefijos;
    }

    public String getPrefijos() {
        return prefijos;
    }

    public void setPrefijos(String prefijos) {
        this.prefijos = prefijos;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @XmlTransient
    public List<ResolucionPrefijo> getResolucionPrefijoList() {
        return resolucionPrefijoList;
    }

    public void setResolucionPrefijoList(List<ResolucionPrefijo> resolucionPrefijoList) {
        this.resolucionPrefijoList = resolucionPrefijoList;
    }

    public CategoriaPrefijo getIdCategoriaPrefijos() {
        return idCategoriaPrefijos;
    }

    public void setIdCategoriaPrefijos(CategoriaPrefijo idCategoriaPrefijos) {
        this.idCategoriaPrefijos = idCategoriaPrefijos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrefijos != null ? idPrefijos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prefijo)) {
            return false;
        }
        Prefijo other = (Prefijo) object;
        if ((this.idPrefijos == null && other.idPrefijos != null) || (this.idPrefijos != null && !this.idPrefijos.equals(other.idPrefijos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.Prefijo[ idPrefijos=" + idPrefijos + " ]";
    }
    
}
