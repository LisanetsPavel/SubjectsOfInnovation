package com.controller;

import com.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by pc8 on 19.04.16.
 */
@Controller
public class MainController {

    @Autowired
    OrganizationService organizationService;


    String json = "{\"id\":null,\"fullName\":\"org3\",\"shortName\":null," +
            "\"fullNameEng\":null,\"form\":null,\"subordination\":null,\"" +
            "projects\":null,\"code\":null,\"legalAdress\":null,\"factualAdress\":null," +
            "\"phoneNumber\":null,\"site\":null,\"email\":null,\"nameOfDirector\":null,\"" +
            "founder\":null,\"" +
            "subject\":{\"id\":null,\"name\":\"sub\",\"url\":null,\"organizations\":null,\"memberships\":null},\"" +
            "location\":null,\"membership\": {\"name\" : \"memberrr\" },\"" +
            "scopes\":[{\"id\":null,\"name\":\"sco\",\"organizations\":null}],\"" +
            "phases\":[{\"id\":null,\"name\":\"pha\",\"organizations\":null}]}";




    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
           return "app/index.html";
    }

    @RequestMapping(value = "/setOrg", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void setOrg(@RequestParam String organization){
        System.out.println("setOrg Controller");
        organizationService.setOrganization(organization);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getOrg(){
        return "app/admin.html";
    }

    @RequestMapping(value = "/sendData", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void setData(@RequestParam(value = "param") String param){
        System.out.println("data   ---- " + param);
    }


    @RequestMapping(value = "/img", method = RequestMethod.GET)
    public String img(){
        return "app/index.html";
    }
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(){
        System.out.println("error");
        return "app/error.html";
    }


}
