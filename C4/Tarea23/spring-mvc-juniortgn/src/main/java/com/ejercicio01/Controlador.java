package com.ejercicio01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controlador {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage() {
        return "hello-world";
    }
}