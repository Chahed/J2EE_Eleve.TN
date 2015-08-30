package com.chahed.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventsController {
	@RequestMapping("/events")
    public String getEvents(HttpServletRequest request) {
    	EventsManager evs = new EventsManager(request);
   return evs.run();
   }
   
   
    @RequestMapping(value = "/javaplanner", method = RequestMethod.GET)
    public String JavaPlanner(Model model) {
    
        return "javaplanner";
    }
   
}
