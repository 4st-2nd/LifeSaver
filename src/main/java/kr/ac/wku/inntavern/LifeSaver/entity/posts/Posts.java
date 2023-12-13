package kr.ac.wku.inntavern.LifeSaver.entity.posts;

import jakarta.persistence.*;
import kr.ac.wku.inntavern.LifeSaver.entity.comments.Comments;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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
    private LocalDate createTime;

    private String tags;

    @OneToMany(mappedBy = "posts", cascade = CascadeType.REMOVE)
    private List<Comments> commentsLIST;

    public Posts(){

    }
    public Posts(String title, String contents, String tags, int views, LocalDate createTime) {
        this.title = title;
        this.contents = contents;
        this.views = views;
        this.tags = tags;
        this.createTime = createTime;
    }
}
