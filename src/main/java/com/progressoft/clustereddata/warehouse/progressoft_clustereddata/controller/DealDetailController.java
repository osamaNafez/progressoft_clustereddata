package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.controller;


import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.controller.request.DealDetailRequest;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.mapper.DealDetailMapper;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.DealDetail;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.service.DealDetailService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/deal")
public class DealDetailController {


    private final DealDetailMapper dealDetailMapper;
    private final DealDetailService dealDetailService;

    public DealDetailController(DealDetailMapper dealDetailMapper, DealDetailService dealDetailService) {
        this.dealDetailMapper = dealDetailMapper;
        this.dealDetailService = dealDetailService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DealDetail> createDealDetail(@Valid @RequestBody DealDetailRequest request) {
        DealDetail dealDetail = dealDetailService.create(dealDetailMapper.toModel(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dealDetail);
    }

    @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DealDetail> getByUuid(@PathVariable String uuid) {
        DealDetail dealDetail = dealDetailService.getByUuid(uuid);
        return ResponseEntity.status(HttpStatus.OK)
                .body(dealDetail);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DealDetail>> getAll() {
        List<DealDetail> dealDetails = dealDetailService.getAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(dealDetails);
    }
}
