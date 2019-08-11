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
@Table(name = "cliente_tiene_pedido")
@EntityListeners(AuditingEntityListener.class)
public class Cliente_tiene_pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_pedido_web;

	@JoinColumn(name = "fkcodigo_usuario", referencedColumnName = "codigo_usuario")
	@ManyToOne
	@JsonBackReference
	Usuario usuario;

	@JoinColumn(name = "fkcodigo_cliente", referencedColumnName = "codigo_cliente")
	@ManyToOne
	@JsonBackReference
	Cliente cliente;

	@JoinColumn(name = "fkcodigo_vendedor", referencedColumnName = "codigo_vendedor")
	@ManyToOne
	@JsonBackReference
	Vendedor vendedor;

	@JoinColumn(name = "fkcodigo_igv_venta", referencedColumnName = "codigo_igv_venta")
	@ManyToOne
	@JsonBackReference
	IgvVenta igv_venta;

	@JoinColumn(name = "fkcodigo_promocion_venta", referencedColumnName = "codigo_promocion_venta")
	@ManyToOne
	@JsonBackReference
	PromocionVenta promocion_venta;

	@JoinColumn(name = "fkcodigo_estado_cliente_tiene_pedido", referencedColumnName = "codigo_estado_cliente_tiene_pedido")
	@ManyToOne
	@JsonBackReference
	Estado_clientetienepedido estado_cliente_tiene_pedido;

	@JoinColumn(name = "fkcodigo_factura_cliente_tiene_pedido", referencedColumnName = "codigo_factura_cliente_tiene_pedido")
	@ManyToOne
	@JsonBackReference
	Factura_ctienepedido factura_cliente_tiene_pedido;

}
