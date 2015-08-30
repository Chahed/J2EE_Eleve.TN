package com.chahed.spring;
 
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chahed.spring.model.Parent;
import com.chahed.spring.model.UserRole;
import com.chahed.spring.model.Users;
import com.chahed.spring.service.ParentService;
import com.chahed.spring.service.UserRoleService;
import com.chahed.spring.service.UserService;

 
@Controller
public class ParentController {
	@Autowired
   ParentService parentService;


    @Autowired(required=true)
    @Qualifier(value="parentService")
    public void SetParentService(ParentService es){
        this.parentService = es;
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
  
    
    @RequestMapping(value = "/parent", method = RequestMethod.GET)
    public String listParent(Model model) {
        model.addAttribute("parent", new Parent());
        model.addAttribute("listparent", this.parentService.listParent());
        return "parent";
    }
    
    @RequestMapping(value = "/inscP", method = RequestMethod.GET)
    public String inscParent(Model model) {
    
        return "inscparent";
    }
    @RequestMapping(value= "/parent/ajout", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("Parent") Parent e, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/inscParent";
        }
        String nom = e.getNom();
        String mdp = e.getMotdepasse();
        Users u = new Users(nom,mdp,true);
        UserRole r = new UserRole(u,"ROLE_PARENT");
        this.parentService.addParent(e);
        this.userService.addUser(u);
        this.userRoleService.addUserRole(r);
        return "redirect:/home";
    }
    
    
//    @RequestMapping(value= "/parent/ajout", method = RequestMethod.POST)
//    public String addParent(@Valid @ModelAttribute("Parent") Parent e){
//         
//        if(e.getId() == 0){
//            
//            this.parentService.addParent(e);
//        }else{
//            this.parentService.updateParent(e);
//        }
//         
//        return "redirect:/parent";
//         
//    }
    @RequestMapping("/modifierParent/{id}")
    public String editCours(@PathVariable("id") int id, Model model){
        model.addAttribute("parent", this.parentService.getParentById(id));
        model.addAttribute("listparent", this.parentService.listParent());
        return "parent";
    }
     
    @RequestMapping("/suppParent/{id}")
    public String removeParent(@PathVariable("id") int id){
         
        this.parentService.removeParent(id);
        return "redirect:/parent";
    }
  
  
}