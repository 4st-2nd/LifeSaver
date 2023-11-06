package kr.ac.wku.inntavern.LifeSaver.repository.user;

import kr.ac.wku.inntavern.LifeSaver.entity.user.LifeSaverUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<LifeSaverUser, Long> {
    Optional<LifeSaverUser> findByusername(String username);
}
