package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DealDetail {

    private String uuid;
    private String uniqueId;
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private BigDecimal amount;
    private Date timestamp;
}
