package com.chahed.spring;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chahed.spring.model.Classe;
import com.chahed.spring.model.Cours;
import com.chahed.spring.model.Enseignant;
import com.chahed.spring.model.Parent;
import com.chahed.spring.model.Profil;
import com.chahed.spring.model.UserRole;
import com.chahed.spring.model.Users;
import com.chahed.spring.service.ClasseService;
import com.chahed.spring.service.CoursService;
import com.chahed.spring.service.EnseignantService;
import com.chahed.spring.service.UserRoleService;
import com.chahed.spring.service.UserService;

 
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
    
    @Autowired
    UserService userService; 
	@Autowired
    UserRoleService userRoleService; 
	
	@Autowired(required=true)
    @Qualifier(value="userService")
    public void SetUserService(UserService es){
        this.userService = es;
    }
	
	@Autowired(required=true)
    @Qualifier(value="userRoleService")
    public void SetUserRoleService(UserRoleService es){
        this.userRoleService = es;
    }
  
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String Acceuil(Model model) {
    
        return "index";
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String AcceuilEn(Model model) {
    
        return "user";
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
    @RequestMapping(value = "/listEnseignants", method = RequestMethod.GET)
    public String listEnseig(Model model) {
        model.addAttribute("enseignant", new Enseignant());
        model.addAttribute("listenseignant", this.enseignantService.listEnseignants());
        model.addAttribute("listCours", this.coursService.listCours());
        return "enseignantList";
    }
    
    
    //For add and update person both
    @RequestMapping(value= "/enseignant/ajout", method = RequestMethod.POST)
    public String addEnseignant(@ModelAttribute("enseignant") Enseignant e,BindingResult result){
    	if(result.hasErrors()) {
            return "redirect:/inscEnseignant";
        }
    	String login = e.getLogin();
        String mdp = e.getMotdepasse();
        Users u = new Users(login,mdp,false);
        UserRole r = new UserRole(u,"ROLE_USER");
        this.enseignantService.addEnseignant(e);
        this.userService.addUser(u);
        this.userRoleService.addUserRole(r);
        return "redirect:/home";
         
    }
    
  
    @RequestMapping("/suppEnseignant/{id}")
    public String removeEnseignant(@PathVariable("id") int id){
         
        this.enseignantService.removeEnseignant(id);
        return "redirect:/enseignants";
    }
  
  
}