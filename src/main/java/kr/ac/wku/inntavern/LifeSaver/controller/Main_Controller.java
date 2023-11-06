package kr.ac.wku.inntavern.LifeSaver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main_Controller {

    @GetMapping("/")
    public String showMain() {
        return "/index";
    }

    @GetMapping("/map")
    public String showMap() {return "/analyzingmap";}
}
