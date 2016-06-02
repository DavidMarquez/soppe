/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.entities;

import co.soppe.rest.auth.DigestUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1
 */
@Entity
@Table(name = "terceros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tercero.findAll", query = "SELECT t FROM Tercero t"),
    @NamedQuery(name = "Tercero.findByIdTerceros", query = "SELECT t FROM Tercero t WHERE t.idTerceros = :idTerceros"),
    @NamedQuery(name = "Tercero.findByPrimerApellido", query = "SELECT t FROM Tercero t WHERE t.primerApellido = :primerApellido"),
    @NamedQuery(name = "Tercero.findBySegundoApellido", query = "SELECT t FROM Tercero t WHERE t.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Tercero.findByPrimerNombre", query = "SELECT t FROM Tercero t WHERE t.primerNombre = :primerNombre"),
    @NamedQuery(name = "Tercero.findByOtrosNombres", query = "SELECT t FROM Tercero t WHERE t.otrosNombres = :otrosNombres"),
    @NamedQuery(name = "Tercero.findByFechaNac", query = "SELECT t FROM Tercero t WHERE t.fechaNac = :fechaNac"),
    @NamedQuery(name = "Tercero.findByDocumento", query = "SELECT t FROM Tercero t WHERE t.documento = :documento"),
    @NamedQuery(name = "Tercero.findByFechaExpedicion", query = "SELECT t FROM Tercero t WHERE t.fechaExpedicion = :fechaExpedicion"),
    @NamedQuery(name = "Tercero.findByPassword", query = "SELECT t FROM Tercero t WHERE t.password = :password"),
    @NamedQuery(name = "Tercero.findByLugarExpedicion", query = "SELECT t FROM Tercero t WHERE t.lugarExpedicion = :lugarExpedicion"),
    @NamedQuery(name = "Tercero.findByTelefono", query = "SELECT t FROM Tercero t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "Tercero.findByDireccion", query = "SELECT t FROM Tercero t WHERE t.direccion = :direccion"),
    @NamedQuery(name = "Tercero.findBySexo", query = "SELECT t FROM Tercero t WHERE t.sexo = :sexo"),
    @NamedQuery(name = "Tercero.findByIdTurnos", query = "SELECT t FROM Tercero t WHERE t.idTurnos = :idTurnos"),
    @NamedQuery(name = "Tercero.findByEmail", query = "SELECT t FROM Tercero t WHERE t.email = :email"),
    @NamedQuery(name = "Tercero.findByEstado", query = "SELECT t FROM Tercero t WHERE t.estado = :estado")})
public class Tercero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_terceros")
    private Integer idTerceros;
    @Size(max = 15)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 15)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Size(max = 15)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 15)
    @Column(name = "otros_nombres")
    private String otrosNombres;
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Column(name = "documento")
    private Integer documento;
    @Column(name = "fecha_expedicion")
    @Temporal(TemporalType.DATE)
    private Date fechaExpedicion;
    @Size(max = 64)
    @Column(name = "password")
    private String password;
    @Size(max = 15)
    @Column(name = "lugar_expedicion")
    private String lugarExpedicion;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 40)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "id_turnos")
    private Integer idTurnos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "email")
    private String email;
    @Column(name = "estado")
    private Boolean estado;
    @ManyToMany(mappedBy = "terceroList")
    private List<Rol> rolList;
    @ManyToMany(mappedBy = "terceroList")
    private List<Empresa> empresaList;
    @ManyToMany(mappedBy = "terceroList")
    private List<Sede> sedeList;
    @ManyToMany(mappedBy = "terceroList")
    private List<ActividadEconomica> actividadEconomicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTerceros")
    private List<Factura> facturaList;
    @OneToMany(mappedBy = "idTerceros")
    private List<Responsabilidad> responsabilidadList;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_departamentos", referencedColumnName = "id_departamentos")})
    @ManyToOne
    private Ciudad ciudad;
    @JoinColumn(name = "id_ocupacion", referencedColumnName = "id_ocupacion")
    @ManyToOne
    private Ocupacion idOcupacion;
    @JoinColumn(name = "id_sedes", referencedColumnName = "id_sedes")
    @ManyToOne
    private Sede idSedes;
    @JoinColumn(name = "id_tipo_contribuyente", referencedColumnName = "id_tipo_contribuyente")
    @ManyToOne
    private TipoContribuyente idTipoContribuyente;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne
    private TipoDocumento idTipoDocumento;
    @OneToMany(mappedBy = "idTerceros")
    private List<Empresa> empresaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tercero")
    private List<TerceroHasUsuarioAduanero> terceroHasUsuarioAduaneroList;
    
    @Column(name="codigo_recuperacion")
    private String codigoRecuperacion;

    public Tercero() {
    }

    public Tercero(Integer idTerceros) {
        this.idTerceros = idTerceros;
    }

    public Integer getIdTerceros() {
        return idTerceros;
    }

    public void setIdTerceros(Integer idTerceros) {
        this.idTerceros = idTerceros;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getOtrosNombres() {
        return otrosNombres;
    }

    public void setOtrosNombres(String otrosNombres) {
        this.otrosNombres = otrosNombres;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
                try {
            this.password = DigestUtil.generateDigest(password);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Tercero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Integer getIdTurnos() {
        return idTurnos;
    }

    public void setIdTurnos(Integer idTurnos) {
        this.idTurnos = idTurnos;
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
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public String getCodigoRecuperacion() {
        return codigoRecuperacion;
    }

    public void setCodigoRecuperacion(String codigoRecuperacion) {
        this.codigoRecuperacion = codigoRecuperacion;
    }

    
    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @XmlTransient
    public List<Sede> getSedeList() {
        return sedeList;
    }

    public void setSedeList(List<Sede> sedeList) {
        this.sedeList = sedeList;
    }

    @XmlTransient
    public List<ActividadEconomica> getActividadEconomicaList() {
        return actividadEconomicaList;
    }

    public void setActividadEconomicaList(List<ActividadEconomica> actividadEconomicaList) {
        this.actividadEconomicaList = actividadEconomicaList;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @XmlTransient
    public List<Responsabilidad> getResponsabilidadList() {
        return responsabilidadList;
    }

    public void setResponsabilidadList(List<Responsabilidad> responsabilidadList) {
        this.responsabilidadList = responsabilidadList;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ocupacion getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(Ocupacion idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    public Sede getIdSedes() {
        return idSedes;
    }

    public void setIdSedes(Sede idSedes) {
        this.idSedes = idSedes;
    }

    public TipoContribuyente getIdTipoContribuyente() {
        return idTipoContribuyente;
    }

    public void setIdTipoContribuyente(TipoContribuyente idTipoContribuyente) {
        this.idTipoContribuyente = idTipoContribuyente;
    }

    public TipoDocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList1() {
        return empresaList1;
    }

    public void setEmpresaList1(List<Empresa> empresaList1) {
        this.empresaList1 = empresaList1;
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
        hash += (idTerceros != null ? idTerceros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tercero)) {
            return false;
        }
        Tercero other = (Tercero) object;
        if ((this.idTerceros == null && other.idTerceros != null) || (this.idTerceros != null && !this.idTerceros.equals(other.idTerceros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.soppe.jpa.entities.Tercero[ idTerceros=" + idTerceros + " ]";
    }
    
}
