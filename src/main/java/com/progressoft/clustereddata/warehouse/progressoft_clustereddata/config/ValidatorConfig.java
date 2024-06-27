package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.config;

import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.repository.DealDetailRepository;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.validator.DuplicateValidator;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorConfig {

    @Bean
    public Validator dublicatValidator(DealDetailRepository dealDetailRepository){
        return new DuplicateValidator(dealDetailRepository);
    }
}
