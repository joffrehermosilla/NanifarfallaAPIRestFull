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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "vendedor")
@EntityListeners(AuditingEntityListener.class)
public class Vendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_vendedor;
	
	
	@JoinColumn(name = "fkcodigo_usuario", referencedColumnName = "codigo_usuario")
	@ManyToOne
	@JsonBackReference
	Usuario usuario;
	
	@JoinColumn(name = "fkcodigo_area", referencedColumnName = "codigo_area")
	@ManyToOne
	@JsonBackReference
	Area area;
	
	@OneToMany(mappedBy = "vendedor")
	private Collection<Cliente_tiene_pedido> cliente_tiene_pedido = new ArrayList<>();
	
	
	
	
	
	
	
	
	
	
	
	
	
}
