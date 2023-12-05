package kr.ac.wku.inntavern.LifeSaver.entity.tags;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tags {
    @Id
    private Long id;

    private String title;
}
