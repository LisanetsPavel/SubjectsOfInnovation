package com.controller;

import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pc8 on 28.04.16.
 */
@Secured("ROLE_ADMIN")
@Controller
public class AdminController {

    @Autowired
    ScopeService scopeService;

    @Autowired
    MembershipService membershipService;

    @Autowired
    LocationService locationService;

    @Autowired
    PhaseService phaseService;

    @Autowired
    SubjectService subjectService;

    @RequestMapping(value = "/setScope", method = RequestMethod.GET)
    public String setScope(@RequestParam String name){

        System.out.println("setScope");
        scopeService.setScope(name);
        return "app/index.html";

    }

    @RequestMapping(value = "/setLocation", method = RequestMethod.GET)
    public String setLocation(@RequestParam String name){

        System.out.println("setLocation");
        locationService.setLocation(name);
        return "app/index.html";

    }

    @RequestMapping(value = "/setMembership", method = RequestMethod.GET)
    public String setMembership(@RequestParam String name){

        System.out.println("setMembersip");
        membershipService.setMembership(name);
        return "app/index.html";

    }

    @RequestMapping(value = "/setPhase", method =  RequestMethod.GET)
    public String setPhase(@RequestParam String name){
        System.out.println("setPhase");
        phaseService.setPhase(name);
        return "app/index.html";
    }

    @RequestMapping(value = "/setSubject", method =  RequestMethod.GET)
    public String setSubject(@RequestParam String name,
                           String url){
       System.out.println("setSubject");
       subjectService.setSubject(name, url);

        return "app/index.html";
    }


}
