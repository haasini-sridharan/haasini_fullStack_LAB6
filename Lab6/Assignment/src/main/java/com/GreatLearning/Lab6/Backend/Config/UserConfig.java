package com.GreatLearning.Lab6.Backend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.GreatLearning.Lab6.Backend.Entity.User;

@Configuration
public class UserConfig {

    @Bean
    public User user() {
        return new User();
    }
}
