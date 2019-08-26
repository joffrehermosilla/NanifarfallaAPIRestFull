package joffre.NanifarfallaRest.repository;

import org.springframework.stereotype.Repository;

import joffre.NanifarfallaRest.model.entity.Privilege;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {

}
