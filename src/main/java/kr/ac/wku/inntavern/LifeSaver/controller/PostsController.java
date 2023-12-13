package kr.ac.wku.inntavern.LifeSaver.controller;

import kr.ac.wku.inntavern.LifeSaver.entity.posts.Posts;
import kr.ac.wku.inntavern.LifeSaver.entity.user.LifeSaverUser;
import kr.ac.wku.inntavern.LifeSaver.repository.posts.PostsRepository;
import kr.ac.wku.inntavern.LifeSaver.service.posts.PostsService;
import kr.ac.wku.inntavern.LifeSaver.service.user.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@RequestMapping("/posts/edu")
@RequiredArgsConstructor
@Controller
public class PostsController {

    private final PostsService postsService;
    private final UserService userService;

    @GetMapping("/list")
    public String showEdu(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();

        String username = principal.getUsername();

        LifeSaverUser user = userService.getCurrentUser(username);

        if (user == null) {
            return "user_signin";
        }

        model.addAttribute("username", username);
        List<Posts> postsList = this.postsService.getList();
        model.addAttribute("postsList", postsList);
        return "/educational"; }

    @GetMapping(value = "/list/{id}")
    public String postsMaterial(Model model, @PathVariable("id") Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();

        String username = principal.getUsername();

        LifeSaverUser user = userService.getCurrentUser(username);

        if (user == null) {
            return "user_signin";
        }

        model.addAttribute("username", username);
        Posts posts = this.postsService.getPosts(id);
        model.addAttribute("posts", posts);
        return "/educational_material";
    }

}