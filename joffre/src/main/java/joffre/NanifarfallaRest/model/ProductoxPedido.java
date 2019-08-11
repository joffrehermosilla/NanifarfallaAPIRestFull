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
@Table(name = "producto_por_pedido")
@EntityListeners(AuditingEntityListener.class)
public class ProductoxPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_producto_por_pedido;
	
	@JoinColumn(name = "fkcodigo_producto", referencedColumnName = "codigo_producto")
	@ManyToOne
	@JsonBackReference
	Producto producto;
	
	
	@JoinColumn(name = "fkcodigo_pedido_web", referencedColumnName = "codigo_pedido_web")
	@ManyToOne
	@JsonBackReference
	Cliente_tiene_pedido clientetienepedido;
}
