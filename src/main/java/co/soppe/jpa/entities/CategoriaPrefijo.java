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
@Table(name = "categoria_prefijos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaPrefijo.findAll", query = "SELECT c FROM CategoriaPrefijo c"),
    @NamedQuery(name = "CategoriaPrefijo.findByIdCategoriaPrefijos", query = "SELECT c FROM CategoriaPrefijo c WHERE c.idCategoriaPrefijos = :idCategoriaPrefijos"),
    @NamedQuery(name = "CategoriaPrefijo.findByDescripcion", query = "SELECT c FROM CategoriaPrefijo c WHERE c.descripcion = :descripcion")})
public class CategoriaPrefijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria_prefijos")
    private Integer idCategoriaPrefijos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idCategoriaPrefijos")
    private List<Prefijo> prefijoList;

    public CategoriaPrefijo() {
    }

    public CategoriaPrefijo(Integer idCategoriaPrefijos) {
        this.idCategoriaPrefijos = idCategoriaPrefijos;
    }

    public CategoriaPrefijo(Integer idCategoriaPrefijos, String descripcion) {
        this.idCategoriaPrefijos = idCategoriaPrefijos;
        this.descripcion = descripcion;
    }

    public Integer getIdCategoriaPrefijos() {
        return idCategoriaPrefijos;
    }

    public void setIdCategoriaPrefijos(Integer idCategoriaPrefijos) {
        this.idCategoriaPrefijos = idCategoriaPrefijos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Prefijo> getPrefijoList() {
        return prefijoList;
    }

    public void setPrefijoList(List<Prefijo> prefijoList) {
        this.prefijoList = prefijoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaPrefijos != null ? idCategoriaPrefijos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaPrefijo)) {
            return false;
        }
        CategoriaPrefijo other = (CategoriaPrefijo) object;
        if ((this.idCategoriaPrefijos == null && other.idCategoriaPrefijos != null) || (this.idCategoriaPrefijos != null && !this.idCategoriaPrefijos.equals(other.idCategoriaPrefijos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.CategoriaPrefijo[ idCategoriaPrefijos=" + idCategoriaPrefijos + " ]";
    }
    
}
