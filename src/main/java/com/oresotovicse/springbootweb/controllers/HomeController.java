package com.oresotovicse.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){

        //return "redirect:/app/index";
        return "forward:/app/index";

    }

}
