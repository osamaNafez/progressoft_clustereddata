package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.repository;

import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.entity.DealDetailEntity;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.exception.DealDetailNotFoundException;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.mapper.DealDetailMapper;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.DealDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

class DealDetailRepositoryImplTest {

    private DealDetailJpaRepository jpaRepository;
    private DealDetailMapper mapper;
    private DealDetailRepository dealDetailRepository;

    @BeforeEach
    void setUp() {
        jpaRepository = Mockito.mock(DealDetailJpaRepository.class);
        mapper = Mockito.mock(DealDetailMapper.class);
        dealDetailRepository = new DealDetailRepositoryImpl(jpaRepository, mapper);
    }

    @Test
    void save() {
        DealDetail dealDetail = new DealDetail();
        dealDetail.setUuid("uuid");
        dealDetail.setToCurrencyCode("dd");

        DealDetailEntity dealDetailEntity = new DealDetailEntity();
        dealDetailEntity.setId(1L);
        dealDetailEntity.setUuid("uuid");
        dealDetailEntity.setToCurrencyCode("dd");

        Mockito.when(mapper.toEntity(dealDetail)).thenReturn(dealDetailEntity);
        Mockito.when(mapper.toModel(dealDetailEntity)).thenReturn(dealDetail);
        Mockito.when(jpaRepository.save(dealDetailEntity)).thenReturn(dealDetailEntity);

        DealDetail result = dealDetailRepository.save(dealDetail);
        Assertions.assertEquals(dealDetail, result);
    }

    @Test
    void findByUuid() {
        String uuid = "Osama";
        DealDetailEntity dealDetailEntity = new DealDetailEntity();
        DealDetail dealDetail = new DealDetail();
        Mockito.when(jpaRepository.findByUuid(uuid)).thenReturn(Optional.of(dealDetailEntity));
        Mockito.when(mapper.toModel(dealDetailEntity)).thenReturn(dealDetail);

        DealDetail result = dealDetailRepository.findByUuid(uuid);
        Assertions.assertEquals(dealDetail, result);
    }

    @Test
    void findByUuidWithUuidNotFound() {
        String uuid = "Osama";

        Mockito.when(jpaRepository.findByUuid(uuid)).thenReturn(Optional.empty());

        Assertions.assertThrows(DealDetailNotFoundException.class, () -> dealDetailRepository.findByUuid(uuid));
    }

    @Test
    void findAll() {
        DealDetailEntity dealDetailEntity = new DealDetailEntity();
        List<DealDetailEntity> dealDetailEntities = List.of(dealDetailEntity);

        DealDetail dealDetail = new DealDetail();
        List<DealDetail> dealDetails = List.of(dealDetail);

        Mockito.when(jpaRepository.findAll()).thenReturn(dealDetailEntities);
        Mockito.when(mapper.toModel(dealDetailEntity)).thenReturn(dealDetail);

        List<DealDetail> results = dealDetailRepository.findAll();
        Assertions.assertEquals(dealDetails, results);
    }

    @Test
    public void testIfExist(){
        DealDetailEntity dealDetailEntity = new DealDetailEntity();
        DealDetail dealDetail = new DealDetail();
        Mockito.when(jpaRepository.existsByUniqueId(dealDetail.getUniqueId())).thenReturn(true);

        Mockito.when(mapper.toModel(dealDetailEntity)).thenReturn(dealDetail);


        boolean result = dealDetailRepository.existsByUniqueId(dealDetail.getUniqueId());
        Assertions.assertTrue(result);
    }

    @Test
    public void testIfNotExist(){
        DealDetail dealDetail = new DealDetail();
        Mockito.when(jpaRepository.existsByUniqueId(dealDetail.getUniqueId()))
                .thenReturn(false);

        boolean result = dealDetailRepository.existsByUniqueId(dealDetail.getUniqueId());
        Assertions.assertFalse(result);
    }
}