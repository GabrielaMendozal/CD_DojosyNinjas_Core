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






@Controller

public class ControladorDojo {

	private final ServicioDojo servicioDojo;

	
	public ControladorDojo(ServicioDojo servicio) {  //constructor
		this.servicioDojo = servicio;
	}
	
	@RequestMapping( value = "dojos/new", method=RequestMethod.GET)
	public String despliegaRegistroDojo(@ModelAttribute("dojo") Dojo nuevoDojo) {
		return "index.jsp";
	}
	
	@RequestMapping( value ="/registrado", method = RequestMethod.POST)
	public String registrarDojo (@Valid @ModelAttribute("dojo") Dojo nuevoDojo, BindingResult result ) {
		System.out.println("Que pasa?");
		System.out.println(nuevoDojo.getName() );
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
		servicioDojo.insertIntoDojos(nuevoDojo);
			return "redirect:/ninjas/new";
	    }
		
	}
	
	@RequestMapping( value="/ninjas/new", method = RequestMethod.GET)
	public String despliegaRegistroNinjas(Model model, @ModelAttribute("ninja") Ninja nuevoNinja ) {
		List<Dojo>listaDojos = servicioDojo.selectAllFromDojo();
		model.addAttribute("listaDojos", listaDojos);
		return "registroNinja.jsp";
	}

	
}

