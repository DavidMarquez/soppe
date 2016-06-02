/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1
 */
@Entity
@Table(name = "tipo_contribuyente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContribuyente.findAll", query = "SELECT t FROM TipoContribuyente t"),
    @NamedQuery(name = "TipoContribuyente.findByIdTipoContribuyente", query = "SELECT t FROM TipoContribuyente t WHERE t.idTipoContribuyente = :idTipoContribuyente"),
    @NamedQuery(name = "TipoContribuyente.findByDescripcion", query = "SELECT t FROM TipoContribuyente t WHERE t.descripcion = :descripcion")})
public class TipoContribuyente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_contribuyente")
    private Integer idTipoContribuyente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idTipoContribuyente")
    private List<Tercero> terceroList;

    public TipoContribuyente() {
    }

    public TipoContribuyente(Integer idTipoContribuyente) {
        this.idTipoContribuyente = idTipoContribuyente;
    }

    public TipoContribuyente(Integer idTipoContribuyente, String descripcion) {
        this.idTipoContribuyente = idTipoContribuyente;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoContribuyente() {
        return idTipoContribuyente;
    }

    public void setIdTipoContribuyente(Integer idTipoContribuyente) {
        this.idTipoContribuyente = idTipoContribuyente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Tercero> getTerceroList() {
        return terceroList;
    }

    public void setTerceroList(List<Tercero> terceroList) {
        this.terceroList = terceroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoContribuyente != null ? idTipoContribuyente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoContribuyente)) {
            return false;
        }
        TipoContribuyente other = (TipoContribuyente) object;
        if ((this.idTipoContribuyente == null && other.idTipoContribuyente != null) || (this.idTipoContribuyente != null && !this.idTipoContribuyente.equals(other.idTipoContribuyente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.TipoContribuyente[ idTipoContribuyente=" + idTipoContribuyente + " ]";
    }
    
}
