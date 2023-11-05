package kr.ac.wku.inntavern.LifeSaver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main_Controller {

    @GetMapping("/")
    public String showMain() {
        return "dist/index";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "dist/login";
    }

}
