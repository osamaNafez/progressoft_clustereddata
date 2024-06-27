package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.exception;

import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.Violation;
import lombok.Data;

import java.util.List;

@Data
public class ViolationException extends RuntimeException{

    private final List<Violation> violations;

    public ViolationException(List<Violation> violations) {
        this.violations = violations;
    }
}
