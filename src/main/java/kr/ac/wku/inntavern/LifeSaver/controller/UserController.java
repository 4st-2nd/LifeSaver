package kr.ac.wku.inntavern.LifeSaver.controller;

import jakarta.validation.Valid;
import kr.ac.wku.inntavern.LifeSaver.UserCreateForm;
import kr.ac.wku.inntavern.LifeSaver.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

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
                    "2개의 패스워드가 일치하지 않습니다.");
            return "user_register";
        }

        userService.create(userCreateForm.getUsername(),
                userCreateForm.getEmail(), userCreateForm.getPassword());

        return "redirect:/";
    }
}
