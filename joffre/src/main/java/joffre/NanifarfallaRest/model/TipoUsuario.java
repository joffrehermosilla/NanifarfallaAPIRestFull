package joffre.NanifarfallaRest.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import joffre.NanifarfallaRest.model.entity.Privilege;

@Entity
@Table(name = "tipousuario")
@EntityListeners(AuditingEntityListener.class)
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_tipousuario;

	@NotBlank
	String nombre_tipousuario;

	@NotBlank
	String claveApi;

	public int getCodigo_tipousuario() {
		return codigo_tipousuario;
	}

	public void setCodigo_tipousuario(int codigo_tipousuario) {
		this.codigo_tipousuario = codigo_tipousuario;
	}

	public String getClaveApi() {
		return claveApi;
	}

	public void setClaveApi(String claveApi) {
		this.claveApi = claveApi;
	}

	@OneToMany(mappedBy = "tipousuario")
	@JsonBackReference
	private Collection<Usuario> usuario = new ArrayList<>();


	@JoinColumn(name = "fkcodigo_privileges", referencedColumnName = "codigo_privileges")
	@JsonBackReference
	@ManyToOne
	Privilege mPrivileges;
	

	@Override
	public String toString() {
		return "TipoUsuario [codigo_tipousuario=" + codigo_tipousuario + ", nombre_tipousuario=" + nombre_tipousuario
				+ ", claveApi=" + claveApi + ", usuario=" + usuario + ", mPrivileges=" + mPrivileges + "]";
	}

	public Privilege getmPrivileges() {
		return mPrivileges;
	}

	public void setmPrivileges(Privilege mPrivileges) {
		this.mPrivileges = mPrivileges;
	}

	@JsonProperty("tipo")
	public String getNombre_tipousuario() {
		return nombre_tipousuario;
	}

	public void setNombre_tipousuario(String nombre_tipousuario) {
		this.nombre_tipousuario = nombre_tipousuario;
	}

	public Collection<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Collection<Usuario> usuario) {
		this.usuario = usuario;
	}
}
