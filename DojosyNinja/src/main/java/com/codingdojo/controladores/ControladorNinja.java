package com.codingdojo.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.modelos.Dojo;
import com.codingdojo.modelos.Ninja;
import com.codingdojo.servicios.ServicioDojo;
import com.codingdojo.servicios.ServicioNinja;

@Controller

public class ControladorNinja {
	private final ServicioNinja servicioNinja;

	private final ServicioDojo servicioDojo;
		
	public ControladorNinja(ServicioNinja servicioNinja, ServicioDojo servicioDojo) {
		this.servicioNinja = servicioNinja;
		this.servicioDojo = servicioDojo;
	}

	@RequestMapping( value="/ninja/registrado", method = RequestMethod.POST)
	public String registrarNinja(@Valid @ModelAttribute("ninja") Ninja nuevoNinja, BindingResult result) {
		if(result.hasErrors()) {
			//List<Dojo> listaDojos = servicioDojo.selectAllFromDojo();
			//model.addAttribute("listaDojos", listaDojos);
			System.out.println("SOY ERROR");
			return "registroNinja.jsp";
		}
		else {
			servicioNinja.insertIntoNinjas(nuevoNinja);
			System.out.println("ESTOY BIEN"+ nuevoNinja.getDojo().getId());
			//String id = String.valueOf(nuevoNinja.getDojo().getId());
			//System.out.println("id dojo"+ id);
			return "redirect:/dojos/"+nuevoNinja.getDojo().getId();
	    }
	}
	
	@RequestMapping(value ="/dojos/{id}", method = RequestMethod.GET)
	public String despliegaDojoNinjas(@PathVariable("id") long id, Model model) {
		List<Ninja> dojos = servicioNinja.DojoYSusNinjas(id);
		model.addAttribute("dojos", dojos);
		return "show.jsp";
	}
	
	
	
}
