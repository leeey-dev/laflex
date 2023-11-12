package project.camus.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
    "project.camus.springcloud.gateway"
})
public class SpringCloudGatewayApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringCloudGatewayApplication.class, args);
    }

    @Bean
    public HttpExchangeRepository httpExchangeRepository() {

        return new InMemoryHttpExchangeRepository();
    }
}
