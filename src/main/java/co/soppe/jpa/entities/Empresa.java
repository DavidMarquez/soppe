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
 * @author adsi1
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Empresa.findByIdTercero", query = "SELECT e FROM Empresa e WHERE e.idTerceros.idTerceros = :idTercero"),
    @NamedQuery(name = "Empresa.findByNombre", query = "SELECT e FROM Empresa e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empresa.findByDireccion", query = "SELECT e FROM Empresa e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empresa.findByTelefono", query = "SELECT e FROM Empresa e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Empresa.findByEmail", query = "SELECT e FROM Empresa e WHERE e.email = :email"),
    @NamedQuery(name = "Empresa.findByNit", query = "SELECT e FROM Empresa e WHERE e.nit = :nit"),
    @NamedQuery(name = "Empresa.findByRazonComercial", query = "SELECT e FROM Empresa e WHERE e.razonComercial = :razonComercial"),
    @NamedQuery(name = "Empresa.findByNumDiv", query = "SELECT e FROM Empresa e WHERE e.numDiv = :numDiv"),
    @NamedQuery(name = "Empresa.findByEstado", query = "SELECT e FROM Empresa e WHERE e.estado = :estado")})
public class Empresa implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<EmpresaHasActividadEconomica> empresaHasActividadEconomicaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Size(max = 100)
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
    @Column(name = "nit")
    private Integer nit;
    @Size(max = 15)
    @Column(name = "razon_comercial")
    private String razonComercial;
    @Size(max = 1)
    @Column(name = "num_div")
    private String numDiv;
    @Column(name = "estado")
    private Boolean estado;
    @JoinTable(name = "empresa_has_terceros", joinColumns = {
        @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")}, inverseJoinColumns = {
        @JoinColumn(name = "id_terceros", referencedColumnName = "id_terceros")})
    @ManyToMany
    private List<Tercero> terceroList;
    @ManyToMany(mappedBy = "empresaList")
    private List<ActividadEconomica> actividadEconomicaList;
    @OneToMany(mappedBy = "idEmpresa")
    private List<Sede> sedeList;
    @JoinColumn(name = "id_terceros", referencedColumnName = "id_terceros")
    @ManyToOne
    private Tercero idTerceros;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
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

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getRazonComercial() {
        return razonComercial;
    }

    public void setRazonComercial(String razonComercial) {
        this.razonComercial = razonComercial;
    }

    public String getNumDiv() {
        return numDiv;
    }

    public void setNumDiv(String numDiv) {
        this.numDiv = numDiv;
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
    public List<ActividadEconomica> getActividadEconomicaList() {
        return actividadEconomicaList;
    }

    public void setActividadEconomicaList(List<ActividadEconomica> actividadEconomicaList) {
        this.actividadEconomicaList = actividadEconomicaList;
    }

    @XmlTransient
    public List<Sede> getSedeList() {
        return sedeList;
    }

    public void setSedeList(List<Sede> sedeList) {
        this.sedeList = sedeList;
    }

    public Tercero getIdTerceros() {
        return idTerceros;
    }

    public void setIdTerceros(Tercero idTerceros) {
        this.idTerceros = idTerceros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }

    @XmlTransient
    public List<EmpresaHasActividadEconomica> getEmpresaHasActividadEconomicaList() {
        return empresaHasActividadEconomicaList;
    }

    public void setEmpresaHasActividadEconomicaList(List<EmpresaHasActividadEconomica> empresaHasActividadEconomicaList) {
        this.empresaHasActividadEconomicaList = empresaHasActividadEconomicaList;
    }
    
}
