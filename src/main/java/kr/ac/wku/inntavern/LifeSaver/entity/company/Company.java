package kr.ac.wku.inntavern.LifeSaver.entity.company;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import kr.ac.wku.inntavern.LifeSaver.entity.accidents.Accident;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Company {
    @Id
    private Long id;

    private String title;

    private String address; //kakaoMap API를 통해 address를 lat, lon으로 변환해줘야함.

    private int unreported_accident_count;

    private String tags;

}
