package joffre.NanifarfallaRest.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
@EntityListeners(AuditingEntityListener.class)
public class Usuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_usuario;
	@NotBlank
	String nombre_usuario;
	@NotBlank
	String apellido_usuario;
	@NotBlank
	Date fecha_nacimiento_usuario;
	@NotBlank
	String direccion_usuario;
	@NotBlank
	String nombre_logeo_usuario;
	@NotBlank
	String password_usuario;
	@NotBlank
	String ruta_foto_usuario;

	@JoinColumn(name = "fkcodigo_distrito", referencedColumnName = "codigo_distrito")
	@JsonBackReference
	@ManyToOne
	Distrito distrito;

	@JoinColumn(name = "fkcodigo_tipousuario", referencedColumnName = "codigo_tipousuario")
	@JsonBackReference
	@ManyToOne
	TipoUsuario tipousuario;


	
	
	@JoinColumn(name = "fkcodigo_estadousuario", referencedColumnName = "codigo_estadousuario")
	@JsonBackReference
	@ManyToOne
	EstadoUsuario estadousuario;

	@OneToMany(mappedBy = "mUsuario")
	private Collection<Cliente> cliente = new ArrayList<>();

	@OneToMany(mappedBy = "usuario")
	private Collection<Vendedor> vendedor = new ArrayList<>();

	@OneToMany(mappedBy = "mUsuario")
	private Collection<Cliente_tiene_pedido> cliente_tiene_pedido = new ArrayList<>();

	@NotBlank
	String email;

	@NotBlank
	String telefono;

	@NotBlank
	String celular;

	public Date getFecha_nacimiento_usuario() {
		return fecha_nacimiento_usuario;
	}

	public void setFecha_nacimiento_usuario(Date fecha_nacimiento_usuario) {
		this.fecha_nacimiento_usuario = fecha_nacimiento_usuario;
	}

	public Collection<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(Collection<Cliente> cliente) {
		this.cliente = cliente;
	}

	public Collection<Vendedor> getVendedor() {
		return vendedor;
	}

	public void setVendedor(Collection<Vendedor> vendedor) {
		this.vendedor = vendedor;
	}

	public Collection<Cliente_tiene_pedido> getCliente_tiene_pedido() {
		return cliente_tiene_pedido;
	}

	public void setCliente_tiene_pedido(Collection<Cliente_tiene_pedido> cliente_tiene_pedido) {
		this.cliente_tiene_pedido = cliente_tiene_pedido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@NotBlank
	String claveApi;

	public int getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getApellido_usuario() {
		return apellido_usuario;
	}

	public void setApellido_usuario(String apellido_usuario) {
		this.apellido_usuario = apellido_usuario;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento_usuario;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento_usuario = fecha_nacimiento;
	}

	public String getDireccion_usuario() {
		return direccion_usuario;
	}

	public void setDireccion_usuario(String direccion_usuario) {
		this.direccion_usuario = direccion_usuario;
	}

	public String getNombre_logeo_usuario() {
		return nombre_logeo_usuario;
	}

	public void setNombre_logeo_usuario(String nombre_logeo_usuario) {
		this.nombre_logeo_usuario = nombre_logeo_usuario;
	}

	public String getPassword_usuario() {
		return password_usuario;
	}

	public void setPassword_usuario(String password_usuario) {
		this.password_usuario = password_usuario;
	}

	public String getRuta_foto_usuario() {
		return ruta_foto_usuario;
	}

	public void setRuta_foto_usuario(String ruta_foto_usuario) {
		this.ruta_foto_usuario = ruta_foto_usuario;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	


	public Usuario(int codigo_usuario, @NotBlank String nombre_usuario, @NotBlank String apellido_usuario,
			@NotBlank Date fecha_nacimiento_usuario, @NotBlank String direccion_usuario,
			@NotBlank String nombre_logeo_usuario, @NotBlank String password_usuario,
			@NotBlank String ruta_foto_usuario, Distrito distrito, TipoUsuario tipousuario, EstadoUsuario estadousuario,
			Collection<Cliente> cliente, Collection<Vendedor> vendedor,
			Collection<Cliente_tiene_pedido> cliente_tiene_pedido, @NotBlank String email, @NotBlank String telefono,
			@NotBlank String celular, @NotBlank String claveApi) {
		super();
		this.codigo_usuario = codigo_usuario;
		this.nombre_usuario = nombre_usuario;
		this.apellido_usuario = apellido_usuario;
		this.fecha_nacimiento_usuario = fecha_nacimiento_usuario;
		this.direccion_usuario = direccion_usuario;
		this.nombre_logeo_usuario = nombre_logeo_usuario;
		this.password_usuario = password_usuario;
		this.ruta_foto_usuario = ruta_foto_usuario;
		this.distrito = distrito;
		this.tipousuario = tipousuario;
		this.estadousuario = estadousuario;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.cliente_tiene_pedido = cliente_tiene_pedido;
		this.email = email;
		this.telefono = telefono;
		this.celular = celular;
		this.claveApi = claveApi;
	}

	@Override
	public String toString() {
		return "Usuario [codigo_usuario=" + codigo_usuario + ", nombre_usuario=" + nombre_usuario
				+ ", apellido_usuario=" + apellido_usuario + ", fecha_nacimiento_usuario=" + fecha_nacimiento_usuario
				+ ", direccion_usuario=" + direccion_usuario + ", nombre_logeo_usuario=" + nombre_logeo_usuario
				+ ", password_usuario=" + password_usuario + ", ruta_foto_usuario=" + ruta_foto_usuario + ", distrito="
				+ distrito + ", tipousuario=" + tipousuario + ", estadousuario=" + estadousuario + ", cliente="
				+ cliente + ", vendedor=" + vendedor + ", cliente_tiene_pedido=" + cliente_tiene_pedido + ", email="
				+ email + ", telefono=" + telefono + ", celular=" + celular + ", claveApi=" + claveApi + "]";
	}

	public TipoUsuario getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(TipoUsuario tipousuario) {
		this.tipousuario = tipousuario;
	}

	public EstadoUsuario getEstadousuario() {
		return estadousuario;
	}

	public void setEstadousuario(EstadoUsuario estadousuario) {
		this.estadousuario = estadousuario;
	}

	@JsonIgnore
	public String getClaveApi() {
		return claveApi;
	}

	public void setClaveApi(String claveApi) {
		this.claveApi = claveApi;
	}

	public Usuario(@NotBlank String nombre_logeo_usuario, @NotBlank String password_usuario) {
		super();
		this.nombre_logeo_usuario = nombre_logeo_usuario;
		this.password_usuario = password_usuario;
	}

	public Usuario() {

	}

	public Usuario(int id) {
		this.codigo_usuario = id;
	}

	



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
