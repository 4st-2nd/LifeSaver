package kr.ac.wku.inntavern.LifeSaver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main_Controller {
    @GetMapping("/")
    public String gotoMain(){
        return "index";
    }
    @GetMapping("/map")
    public String showMap() {return "analyzing_map";}

    @GetMapping("/type")
    public String showType() {return "analyzing_type";}

    @GetMapping("/home")
    public String selectImageList() {
        return "analyzing_user";
    }
}
