package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.config;

import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.repository.DealDetailRepository;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.service.DealDetailService;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.service.DealDetailServiceImpl;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public DealDetailService dealDetailService(DealDetailRepository dealDetailRepository, Validator duplicateValidator) {
        return new DealDetailServiceImpl(dealDetailRepository, duplicateValidator);
    }
}
