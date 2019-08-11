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
@Table(name = "tipo_impuesto")
@EntityListeners(AuditingEntityListener.class)
public class TipoImpuesto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_tipo_impuesto;
	
	@OneToMany(mappedBy = "tipo_impuesto")
	private Collection<IgvVenta> igvventas = new ArrayList<>();
	
}
