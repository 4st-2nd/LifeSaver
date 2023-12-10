package kr.ac.wku.inntavern.LifeSaver.controller;

import kr.ac.wku.inntavern.LifeSaver.entity.posts.Posts;
import kr.ac.wku.inntavern.LifeSaver.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class Main_Controller {
    private final PostsService postsService;
    @GetMapping("/")
    public String gotoMain(){
        return "index";
    }
    @GetMapping("/map")
    public String showMap() {return "analyzing_map";}

    @GetMapping("/type")
    public String showType() {return "analyzing_type";}

    @GetMapping("/home")
    public String selectImageList(Model model) {
        List<Posts> postsList = this.postsService.getRandomPosts(5);
        model.addAttribute("postsList", postsList);
        return "analyzing_user";
    }
}
