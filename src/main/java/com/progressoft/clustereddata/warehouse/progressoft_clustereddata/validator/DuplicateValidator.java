package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.validator;

import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.DealDetail;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.Violation;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.repository.DealDetailRepository;

import java.util.Collections;
import java.util.List;

public class DuplicateValidator implements Validator {
    public static final String VIOLATION_NAME = "uniqueness of deal detail";
    public static final String VIOLATION_MESSAGE = "deal detail with UniqueId {[%s]} already exist";
    private final DealDetailRepository repository;

    public DuplicateValidator(DealDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Violation> validate(DealDetail dealDetail) {

        if(repository.existsByUniqueId(dealDetail.getUniqueId())){
            return List.of(new Violation(VIOLATION_NAME, String.format(VIOLATION_MESSAGE, dealDetail.getUniqueId())));
        }
        return Collections.emptyList();
    }
}
