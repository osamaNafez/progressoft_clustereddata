package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.validator;

import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.DealDetail;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.Violation;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.repository.DealDetailJpaRepository;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.repository.DealDetailRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class DuplicateValidatorTest {

    private DealDetailRepository dealDetailRepository;
    private Validator validator;

    @BeforeEach
    void setUp() {
        this.dealDetailRepository = Mockito.mock(DealDetailRepository.class);
        this.validator = new DuplicateValidator(dealDetailRepository);
    }

    @Test
    void validateIfExist() {
        DealDetail dealDetail = new DealDetail();

        Mockito.when(dealDetailRepository.existsByUniqueId(dealDetail.getUniqueId())).thenReturn(true);

        List<Violation> violations = validator.validate(dealDetail);

        Assertions.assertNotNull(violations);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(1,violations.size());
        Assertions.assertEquals(DuplicateValidator.VIOLATION_NAME,violations.get(0).getViolationName());
        Assertions.assertEquals(String.format(DuplicateValidator.VIOLATION_MESSAGE, dealDetail.getUniqueId()),violations.get(0).getViolationMessage());

    }

    @Test
    void validateIfNotExist() {
        DealDetail dealDetail = new DealDetail();

        Mockito.when(dealDetailRepository.existsByUniqueId(dealDetail.getUniqueId())).thenReturn(false);

        List<Violation> violations = validator.validate(dealDetail);

        Assertions.assertNotNull(violations);
        Assertions.assertTrue(violations.isEmpty());
    }
}