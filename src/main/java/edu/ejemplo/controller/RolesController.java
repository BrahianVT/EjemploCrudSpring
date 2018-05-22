package edu.ejemplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ejemplo.services.RolesService;

import edu.ejemplo.modelos.Roles;

@Controller
public class RolesController {
	@Autowired
	RolesService rolesService;
	
	@RequestMapping(value="/")
	public String index(Model m){
		
		m.addAttribute("rol", new Roles());
		m.addAttribute("listaRol", rolesService.getListaRoles());
		return "index";
	}
	
	@RequestMapping(value="/agregarActualizar", method=RequestMethod.POST)
	public String agregarOActualizar(@ModelAttribute("rol") Roles rol){
		rolesService.guardarRol(rol);
		return "redirect:/";
	}
	
	@RequestMapping(value="/editarRol/{idRol}", method=RequestMethod.GET)
	public String editarRol(@PathVariable("idRol") int idRol, Model m){
		Roles ver = rolesService.getRolbyId(idRol);
		System.out.println("Roles " + ver.getIdRol());
		m.addAttribute("rol",ver);
		m.addAttribute("listaRol", rolesService.getListaRoles());
		return "index";
	}
	
	@RequestMapping(value="/borrar/{idRol}", method=RequestMethod.GET)
	public String borrar(@PathVariable("idRol")int idRol){
		rolesService.borrarByIdRol(idRol);
		return "redirect:/";
	}
}
