package org.sid.web;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.sid.dao.EntrepriseRepository;
import org.sid.dao.TaxeRepository;
import org.sid.entities.Entreprise;
import org.sid.entities.Taxe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class TaxeController {
	
	@Autowired
	EntrepriseRepository entrepriseRepository ;
	@Autowired
	TaxeRepository taxeRepository;
	@RequestMapping(value="/entreprises",method=RequestMethod.GET)
	public String index(Model model,@RequestParam(name="motCle",defaultValue="")  String motCle
			,@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="5")int size){
		Page<Entreprise> pageEntreprises=entrepriseRepository.chercher("%"+motCle+"%",PageRequest.of(page, size));
		model.addAttribute("listeEntreprises",pageEntreprises.getContent());
		int [] indexPages = new int [pageEntreprises.getTotalPages()];
		model.addAttribute("indexPages",indexPages);
		model.addAttribute("currentPage",page);
		model.addAttribute("motCle",motCle);
		return "entreprises";
		
	}
	@RequestMapping(value="/newEntreprise",method=RequestMethod.GET)
	public String formEntreprise(Model model){
		model.addAttribute("entreprise",new Entreprise());
		return "formEntreprise";
		
	}
	@RequestMapping(value="/saveEntreprise",method=RequestMethod.POST)
	public String enregistrer(Model model,@Valid Entreprise e,BindingResult msgError){//binding result pour message d'erreur
		if( msgError.hasErrors()){
			return "formEntreprise";
		
		}
		entrepriseRepository.save(e);
		return "redirect:/entreprises";
	}
	@RequestMapping(value="/taxes",method=RequestMethod.GET)
	public String taxes(Model model,Long code){
		
	Entreprise e=new Entreprise();
	e.setCode(code);
	model.addAttribute("entreprises",entrepriseRepository.findAll());
	model.addAttribute("taxes", taxeRepository.findByEntreprise(e));
		
		return "taxes";
	}
	}


