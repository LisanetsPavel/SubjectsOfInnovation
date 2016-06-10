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


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "app/index.html";
    }

    @RequestMapping(value = "/setOrg", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void setOrg(@RequestParam String organization) {
        organizationService.setOrganization(organization);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getOrg() {
        return "app/admin.html";
    }


}
