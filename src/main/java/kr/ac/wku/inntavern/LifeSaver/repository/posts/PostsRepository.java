package kr.ac.wku.inntavern.LifeSaver.repository.posts;

import kr.ac.wku.inntavern.LifeSaver.entity.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    Posts findByTitle(String title);
    Posts findByTitleAndTags(String title, String tags);
    List<Posts> findByTitleContaining(String title);
}
