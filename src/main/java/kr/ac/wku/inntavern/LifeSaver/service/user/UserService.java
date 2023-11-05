package kr.ac.wku.inntavern.LifeSaver.service.user;

import kr.ac.wku.inntavern.LifeSaver.entity.user.LifeSaverUser;
import kr.ac.wku.inntavern.LifeSaver.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LifeSaverUser create(String username, String email, String password){
        LifeSaverUser user = new LifeSaverUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }
}
