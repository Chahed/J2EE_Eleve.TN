package com.chahed.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chahed.spring.model.Cours;
import com.chahed.spring.service.CoursService;
@Controller
public class CoursController {
	@Autowired
	private CoursService coursService; 
	
	 
	  
	    
	    @Autowired(required=true)
	    @Qualifier(value="coursService")
	    public void setCoursService(CoursService cs){
	        this.coursService = cs;
	    }
	   
	    
	         
	    @RequestMapping(value = "/cours", method = RequestMethod.GET)
	    public String listCours(Model model) {
	        model.addAttribute("cours", new Cours());
	        model.addAttribute("listCours", this.coursService.listCours());
	        return "cours";
	    }
	    @RequestMapping(value = "/coursList", method = RequestMethod.GET)
	    public String list(Model model) {
	        model.addAttribute("cours", new Cours());
	        model.addAttribute("listCours", this.coursService.listCours());
	        return "coursList";
	    }
	    
	    @RequestMapping(value= "/cours/ajout", method = RequestMethod.POST)
	    public String addCours(@ModelAttribute("cours") Cours c){
	         
	        if(c.getId() == 0){
	            //new person, add it
	            this.coursService.addCours(c);
	        }else{
	            //existing person, call update
	            this.coursService.updateCours(c);
	        }
	         
	        return "redirect:/cours";
	         
	    }
	     

	    @RequestMapping("/modifierCours/{id}")
	    public String editCours(@PathVariable("id") int id, Model model){
	        model.addAttribute("cours", this.coursService.getCoursById(id));
	        model.addAttribute("listCours", this.coursService.listCours());
	        return "cours";
	    }
	    @RequestMapping("/suppCours/{id}")
	    public String removeCours(@PathVariable("id") int id){
	         
	        this.coursService.removeCours(id);
	        return "redirect:/cours";
	    }
	  
}
