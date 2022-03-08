package com.codingdojo.servicios;

import java.util.List;


import org.springframework.stereotype.Service;

import com.codingdojo.modelos.Dojo;
import com.codingdojo.modelos.Ninja;

import com.codingdojo.repositorios.RepositorioDojo;




@Service
public class ServicioDojo {
	
private final  RepositorioDojo repositorioDojo;  //le he quitado fina;
	
	public ServicioDojo( RepositorioDojo repositorio) { //este es un constructor
		this.repositorioDojo = repositorio;
	}
	
	public List<Dojo> selectAllFromDojo(){
		return repositorioDojo.findAll();  // viene del repositorio
	}
	
	public Dojo insertIntoDojos( Dojo nuevoDojo) {
		return repositorioDojo.save(nuevoDojo);
	}
	
	

	/*
	public Dojo findDojo(Long id) {
	     Optional<Dojo> optionalDojo = repositorioDojo.findById(id);
	     if(optionalDojo.isPresent()) {
	         return optionalDojo.get();
	     }
	     else {
	         return null;
	     }
	 }*/
	/*public List<Object[]> selectFromDojoNinjas(){
		return repositorioDojo.seleccionarDojoConNinjas();
	}*/
}
