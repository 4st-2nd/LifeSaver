package kr.ac.wku.inntavern.LifeSaver;

import kr.ac.wku.inntavern.LifeSaver.entity.posts.Posts;
import kr.ac.wku.inntavern.LifeSaver.repository.posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootApplication
public class LifeSaverApplication {

	public static void main(String[] args) {

		SpringApplication.run(LifeSaverApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PostsRepository postsRepository) {
		return (args) -> {
			// 임시 데이터 저장
			postsRepository.save(new Posts("어그로", "ㅈㄱㄴ", 0,LocalDate.now()));
			postsRepository.save(new Posts("진짜 어그로", "**마크다운 문법으로 작성해 봅니다.**\n" +
					"\n" +
					"* 리스트1\n" +
					"* 리스트2\n" +
					"* 리스트3\n" +
					"\n" +
					"파이썬 홈페이지는 [http://www.python.org](http://www.python.org) 입니다.", 0, LocalDate.now()));
		};
	}

}
