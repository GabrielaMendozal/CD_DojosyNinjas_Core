package com.codingdojo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.modelos.Ninja;

@Repository
public interface RepositorioNinja extends CrudRepository<Ninja,Long> {
	
	List<Ninja> findAll();
	
	@SuppressWarnings("unchecked")
	Ninja save(Ninja nuevoNinja);
	
	@Query( value = "SELECT * " +
		    "FROM ninjas " +
		    "WHERE dojo_id = ?1 ", nativeQuery = true )
	List<Ninja> seleccionarDojoConNinjas(long dojo_id);
}
