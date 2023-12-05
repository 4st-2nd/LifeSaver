package kr.ac.wku.inntavern.LifeSaver.repository.comments;

import kr.ac.wku.inntavern.LifeSaver.entity.comments.Comments;
import kr.ac.wku.inntavern.LifeSaver.entity.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
}
