package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.service;

import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.exception.ViolationException;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.mapper.DealDetailMapper;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.DealDetail;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.Violation;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.repository.DealDetailRepository;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.validator.Validator;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DealDetailServiceImpl implements DealDetailService {

    private final DealDetailRepository dealDetailRepository;
    private final Validator dublicatValidator;

    public DealDetailServiceImpl(DealDetailRepository dealDetailRepository,
                                 Validator dublicatValidator) {
        this.dealDetailRepository = dealDetailRepository;
        this.dublicatValidator = dublicatValidator;
    }

    @Override
    public DealDetail create(DealDetail dealDetail) {
        try {
            validateDealDetail(dealDetail);
            DealDetail savedDealDetail = dealDetailRepository.save(dealDetail);
            log.info("DealDetail saved successfully: {}", savedDealDetail);
            return savedDealDetail;
        } catch (Exception e) {
            log.error("Error occurred while adding DealDetail", e);
            throw e;
        }
    }

    private void validateDealDetail(DealDetail dealDetail) {
        List<Violation> violations = dublicatValidator.validate(dealDetail);
        if(!violations.isEmpty()){
            throw new ViolationException(violations);
        }
    }

    @Override
    public DealDetail getByUuid(String uuid) {
        try {
            DealDetail dealDetail = dealDetailRepository.findByUuid(uuid);

            if (dealDetail != null) {
                log.info("Retrieved DealDetail by UUID: {}", dealDetail);
            } else {
                log.info("No DealDetail found for UUID: {}", uuid);
            }

            return dealDetail;
        } catch (Exception e) {
            log.error("Error occurred while retrieving DealDetail by UUID: {}", uuid, e);
            throw e;
        }
    }

    @Override
    public List<DealDetail> getAll() {
        try {
            List<DealDetail> dealDetails = dealDetailRepository.findAll();

            if (!dealDetails.isEmpty()) {
                log.info("Retrieved all DealDetails. Count: {}", dealDetails.size());
            } else {
                log.info("No DealDetails found.");
            }

            return dealDetails;
        } catch (Exception e) {
            log.error("Error occurred while retrieving all DealDetails", e);
            throw e;
        }
    }
}
