package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BindExceptionResponse {
    private String filedName;
    private String message;
}