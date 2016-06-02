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
@Table(name = "usuarios_aduaneros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioAduanero.findAll", query = "SELECT u FROM UsuarioAduanero u"),
    @NamedQuery(name = "UsuarioAduanero.findByIdUsuariosAduaneros", query = "SELECT u FROM UsuarioAduanero u WHERE u.idUsuariosAduaneros = :idUsuariosAduaneros"),
    @NamedQuery(name = "UsuarioAduanero.findByResolucion", query = "SELECT u FROM UsuarioAduanero u WHERE u.resolucion = :resolucion")})
public class UsuarioAduanero implements Serializable {

    @Column(name = "resolucion")
    private Integer resolucion;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuarios_aduaneros")
    private Integer idUsuariosAduaneros;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioAduanero")
    private List<TerceroHasUsuarioAduanero> terceroHasUsuarioAduaneroList;

    public UsuarioAduanero() {
    }

    public UsuarioAduanero(Integer idUsuariosAduaneros) {
        this.idUsuariosAduaneros = idUsuariosAduaneros;
    }

    public Integer getIdUsuariosAduaneros() {
        return idUsuariosAduaneros;
    }

    public void setIdUsuariosAduaneros(Integer idUsuariosAduaneros) {
        this.idUsuariosAduaneros = idUsuariosAduaneros;
    }


    @XmlTransient
    public List<TerceroHasUsuarioAduanero> getTerceroHasUsuarioAduaneroList() {
        return terceroHasUsuarioAduaneroList;
    }

    public void setTerceroHasUsuarioAduaneroList(List<TerceroHasUsuarioAduanero> terceroHasUsuarioAduaneroList) {
        this.terceroHasUsuarioAduaneroList = terceroHasUsuarioAduaneroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuariosAduaneros != null ? idUsuariosAduaneros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioAduanero)) {
            return false;
        }
        UsuarioAduanero other = (UsuarioAduanero) object;
        if ((this.idUsuariosAduaneros == null && other.idUsuariosAduaneros != null) || (this.idUsuariosAduaneros != null && !this.idUsuariosAduaneros.equals(other.idUsuariosAduaneros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.UsuarioAduanero[ idUsuariosAduaneros=" + idUsuariosAduaneros + " ]";
    }

    public Integer getResolucion() {
        return resolucion;
    }

    public void setResolucion(Integer resolucion) {
        this.resolucion = resolucion;
    }
    
}
