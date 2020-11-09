package main.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import main.repository.*;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class UserRepositoryTest {


    @Bean
    @Primary
    public UserRepository userRepo() {
        return mock(UserRepository.class);
    }

}