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
@Table(name = "estado_producto")
@EntityListeners(AuditingEntityListener.class)
public class EstadoProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_estadoproducto;
	
	@OneToMany(mappedBy = "estado_producto")
	private Collection<Producto> productos = new ArrayList<>();
}
