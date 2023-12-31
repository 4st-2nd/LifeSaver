package kr.ac.wku.inntavern.LifeSaver.controller;

import kr.ac.wku.inntavern.LifeSaver.entity.user.LifeSaverUser;
import kr.ac.wku.inntavern.LifeSaver.repository.user.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import kr.ac.wku.inntavern.LifeSaver.UserCreateForm;
import kr.ac.wku.inntavern.LifeSaver.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/editInfo")
    public String editInfo(Model model) {
        return "user_edit_info";
    }

    @GetMapping("/signin")
    public String signin(){
        return "user_signin";
    }
    @GetMapping("/register")
    public String register(UserCreateForm userCreateForm){
        return "user_register";
    }

    @PostMapping("/register")
    public String register(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_register";
        }

        if (!userCreateForm.getPassword().equals(userCreateForm.getConfirm_password())) {
            bindingResult.rejectValue("confirm_password", "passwordInCorrect",
                    "패스워드가 일치하지 않습니다.");
            return "user_register";
        }

        try{
            userService.create(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword());
        }catch(DataIntegrityViolationException e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자 입니다.");
            return "user_register";
        }catch(Exception e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "user_register";
        }

        /*
        userService.create(userCreateForm.getUsername(),
                userCreateForm.getEmail(), userCreateForm.getPassword());
         */

        return "redirect:/user/signin";
    }

}
