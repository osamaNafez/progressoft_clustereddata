package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.controller.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DealDetailRequest {

    @NotNull(message = "unique Id can't be null")
    @NotBlank(message = "unique Id can't be empty")
    private String uniqueId;

    @NotNull(message = "from currency code can't be null")
    @NotBlank(message = "from currency code can't be empty")
    private String fromCurrencyCode;

    @NotNull(message = "to currency code can't be null")
    @NotBlank(message = "to currency code can't be empty")
    private String toCurrencyCode;

    @NotNull(message = "amount can't be null")
    private BigDecimal amount;

    @NotNull(message = "timestamp can't be null")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date timestamp;
}
