package kr.ac.wku.inntavern.LifeSaver.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.nio.file.attribute.UserPrincipal;

public class AuthenticationController
{
    @GetMapping("/profile")
    public String showProfile(Model model, @AuthenticationPrincipal UserPrincipal userPrincipal) {
            model.addAttribute("username", userPrincipal);
        return "user_edit_info";
    }
}
