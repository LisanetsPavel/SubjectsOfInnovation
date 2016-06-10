package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pc8 on 23.03.16.
 */
@Controller
public class LoginController {



    @RequestMapping(value="login", method = RequestMethod.GET)
     public String login() {

        return "app/login.html";
    }

    @ResponseBody
    @RequestMapping(value = "/403" , method = {RequestMethod.GET, RequestMethod.POST} )
     public String errorPage()
    {
        //TODO
        return "Error!!!!!!!!!!!!!!!!!!!!";

    }

}
