package isilproducts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Habilitar MVC
@Controller
public class Index {

    @GetMapping({"/", "/index"})
    public String index(){
        return "index";
    }



}
