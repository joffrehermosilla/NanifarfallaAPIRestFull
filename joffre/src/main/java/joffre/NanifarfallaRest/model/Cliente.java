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
@Table(name = "cliente")
@EntityListeners(AuditingEntityListener.class)
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_cliente;
	
	@JoinColumn(name = "fkcodigo_usuario", referencedColumnName = "codigo_usuario")
	@ManyToOne
	@JsonBackReference
	Usuario usuario;
	
	@JoinColumn(name = "fkcodigo_regimencliente", referencedColumnName = "codigo_regimencliente")
	@ManyToOne
	@JsonBackReference
	RegimenCliente regimen_cliente;
	
	@JoinColumn(name = "fkcodigo_estadocliente", referencedColumnName = "codigo_estadocliente")
	@ManyToOne
	@JsonBackReference
	EstadoCliente estado_cliente;
	
	@OneToMany(mappedBy = "cliente")
	private Collection<Estado_clientetienepedido> cliente_tiene_pedido = new ArrayList<>();
	
}
