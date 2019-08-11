package joffre.NanifarfallaRest.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "estado_cliente")
@EntityListeners(AuditingEntityListener.class)
public class EstadoCliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_estadocliente;
	
	@OneToMany(mappedBy = "regimen_cliente")
	private Collection<Usuario> usuario = new ArrayList<>();
	
}
