package com.chahed.spring;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chahed.spring.model.Classe;

import com.chahed.spring.model.Profil;
import com.chahed.spring.model.Remarque;
import com.chahed.spring.service.ClasseService;

import com.chahed.spring.service.ProfilService;
import com.chahed.spring.service.RemarqueService;
 
@Controller
public class PersonController {
     

    private ClasseService classeService; 
    private ProfilService profilService;
    private RemarqueService remarqueService; 
    
   
    @Autowired(required=true)
    @Qualifier(value="classeService")
    public void setClasseService(ClasseService ps){
        this.classeService = ps;
    }
    
    @Autowired(required=true)
    @Qualifier(value="profilService")
    public void setProfilService(ProfilService ps){
        this.profilService = ps;
    }
    
    @Autowired(required=true)
    @Qualifier(value="remarqueService")
    public void setRemarqueService(RemarqueService ps){
        this.remarqueService = ps;
    }
    
    //----------------------------------------------
    
  
    @RequestMapping(value = "/eleve", method = RequestMethod.GET)
    public String Eleve(Model model) {    	
    	   model.addAttribute("classe", new Classe(null));
          model.addAttribute("classes", this.classeService.listClasse());
        return "eleve";
    }
    
    @RequestMapping(value= "/eleve/ajout", method = RequestMethod.POST)
    public String addCl(@ModelAttribute("a") String a){
    	System.out.println(a);
    		Classe p = new Classe(a);
            this.classeService.addClasse(p);
        return "redirect:/eleve";
         
    }
    
    @RequestMapping(value = "/eleve/{id}", method = RequestMethod.GET)
    public String classe(Model model, @PathVariable("id") int id) {    	
    	 model.addAttribute("id1", id);
    	 model.addAttribute("eleve", new Profil());
    	 List<Profil> p = this.profilService.ListProfilbyClasse(id);
    	 model.addAttribute("P", p );
        return "classe";
    }
    
    @RequestMapping(value= "/eleve/{id1}/ajout")
    public String addProfil(@ModelAttribute("eleve") Profil p, @ModelAttribute("id1") int id1){
         System.out.println(p.getNom());
         System.out.println(p.getPrenom());
         System.out.println(p.getDateNaissance());
         Classe C = classeService.getClasseById(id1);
         p.setClasse(C);
       
        if(p.getId() == 0){
            //new person, add it
            this.profilService.addProfil(p);
        }else{
            //existing person, call update
            this.profilService.updateProfil(p);
        }
         
        return "redirect:/eleve/"+id1;
         
    } 

    
    @RequestMapping("/eleve/supp/{id}")
    public String removeProfil(@PathVariable("id") int id ){
        int id1 = profilService.getProfilById(id).getClasse().getId();
        this.profilService.removeProfil(id);
        
        //int id1= profilService.getProfilById(id).getClasse().getId();
        return "redirect:/eleve/"+id1;
    }
    
    @RequestMapping(value="/eleve/modifier/{id}", method = RequestMethod.GET)
    public String editProfil(@PathVariable("id") int id, Model model){
        model.addAttribute("eleve", this.profilService.getProfilById(id));
        int id1= profilService.getProfilById(id).getClasse().getId();
        model.addAttribute("id1",id1);
        List<Profil> p = this.profilService.ListProfilbyClasse(id1);
        model.addAttribute("P", p );
        return "classe";
    }
    
 
  
   
  
    
    
    @RequestMapping(value = "/remarque", method = RequestMethod.GET)
    public String Remarque(Model model) {    	
    	   model.addAttribute("classe", new Classe(null));
          model.addAttribute("classes", this.classeService.listClasse());
        return "remarque";
    }
    @RequestMapping(value = "/remarque/{id}", method = RequestMethod.GET)
    public String Rmq(Model model, @PathVariable("id") int id) {    	
    	 model.addAttribute("id", id);
    	 List<Profil> p = this.profilService.ListProfilbyClasse(id);
    	 model.addAttribute("P", p );
        return "remarque_by_classe";
    }
    @RequestMapping(value="/remarque/details/{id}", method = RequestMethod.GET)
    public String rmqdétail(@PathVariable("id") int id, Model model){
    	model.addAttribute("profil", this.profilService.getProfilById(id));
    	 List<Remarque> p = this.remarqueService.ListRemarquebyEleve(id);
    	 model.addAttribute("P", p );
        return "RemarqueEdit";
       
    }
    @RequestMapping(value="/remarque/parent/{id}", method = RequestMethod.GET)
    public String rmqparent(@PathVariable("id") int id, Model model){
    	model.addAttribute("profil", this.profilService.getProfilById(id));
    	 List<Remarque> p = this.remarqueService.ListRemarquebyEleve(id);
    	 model.addAttribute("P", p );
        return "Remarque_by_eleve";
       
    }
    @RequestMapping(value= "/remarque/ajout/{id}")
    public String addRmq( @ModelAttribute("id") int id1,@ModelAttribute("a") String a){
    	System.out.println(a);
    	Profil p = profilService.getProfilById(id1);
    		Remarque r = new Remarque(a,p);
            this.remarqueService.addRemarque(r);
        return "redirect:/remarque/details/"+id1;
     
    }
}