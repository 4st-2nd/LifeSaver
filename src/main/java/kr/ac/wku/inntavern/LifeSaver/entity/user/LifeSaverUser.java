package kr.ac.wku.inntavern.LifeSaver.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class LifeSaverUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;//로그인시 사용되는 아이디

    private String real_name;

    private String password;


    private String phone_number;//사용중인 전화번호

    private String address;//살고있는 곳의 주소

    @Column(unique = true)
    private String email;
}
