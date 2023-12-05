package kr.ac.wku.inntavern.LifeSaver;

import kr.ac.wku.inntavern.LifeSaver.entity.posts.Posts;
import kr.ac.wku.inntavern.LifeSaver.repository.posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
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
			postsRepository.save(new Posts("어그로", "ㅈㄱㄴ", 0,LocalDateTime.now()));
			postsRepository.save(new Posts("진짜 어그로", "ㅈㄱㄴ", 0,LocalDateTime.now()));
		};
	}

}
