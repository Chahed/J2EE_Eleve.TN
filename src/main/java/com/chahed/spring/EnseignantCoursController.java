package com.chahed.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chahed.spring.model.Cours;
import com.chahed.spring.model.Enseignant;
import com.chahed.spring.service.CoursService;
import com.chahed.spring.service.EnseignantService;

@Controller
public class EnseignantCoursController {
	
	
	@Autowired
	EnseignantService enseignantService;
	
	@Autowired
	 CoursService coursService; 
	
	@ModelAttribute("offeredCours")
	public List<Cours> populateOfferedCours(){
		return coursService.listCours();
	}
	
	@RequestMapping("/enseignantcours/{enseignantId}")
	public String listFollows(ModelMap model,@PathVariable("enseignantId")int enseignantId){
		model.addAttribute("listCours", enseignantService.listGives(enseignantId));
		Enseignant enseignant= enseignantService.getEnseignantById(enseignantId);
		model.addAttribute("enseignant",enseignant);
		model.addAttribute("cours", new Cours());
		return "enseignantcours";
	}
	
	@RequestMapping(value = "enseignantcours/addEnseignantCours", method = RequestMethod.POST)
    public String addEnseignantCours(@ModelAttribute("idEnseignant") int ide ,@ModelAttribute("idCours") int idc) {
		
		enseignantService.addCoursToEnseignant(ide, idc);
        return "redirect:/enseignantcours/" + ide;
		
    }

}
