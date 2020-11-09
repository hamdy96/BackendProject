package main.repo;

import main.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class OrderRepositoryTest {


    @Bean
    @Primary
    public OrderRepository orderRepo() {
        return mock(OrderRepository.class);
    }

}