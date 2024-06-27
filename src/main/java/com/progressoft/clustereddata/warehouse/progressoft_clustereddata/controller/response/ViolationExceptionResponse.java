package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ViolationExceptionResponse {
    private Map<String, String> violations;
}
