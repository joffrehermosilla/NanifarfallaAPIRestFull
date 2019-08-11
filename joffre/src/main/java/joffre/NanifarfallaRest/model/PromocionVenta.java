package joffre.NanifarfallaRest.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "promocion_venta")
@EntityListeners(AuditingEntityListener.class)
public class PromocionVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_promocion_venta;
}
