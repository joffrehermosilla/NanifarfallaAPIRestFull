package joffre.NanifarfallaRest.model;

import java.util.ArrayList;
import java.util.Collection;

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

@Table(name = "igv_venta")
@EntityListeners(AuditingEntityListener.class)
public class IgvVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_igv_venta;
	
	@JoinColumn(name = "fkcodigo_tipo_impuesto", referencedColumnName = "codigo_tipo_impuesto")
	@ManyToOne
	@JsonBackReference
	TipoImpuesto tipo_impuesto;
	
	
	@OneToMany(mappedBy = "igv_venta")
	private Collection<Cliente_tiene_pedido> clientetienepedido = new ArrayList<>();
}
