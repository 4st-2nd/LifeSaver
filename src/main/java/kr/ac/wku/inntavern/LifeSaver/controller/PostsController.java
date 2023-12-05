package kr.ac.wku.inntavern.LifeSaver.controller;

import kr.ac.wku.inntavern.LifeSaver.entity.posts.Posts;
import kr.ac.wku.inntavern.LifeSaver.repository.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostsController {

    private final PostsRepository postsRepository;

    @GetMapping("/edu")
    public String showEdu(Model model) {
        List<Posts> postsList = this.postsRepository.findAll();
        model.addAttribute("postsList", postsList);
        return "/educational"; }

    @GetMapping(value = "/edu/posts/{id}")
    public String postsMaterial(Model model, @PathVariable("id") Long id){
        return "/educational_material";
    }
}
