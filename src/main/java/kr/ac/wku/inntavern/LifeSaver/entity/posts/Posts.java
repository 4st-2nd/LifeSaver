package kr.ac.wku.inntavern.LifeSaver.entity.posts;

import jakarta.persistence.*;
import kr.ac.wku.inntavern.LifeSaver.entity.comments.Comments;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Posts{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int opcode;

    private String title;

    //private long userid;

    @Column(columnDefinition = "TEXT")
    private String contents;

    private long views;
    //미사용
    private LocalDateTime createTime;

    private String tags;

    @OneToMany(mappedBy = "posts", cascade = CascadeType.REMOVE)
    private List<Comments> commentsLIST;

    public Posts(){

    }
    public Posts(String title, String contents, int views, LocalDateTime createTime) {
        this.title = title;
        this.contents = contents;
        this.views = views;
        this.createTime = createTime;
    }
}
