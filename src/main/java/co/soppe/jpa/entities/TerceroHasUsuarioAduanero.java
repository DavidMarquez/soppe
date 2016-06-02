/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "terceros_has_usuarios_aduaneros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TerceroHasUsuarioAduanero.findAll", query = "SELECT t FROM TerceroHasUsuarioAduanero t"),
    @NamedQuery(name = "TerceroHasUsuarioAduanero.findByIdUsuariosAduaneros", query = "SELECT t FROM TerceroHasUsuarioAduanero t WHERE t.terceroHasUsuarioAduaneroPK.idUsuariosAduaneros = :idUsuariosAduaneros"),
    @NamedQuery(name = "TerceroHasUsuarioAduanero.findByNombreCalidad", query = "SELECT t FROM TerceroHasUsuarioAduanero t WHERE t.nombreCalidad = :nombreCalidad"),
    @NamedQuery(name = "TerceroHasUsuarioAduanero.findByIdTerceros", query = "SELECT t FROM TerceroHasUsuarioAduanero t WHERE t.terceroHasUsuarioAduaneroPK.idTerceros = :idTerceros")})
public class TerceroHasUsuarioAduanero implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TerceroHasUsuarioAduaneroPK terceroHasUsuarioAduaneroPK;
    @Size(max = 45)
    @Column(name = "nombre_calidad")
    private String nombreCalidad;
    @JoinColumn(name = "id_terceros", referencedColumnName = "id_terceros", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tercero tercero;
    @JoinColumn(name = "id_usuarios_aduaneros", referencedColumnName = "id_usuarios_aduaneros", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UsuarioAduanero usuarioAduanero;

    public TerceroHasUsuarioAduanero() {
    }

    public TerceroHasUsuarioAduanero(TerceroHasUsuarioAduaneroPK terceroHasUsuarioAduaneroPK) {
        this.terceroHasUsuarioAduaneroPK = terceroHasUsuarioAduaneroPK;
    }

    public TerceroHasUsuarioAduanero(int idUsuariosAduaneros, int idTerceros) {
        this.terceroHasUsuarioAduaneroPK = new TerceroHasUsuarioAduaneroPK(idUsuariosAduaneros, idTerceros);
    }

    public TerceroHasUsuarioAduaneroPK getTerceroHasUsuarioAduaneroPK() {
        return terceroHasUsuarioAduaneroPK;
    }

    public void setTerceroHasUsuarioAduaneroPK(TerceroHasUsuarioAduaneroPK terceroHasUsuarioAduaneroPK) {
        this.terceroHasUsuarioAduaneroPK = terceroHasUsuarioAduaneroPK;
    }

    public String getNombreCalidad() {
        return nombreCalidad;
    }

    public void setNombreCalidad(String nombreCalidad) {
        this.nombreCalidad = nombreCalidad;
    }

    public Tercero getTercero() {
        return tercero;
    }

    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }

    public UsuarioAduanero getUsuarioAduanero() {
        return usuarioAduanero;
    }

    public void setUsuarioAduanero(UsuarioAduanero usuarioAduanero) {
        this.usuarioAduanero = usuarioAduanero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (terceroHasUsuarioAduaneroPK != null ? terceroHasUsuarioAduaneroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TerceroHasUsuarioAduanero)) {
            return false;
        }
        TerceroHasUsuarioAduanero other = (TerceroHasUsuarioAduanero) object;
        if ((this.terceroHasUsuarioAduaneroPK == null && other.terceroHasUsuarioAduaneroPK != null) || (this.terceroHasUsuarioAduaneroPK != null && !this.terceroHasUsuarioAduaneroPK.equals(other.terceroHasUsuarioAduaneroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.TerceroHasUsuarioAduanero[ terceroHasUsuarioAduaneroPK=" + terceroHasUsuarioAduaneroPK + " ]";
    }
    
}
