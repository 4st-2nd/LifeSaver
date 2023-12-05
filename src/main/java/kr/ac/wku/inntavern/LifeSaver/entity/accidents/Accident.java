package kr.ac.wku.inntavern.LifeSaver.entity.accidents;

import jakarta.persistence.*;
import kr.ac.wku.inntavern.LifeSaver.entity.company.Company;

import java.time.LocalDateTime;

public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private long userid;
    @Column(columnDefinition = "TEXT")
    private String contents;

    private LocalDateTime createTime;

}
