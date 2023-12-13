package kr.ac.wku.inntavern.LifeSaver.controller;

import kr.ac.wku.inntavern.LifeSaver.entity.user.LifeSaverUser;
import kr.ac.wku.inntavern.LifeSaver.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/updateInfo")
public class ProfileController {
    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> updateUserInfo(@RequestParam(value="real_name") String real_name, @RequestParam(value="email") String email, @RequestParam(value="address") String address, @RequestParam(value="phone_number") String phone_number) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();

        String username = principal.getUsername();

        LifeSaverUser user = userService.getCurrentUser(username);

        try {
            userService.updateUserInfos(username, real_name, email, phone_number, address);
            return ResponseEntity.ok().location(new URI("analyzing_user")).build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("이미 등록된 사용자입니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("서버 오류입니다.");
        }
    }
}
