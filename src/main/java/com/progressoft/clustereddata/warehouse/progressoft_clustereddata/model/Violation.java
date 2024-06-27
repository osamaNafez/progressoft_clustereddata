package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Violation {
    private String violationName;
    private String violationMessage;
}
