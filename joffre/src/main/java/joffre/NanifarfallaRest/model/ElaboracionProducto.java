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
@Table(name = "elaboracion_producto")
@EntityListeners(AuditingEntityListener.class)
public class ElaboracionProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_elaboracionproducto;
	
	@OneToMany(mappedBy = "elaboracion_producto")
	private Collection<RecetaProductotieneInsumo> recetasproductosinsumos = new ArrayList<>();
	
}
