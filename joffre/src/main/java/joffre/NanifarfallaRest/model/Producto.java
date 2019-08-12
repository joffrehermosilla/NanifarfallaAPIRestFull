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
@Table(name = "producto")
@EntityListeners(AuditingEntityListener.class)
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_producto;
	
	@JoinColumn(name = "fkcodigo_linea", referencedColumnName = "codigo_linea")
	@ManyToOne
	@JsonBackReference
	Linea linea;

	@JoinColumn(name = "fkcodigo_tipoproducto", referencedColumnName = "codigo_tipoproducto")
	@ManyToOne
	@JsonBackReference
	TipoProducto tipoproducto;

	@JoinColumn(name = "fkcodigo_estadoproducto", referencedColumnName = "codigo_estadoproducto")
	@ManyToOne
	@JsonBackReference
	EstadoProducto estadoproducto;
	
	@OneToMany(mappedBy = "producto")
	private Collection<ProductoxPedido> productoxpedido = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "producto")
	private Collection<RecetaProductotieneInsumo> recetasproductosinsumos = new ArrayList<>();
}
