package com.codingdojo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.modelos.Ninja;
import com.codingdojo.repositorios.RepositorioNinja;

@Service
public class ServicioNinja {

	private final RepositorioNinja repositorioNinja;

	public ServicioNinja(RepositorioNinja repositorioNinja) {
		this.repositorioNinja = repositorioNinja;
	}
	
	public List<Ninja> selectAllFromNinja(){
		return repositorioNinja.findAll();
	}
	
	public Ninja insertIntoNinjas (Ninja nuevoNinja) {
		return repositorioNinja.save(nuevoNinja);
	}
	
	public List<Ninja> DojoYSusNinjas( long dojo_id) {
		return repositorioNinja.seleccionarDojoConNinjas(  dojo_id);
	}
	
}
