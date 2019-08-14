package joffre.NanifarfallaRest.repository;

import org.springframework.stereotype.Repository;

import joffre.NanifarfallaRest.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {

}
