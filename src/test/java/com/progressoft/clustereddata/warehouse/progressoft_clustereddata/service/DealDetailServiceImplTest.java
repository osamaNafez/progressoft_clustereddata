package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.service;

import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.exception.ViolationException;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.DealDetail;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.Violation;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.repository.DealDetailRepository;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

class DealDetailServiceImplTest {

    private  DealDetailRepository dealDetailRepository;
    private  Validator dublicatValidator;
    private DealDetailService dealDetailService;

    @BeforeEach
    void setUp() {
        dealDetailRepository = Mockito.mock(DealDetailRepository.class);
        dublicatValidator = Mockito.mock(Validator.class);
        dealDetailService = new DealDetailServiceImpl(dealDetailRepository, dublicatValidator);
    }

    @Test
    void createIfNotHaveViolation() {
        DealDetail dealDetail = new DealDetail();

        Mockito.when(dublicatValidator.validate(dealDetail)).thenReturn(Collections.emptyList());
        Mockito.when(dealDetailRepository.save(dealDetail)).thenReturn(dealDetail);

        DealDetail result = dealDetailService.create(dealDetail);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(dealDetail, result);
    }

    @Test
    void createIfHaveViolation() {
        DealDetail dealDetail = new DealDetail();
        Violation violation = new Violation("violationName", "violationMessage");

        Mockito.when(dublicatValidator.validate(dealDetail)).thenReturn(List.of(violation));

        ViolationException violationException = Assertions.assertThrows(ViolationException.class, () -> dealDetailService.create(dealDetail));
        Assertions.assertNotNull(violationException);
        Assertions.assertNotNull(violationException.getViolations());
        Assertions.assertFalse(violationException.getViolations().isEmpty());
        Assertions.assertEquals(violation, violationException.getViolations().get(0));
    }

    @Test
    void getByUuid() {
        DealDetail dealDetail = new DealDetail();

        Mockito.when(dealDetailRepository.findByUuid(dealDetail.getUuid())).thenReturn(dealDetail);

        DealDetail result = dealDetailService.getByUuid(dealDetail.getUuid());
        Assertions.assertNotNull(result);
        Assertions.assertEquals(dealDetail, result);
    }

    @Test
    void getAll() {
        DealDetail dealDetail = new DealDetail();
        List<DealDetail> dealDetails = List.of(dealDetail);

        Mockito.when(dealDetailRepository.findAll()).thenReturn(dealDetails);

        List<DealDetail> results = dealDetailService.getAll();
        Assertions.assertNotNull(results);
        Assertions.assertFalse(results.isEmpty());
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(dealDetails, results);
    }
}