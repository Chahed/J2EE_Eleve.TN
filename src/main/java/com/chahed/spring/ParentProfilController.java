package com.chahed.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chahed.spring.model.Classe;
import com.chahed.spring.model.Cours;
import com.chahed.spring.model.Enseignant;
import com.chahed.spring.model.Parent;
import com.chahed.spring.model.Profil;
import com.chahed.spring.service.ClasseService;
import com.chahed.spring.service.CoursService;
import com.chahed.spring.service.EnseignantService;
import com.chahed.spring.service.ParentService;
import com.chahed.spring.service.ProfilService;

@Controller
public class ParentProfilController {
	
	@Autowired
	ParentService parentService;
	
	@Autowired
	 ProfilService profilService;

	@Autowired ClasseService classeService;
	

	
	
    @RequestMapping(value = "/parentprofil/classe/{id}", method = RequestMethod.GET)
    public String classes(Model model,@PathVariable("id")int parentId  ) {    	
    	   model.addAttribute("classe", new Classe(null));
    	   model.addAttribute("parent",parentService.getParentById(parentId));
          model.addAttribute("classes", this.classeService.listClasse());
        return "parentprofilclasses";
    }
	
	@RequestMapping("/parentprofil/{idc}/{idp}")
	public String listFollows(ModelMap model,@PathVariable("idp")int parentId,@PathVariable("idc")int classeId ){
		model.addAttribute("listprofil", parentService.listProfil(parentId));
		Parent parent= parentService.getParentById(parentId);
		model.addAttribute("parent",parent);
		model.addAttribute("offeredProfil",profilService.ListProfilbyClasse(classeId));
		model.addAttribute("profil", new Profil());
		return "parentprofil";
	}
	
	@RequestMapping(value = "parentprofil/addParentProfil", method = RequestMethod.POST)
    public String addParentProfil() {
		
		parentService.addProfiltoParent(16,23);
        return "redirect:/parent/";
		
    }

}
