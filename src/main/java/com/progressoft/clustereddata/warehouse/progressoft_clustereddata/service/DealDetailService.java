package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.service;

import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.DealDetail;

import java.util.List;

public interface DealDetailService {
    DealDetail create(DealDetail dealDetail);

    DealDetail getByUuid(String uuid);

    List<DealDetail> getAll();

}
