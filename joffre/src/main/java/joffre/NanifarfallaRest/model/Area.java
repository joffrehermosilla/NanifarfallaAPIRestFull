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
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "area")
@EntityListeners(AuditingEntityListener.class)
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_area;
	
	
	@NotBlank
	String nombre_area;

	@NotBlank
	String claveApi;
	
	@OneToMany(mappedBy = "area")
	private Collection<Vendedor> vendedor = new ArrayList<>();
}
