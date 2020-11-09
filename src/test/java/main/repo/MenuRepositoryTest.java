package main.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import main.repository.*;
import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class MenuRepositoryTest {


    @Bean
    @Primary
    public MenuRepository MenuRepo() {
        return mock(MenuRepository.class);
    }

}