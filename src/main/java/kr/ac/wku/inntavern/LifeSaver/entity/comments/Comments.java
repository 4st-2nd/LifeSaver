package kr.ac.wku.inntavern.LifeSaver.entity.comments;

import jakarta.persistence.*;
import kr.ac.wku.inntavern.LifeSaver.entity.posts.Posts;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private long userid;
    @Column(columnDefinition = "TEXT")
    private String contents;

    private LocalDateTime createTime;

    @ManyToOne
    private Posts posts;
}
