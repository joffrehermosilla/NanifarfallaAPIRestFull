package joffre.NanifarfallaRest.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "lote_insumo")
@EntityListeners(AuditingEntityListener.class)
public class LoteInsumo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_loteinsumo;

}
