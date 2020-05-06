package com.example.demo090.dao.repository;

import com.example.demo090.dao.entity.CommodityEntity;
import com.example.demo090.dao.entity.DealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DealRepository extends JpaRepository<DealEntity ,Long>, JpaSpecificationExecutor<CommodityEntity> {
    public DealEntity findByDealID(Long id);
    public DealEntity findByDealLocation(String location);
}
