package com.controller;

import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    OrganizationService organizationService;

    @RequestMapping(value = "/setScope", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void setScope(@RequestParam String name){

        scopeService.setScope(name);
    }

    @RequestMapping(value = "/setLocation", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void setLocation(@RequestParam("name") String name){
        System.out.println("setLOcation");
        locationService.setLocation(name);

    }

    @RequestMapping(value = "/setMembership", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void setMembership(@RequestParam String name){

        membershipService.setMembership(name);

    }

    @RequestMapping(value = "/setPhase", method =  RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void setPhase(@RequestParam String name){

        phaseService.setPhase(name);

    }


    @RequestMapping(value = "/setSubject", method =  RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void setSubject(@RequestParam String name,
                           String url){

       subjectService.setSubject(name, url);

    }

    @RequestMapping(value = "/agree", method =  RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void agree(@RequestParam Integer  id){
        System.out.println("Agreeeeeee" );
        System.out.println(id);
        organizationService.agree(id);
    }


}
