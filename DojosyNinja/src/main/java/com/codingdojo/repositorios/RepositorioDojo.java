package com.codingdojo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.modelos.Dojo;
import com.codingdojo.modelos.Ninja;



@Repository
public interface RepositorioDojo extends CrudRepository<Dojo,Long>{
	List<Dojo> findAll();
	
	@SuppressWarnings("unchecked")
	Dojo save(Dojo nuevoDojo);
	
	List<Dojo> findById(long id);
	
}
