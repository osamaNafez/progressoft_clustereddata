package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.repository;


import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.entity.DealDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DealDetailJpaRepository extends JpaRepository<DealDetailEntity, Long> {

    Optional<DealDetailEntity> findByUuid(String uuid);

    Boolean existsByUniqueId(String uniqueId);
}
