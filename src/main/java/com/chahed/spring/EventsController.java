package com.chahed.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chahed.spring.model.Cours;
import com.chahed.spring.model.Enseignant;
import com.chahed.spring.service.CoursService;
import com.chahed.spring.service.EnseignantService;

@Controller
public class EventsController {
	
	@Autowired
	private CoursService coursService; 
	
	 
	  
	    
	    @Autowired(required=true)
	    @Qualifier(value="coursService")
	    public void setCoursService(CoursService cs){
	        this.coursService = cs;
	    }
	
	    @Autowired
		private EnseignantService enseignantService; 
		
		 
		  
		    
		    @Autowired(required=true)
		    @Qualifier(value="enseignantService")
		    public void setEnseignantService(EnseignantService cs){
		        this.enseignantService = cs;
		    }
	@RequestMapping("/events")
    public String getEvents(HttpServletRequest request) {
    	EventsManager evs = new EventsManager(request);
   return evs.run();
   }
   
   
    @RequestMapping(value = "/javaplanner", method = RequestMethod.GET)
    public String JavaPlanner(Model model) {
    
        return "javaplanner";
    }
    
    @RequestMapping(value = "/Calendar", method = RequestMethod.GET)
    public String calendar(Model model) {
    	 model.addAttribute("cours", new Cours());
	     model.addAttribute("listCours", this.coursService.listCours());
	     model.addAttribute("enseignant", new Enseignant());
	     model.addAttribute("listEnseignant", this.enseignantService.listEnseignants());
        return "calendar";
    }
   
}
