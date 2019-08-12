package joffre.NanifarfallaRest.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
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

@Entity
@Table(name = "insumo")
@EntityListeners(AuditingEntityListener.class)
public class Insumo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_insumo;
	
	@JoinColumn(name = "fkcodigo_estadoinsumo", referencedColumnName = "codigo_estadoinsumo")
	@ManyToOne
	@JsonBackReference
	EstadoInsumo estadoinsumo;

	
	@JoinColumn(name = "fkcodigo_tipoinsumo", referencedColumnName = "codigo_tipoinsumo")
	@ManyToOne
	@JsonBackReference
	TipoInsumo tipoinsumo;
	
	
	@JoinColumn(name = "fkcodigo_presentacioninsumo", referencedColumnName = "codigo_presentacioninsumo")
	@ManyToOne
	@JsonBackReference
	PresentacionInsumo presentacioninsumo;
	
	

	@JoinColumn(name = "fkcodigo_loteinsumo", referencedColumnName = "codigo_loteinsumo")
	@ManyToOne
	@JsonBackReference
	LoteInsumo loteinsumo;
	

	@OneToMany(mappedBy = "insumo")
	private Collection<RecetaProductotieneInsumo> recetasproductosinsumos = new ArrayList<>();
	
}
