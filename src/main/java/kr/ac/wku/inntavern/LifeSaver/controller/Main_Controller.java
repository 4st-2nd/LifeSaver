package kr.ac.wku.inntavern.LifeSaver.controller;

import kr.ac.wku.inntavern.LifeSaver.entity.posts.Posts;
import kr.ac.wku.inntavern.LifeSaver.entity.user.LifeSaverUser;
import kr.ac.wku.inntavern.LifeSaver.service.posts.PostsService;
import kr.ac.wku.inntavern.LifeSaver.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class Main_Controller {
    private final PostsService postsService;
    private final UserService userService;

    @GetMapping("/")
    public String gotoMain(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();

        String username = principal.getUsername();

        LifeSaverUser user = userService.getCurrentUser(username);

        if (user == null) {
            return "user_signin";
        }

        model.addAttribute("username", username);
        return "index";
    }
    @GetMapping("/map")
    public String showMap(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();

        String username = principal.getUsername();

        LifeSaverUser user = userService.getCurrentUser(username);

        if (user == null) {
            return "user_signin";
        }

        model.addAttribute("username", username);

        return "analyzing_map";}

    @GetMapping("/type")
    public String showType(Model model) {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();

        String username = principal.getUsername();

        LifeSaverUser user = userService.getCurrentUser(username);
        if (user == null) {
            return "user_signin";
        }

        List<Posts> postsList = this.postsService.getRandomPosts(5);
        model.addAttribute("postsList", postsList);
        return "analyzing_type";}

    @GetMapping("/home")
    public String showUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();

        String username = principal.getUsername();

        LifeSaverUser user = userService.getCurrentUser(username);

        if (user == null) {
            return "user_signin";
        }

        model.addAttribute("username", username);
        model.addAttribute("real_name", user.getReal_name());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("address", user.getAddress());
        model.addAttribute("phone_number", user.getPhone_number());

        List<Posts> postsList = this.postsService.getRandomPosts(5);
        model.addAttribute("postsList", postsList);
        return "analyzing_user";
    }
}
