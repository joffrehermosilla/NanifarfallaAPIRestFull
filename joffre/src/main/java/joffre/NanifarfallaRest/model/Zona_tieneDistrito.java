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
@Table(name = "zona_tiene_distrito")
@EntityListeners(AuditingEntityListener.class)
public class Zona_tieneDistrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_zona_tiene_distrito;
	
	
	@JoinColumn(name = "fkcodigo_distrito", referencedColumnName = "codigo_distrito")
	@ManyToOne
	@JsonBackReference
	Distrito distrito;
	
	
	
	
}
