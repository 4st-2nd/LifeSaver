package kr.ac.wku.inntavern.LifeSaver.repository.user;

import kr.ac.wku.inntavern.LifeSaver.entity.user.LifeSaverUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<LifeSaverUser, Long> {

}
