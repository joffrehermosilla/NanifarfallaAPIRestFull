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
@Table(name = "cliente_tiene_preferencia")
@EntityListeners(AuditingEntityListener.class)
public class Cliente_tiene_preferencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_preferecia_sku;
	
	@JoinColumn(name = "fkcodigo_producto", referencedColumnName = "codigo_producto")
	@ManyToOne
	@JsonBackReference
	Producto producto;
	
	
	@JoinColumn(name = "fkcodigo_cliente", referencedColumnName = "codigo_cliente")
	@ManyToOne
	@JsonBackReference
	Cliente cliente;
}
