package joffre.NanifarfallaRest.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "estado_cliente_tiene_pedido")
@EntityListeners(AuditingEntityListener.class)
public class Estado_clientetienepedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_estado_cliente_tiene_pedido;
}
