package joffre.NanifarfallaRest.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "factura_c_tiene_pedido")
@EntityListeners(AuditingEntityListener.class)
public class Factura_ctienepedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_factura_cliente_tiene_pedido;
}
