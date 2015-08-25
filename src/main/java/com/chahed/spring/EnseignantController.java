package com.chahed.spring;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chahed.spring.model.Classe;
import com.chahed.spring.model.Cours;
import com.chahed.spring.model.Enseignant;

import com.chahed.spring.service.ClasseService;
import com.chahed.spring.service.CoursService;
import com.chahed.spring.service.EnseignantService;

 
@Controller
public class EnseignantController {
	@Autowired
   EnseignantService enseignantService;
	@Autowired
    ClasseService classeService; 
	@Autowired
    CoursService coursService; 

    @Autowired(required=true)
    @Qualifier(value="enseignantService")
    public void SetEnseignantService(EnseignantService es){
        this.enseignantService = es;
    }
    @Autowired(required=true)
    @Qualifier(value="classeService")
    public void setClasseService(ClasseService ps){
        this.classeService = ps;
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String Acceuil(Model model) {
    
        return "index";
    }
    
    @RequestMapping(value = "/inscParent", method = RequestMethod.GET)
    public String inscParent(Model model) {
    
        return "inscriptionParent";
    }
    @RequestMapping(value = "/inscEnseignant", method = RequestMethod.GET)
    public String inscEnseignant(Model model) {
    
        return "inscriptionEnseignant";
    }
    
   
    
    @RequestMapping(value = "/enseignants", method = RequestMethod.GET)
    public String listEnseignant(Model model) {
        model.addAttribute("enseignant", new Enseignant());
        model.addAttribute("listenseignant", this.enseignantService.listEnseignants());
        model.addAttribute("listCours", this.coursService.listCours());
        return "enseignant";
    }
    
    
    //For add and update person both
    @RequestMapping(value= "/enseignant/ajout", method = RequestMethod.POST)
    public String addEnseignant(@ModelAttribute("enseignant") Enseignant e){
         
        if(e.getId() == 0){
            //new person, add it
            this.enseignantService.addEnseignant(e);
        }else{
            //existing person, call update
            this.enseignantService.updateEnseignant(e);
        }
         
        return "redirect:/enseignants";
         
    }
     
    @RequestMapping("/suppEnseignant/{id}")
    public String removeEnseignant(@PathVariable("id") int id){
         
        this.enseignantService.removeEnseignant(id);
        return "redirect:/enseignants";
    }
  
  
}