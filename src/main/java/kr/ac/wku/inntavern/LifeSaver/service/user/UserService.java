package kr.ac.wku.inntavern.LifeSaver.service.user;

import kr.ac.wku.inntavern.LifeSaver.DataNotFoundException;
import kr.ac.wku.inntavern.LifeSaver.entity.posts.Posts;
import kr.ac.wku.inntavern.LifeSaver.entity.user.LifeSaverUser;
import kr.ac.wku.inntavern.LifeSaver.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    public LifeSaverUser updateUserInfos(String username, String real_name, String email, String phone_number, String address) throws Exception{
        LifeSaverUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new Exception("사용자가 존재하지 않습니다."));
        user.setReal_name(real_name);
        user.setEmail(email);
        user.setAddress(address);
        user.setPhone_number(phone_number);
        this.userRepository.save(user);
        return user;
    }

    public LifeSaverUser getCurrentUser(String username) throws UsernameNotFoundException {
        Optional<LifeSaverUser> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
    }


}
