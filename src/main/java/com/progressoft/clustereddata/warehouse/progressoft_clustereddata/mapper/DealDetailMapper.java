package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.mapper;

import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.controller.request.DealDetailRequest;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.entity.DealDetailEntity;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.DealDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DealDetailMapper {

    DealDetailEntity toEntity(DealDetail dealDetail);

    DealDetail toModel(DealDetailEntity dealDetailEntity);

    DealDetail toModel(DealDetailRequest dealDetailRequest);

}
