package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.validator;

import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.DealDetail;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.Violation;

import java.util.List;

public interface Validator {

    List<Violation> validate(DealDetail dealDetail);
}
