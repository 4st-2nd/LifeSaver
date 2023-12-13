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
			postsRepository.save(new Posts("화학 물질 및 화학제품 제조업", "# 화학 안전 체크리스트\n" +
					" * [ ] 모든 작업자들에게 화학 안전에 대한 교육을 제공하였나요? 이는 화학적 위험에 대한 이해를 높이고, 위험한 상황을 피하거나 적절하게 대응하는 데 도움이 됩니다.\n"+
					" * [ ] 적절한 장비와 보호장비를 사용하고 있나요? 이는 화학적 위험, 화재, 폭발 등의 위험을 줄일 수 있습니다. \n"+
					" * [ ] 화학 설비는 정기적으로 점검하고 유지보수하고 있나요? 노후화된 장비나 손상된 장비 등은 심각한 위험을 초래할 수 있습니다.\n"+
					" * [ ] 화학 작업에는 여러 안전 규정이 있습니다. 이러한 규정을 항상 준수하고 업데이트를 확인하고 있나요?", "화학",0, LocalDate.now()));

			postsRepository.save(new Posts("의료용 물질 및 의약품 제조업", "# 안전 교육 * 의약품 제조업에서의 모든 작업자들에게는 안전 및 위험에 대한 교육을 제공해야 합니다. 이는 화학물질에 대한 이해를 높이고, 위험한 상황을 피하거나 적절하게 대응하는 데 도움이 됩니다."
					+ " * 적절한 장비 사용: 의약품 제조를 수행할 때는 항상 적절한 장비와 보호장비를 사용해야 합니다. 이는 화학적 위험, 화재, 폭발 등의 위험을 줄일 수 있습니다."
							+ " * 정기적인 점검 및 유지보수: 의약품 제조 설비는 정기적으로 점검하고 유지보수해야 합니다. 노후화된 장비나 손상된 장비 등은 심각한 위험을 초래할 수 있습니다."
							+ " * 규정 준수: 의약품 제조에는 여러 안전 규정이 있습니다. 이러한 규정을 항상 준수하고 업데이트를 확인해야 합니다.", "의료용 물질 및 의약품 제조업",0, LocalDate.now()));
			postsRepository.save(new Posts("전기 산업", "# 안전 교육\n * 모든 작업자들에게 전기 안전에 대한 교육을 제공해야 합니다. 이는 전기적 위험에 대한 이해를 높이고, 위험한 상황을 피하거나 적절하게 대응하는 데 도움이 됩니다.\n"
					+ " * 적절한 장비 사용: 전기 작업을 수행할 때는 항상 적절한 장비와 보호장비를 사용해야 합니다. 이는 전기 충격, 화재, 폭발 등의 위험을 줄일 수 있습니다.\n"
					+ " * 정기적인 점검 및 유지보수: 전기 설비는 정기적으로 점검하고 유지보수해야 합니다. 노후화된 장비나 손상된 전선 등은 심각한 위험을 초래할 수 있습니다.\n"
			 		+ " * 규정 준수: 전기 작업에는 여러 안전 규정이 있습니다. 이러한 규정을 항상 준수하고 업데이트를 확인해야 합니다.\n", "전기",0, LocalDate.now()));
		};
	}

}
