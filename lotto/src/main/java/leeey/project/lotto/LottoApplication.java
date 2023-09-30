package leeey.project.lotto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "leeey.project.*")
public class LottoApplication {

  public static void main(String[] args) {

    SpringApplication.run(LottoApplication.class, args);
  }
}
