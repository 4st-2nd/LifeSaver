package kr.ac.wku.inntavern.LifeSaver.repository.company;

import kr.ac.wku.inntavern.LifeSaver.entity.comments.Comments;
import kr.ac.wku.inntavern.LifeSaver.entity.company.Company;
import kr.ac.wku.inntavern.LifeSaver.entity.user.LifeSaverUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Comments, Long> {
}
