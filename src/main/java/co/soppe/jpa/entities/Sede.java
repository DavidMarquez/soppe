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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author Luis
 */
@Entity
@Table(name = "sedes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sede.findAll", query = "SELECT s FROM Sede s"),
    @NamedQuery(name = "Sede.findByIdSedes", query = "SELECT s FROM Sede s WHERE s.idSedes = :idSedes"),
    @NamedQuery(name = "Sede.findByNombre", query = "SELECT s FROM Sede s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Sede.findByIdEmpresa", query = "SELECT s FROM Sede s WHERE s.idEmpresa.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Sede.findByDireccion", query = "SELECT s FROM Sede s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Sede.findByTelefono", query = "SELECT s FROM Sede s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Sede.findByEmail", query = "SELECT s FROM Sede s WHERE s.email = :email"),
    @NamedQuery(name = "Sede.findByEstado", query = "SELECT s FROM Sede s WHERE s.estado = :estado")})
public class Sede implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sedes")
    private Integer idSedes;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 40)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 10)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "email")
    private String email;
    @Column(name = "estado")
    private Boolean estado;
    @JoinTable(name = "sedes_has_terceros", joinColumns = {
        @JoinColumn(name = "id_sedes", referencedColumnName = "id_sedes")}, inverseJoinColumns = {
        @JoinColumn(name = "id_terceros", referencedColumnName = "id_terceros")})
    @ManyToMany
    private List<Tercero> terceroList;
    @ManyToMany(mappedBy = "sedeList")
    private List<ResolucionPrefijo> resolucionPrefijoList;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne
    private Empresa idEmpresa;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_departamentos", referencedColumnName = "id_departamentos")})
    @ManyToOne
    private Ciudad ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSedes")
    private List<Bodega> bodegaList;
    @OneToMany(mappedBy = "idSedes")
    private List<Tercero> terceroList1;

    public Sede() {
    }

    public Sede(Integer idSedes) {
        this.idSedes = idSedes;
    }

    public Integer getIdSedes() {
        return idSedes;
    }

    public void setIdSedes(Integer idSedes) {
        this.idSedes = idSedes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Tercero> getTerceroList() {
        return terceroList;
    }

    public void setTerceroList(List<Tercero> terceroList) {
        this.terceroList = terceroList;
    }

    @XmlTransient
    public List<ResolucionPrefijo> getResolucionPrefijoList() {
        return resolucionPrefijoList;
    }

    public void setResolucionPrefijoList(List<ResolucionPrefijo> resolucionPrefijoList) {
        this.resolucionPrefijoList = resolucionPrefijoList;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public List<Bodega> getBodegaList() {
        return bodegaList;
    }

    public void setBodegaList(List<Bodega> bodegaList) {
        this.bodegaList = bodegaList;
    }

    @XmlTransient
    public List<Tercero> getTerceroList1() {
        return terceroList1;
    }

    public void setTerceroList1(List<Tercero> terceroList1) {
        this.terceroList1 = terceroList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSedes != null ? idSedes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.idSedes == null && other.idSedes != null) || (this.idSedes != null && !this.idSedes.equals(other.idSedes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.Sede[ idSedes=" + idSedes + " ]";
    }
    
}
