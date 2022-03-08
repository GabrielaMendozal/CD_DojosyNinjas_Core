package com.codingdojo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.modelos.Dojo;

@Controller
public class ControladorIndex {

	@RequestMapping( value = "/", method=RequestMethod.GET)
	public String despliegaIndex(@ModelAttribute("dojo") Dojo nuevoDojo) {
		return "index.jsp";
	}
}
