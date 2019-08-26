package joffre.NanifarfallaRest.model.entity;

import joffre.NanifarfallaRest.model.TipoUsuario;



import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import javax.persistence.OneToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Privilege {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo_privileges;

	public int getCodigo_privileges() {
		return codigo_privileges;
	}

	public void setCodigo_privileges(int codigo_privileges) {
		this.codigo_privileges = codigo_privileges;
	}

	public String getNamePrivilege() {
		return namePrivilege;
	}

	public void setNamePrivilege(String namePrivilege) {
		this.namePrivilege = namePrivilege;
	}

	public Collection<TipoUsuario> getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(Collection<TipoUsuario> tipousuario) {
		this.tipousuario = tipousuario;
	}

	@Override
	public String toString() {
		return "Privilege [codigo_privileges=" + codigo_privileges + ", namePrivilege=" + namePrivilege
				+ ", tipousuario=" + tipousuario + "]";
	}

	private String namePrivilege;

	@OneToMany(mappedBy = "mPrivileges")
	@JsonBackReference
	private Collection<TipoUsuario> tipousuario;
	
	
}
