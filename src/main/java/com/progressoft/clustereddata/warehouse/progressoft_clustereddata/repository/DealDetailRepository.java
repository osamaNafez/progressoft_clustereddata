package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.repository;


import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.DealDetail;

import java.util.Date;
import java.util.List;

public interface DealDetailRepository {

    DealDetail save(DealDetail dealDetail);

    DealDetail findByUuid(String uuid);

    List<DealDetail> findAll();

    boolean existsByUniqueId(String uniqueId);
}
