package kr.ac.wku.inntavern.LifeSaver;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateForm {
    @Size(min = 3, max = 25)
    private String username;

    @Email
    private String email;

    private String address;

    @Pattern(regexp ="(^$|[0-9]{11})")
    private String phone_number;
}
