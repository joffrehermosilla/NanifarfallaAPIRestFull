package joffre.NanifarfallaRest.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "rece_produ_ti_insumo")
@EntityListeners(AuditingEntityListener.class)
public class RecetaProductotieneInsumo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_rece_produ_ti_insumo;
	
	
	
	@JoinColumn(name = "fkcodigo_producto", referencedColumnName = "codigo_producto")
	@ManyToOne
	@JsonBackReference
	Producto producto;

	
	@JoinColumn(name = "fkcodigo_insumo", referencedColumnName = "codigo_insumo")
	@ManyToOne
	@JsonBackReference
	Insumo insumo;
	
	
	@JoinColumn(name = "fkcodigo_elaboracionproducto", referencedColumnName = "codigo_elaboracionproducto")
	@ManyToOne
	@JsonBackReference
	ElaboracionProducto elaboracionproducto;
	
	
	
}
