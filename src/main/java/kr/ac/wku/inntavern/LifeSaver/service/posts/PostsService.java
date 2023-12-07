package kr.ac.wku.inntavern.LifeSaver.service.posts;

import kr.ac.wku.inntavern.LifeSaver.DataNotFoundException;
import kr.ac.wku.inntavern.LifeSaver.entity.posts.Posts;
import kr.ac.wku.inntavern.LifeSaver.repository.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public List<Posts> getList(){
        return this.postsRepository.findAll();
    }

    public Posts getPosts(Long id){
        Optional<Posts> posts = this.postsRepository.findById(id);
        if(posts.isPresent()){
            return posts.get();
        }else{
            throw new DataNotFoundException("게시글을 찾을 수 없습니다.");
        }
    }
}
