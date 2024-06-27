package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.config;

import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.mapper.DealDetailMapper;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.repository.DealDetailJpaRepository;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.repository.DealDetailRepository;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.repository.DealDetailRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public DealDetailRepository dealDetailRepository(DealDetailJpaRepository jpaRepository, DealDetailMapper dealDetailMapper) {
        return new DealDetailRepositoryImpl(jpaRepository, dealDetailMapper);
    }
}
