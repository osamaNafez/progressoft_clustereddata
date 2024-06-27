package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "DEAL_DETAIL")
public class DealDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UUID")
    private String uuid;
    
    @Column(name = "UNIQUE_ID")
    private String uniqueId;

    @Column(name = "FROM_CURRENCY")
    private String fromCurrencyCode;

    @Column(name = "TO_CURRENCY")
    private String toCurrencyCode;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "TIMESTAMP")
    private Date timestamp;
    
    @Column(name = "CREATE_AT")
    private Date createAt;

    @PrePersist
    public void prePersist(){
        this.uuid = UUID.randomUUID().toString();
        this.createAt = new Date();
    }
}