package joffre.NanifarfallaRest.repository;

import org.springframework.stereotype.Repository;

import joffre.NanifarfallaRest.model.Estado_clientetienepedido;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface EstadoClienteRepository extends JpaRepository <Estado_clientetienepedido, Integer> {

}
