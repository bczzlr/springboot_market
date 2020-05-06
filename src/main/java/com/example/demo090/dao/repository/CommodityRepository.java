package com.example.demo090.dao.repository;

import com.example.demo090.dao.entity.CommodityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CommodityRepository extends JpaRepository<CommodityEntity,Long> , JpaSpecificationExecutor<CommodityEntity> {
    public CommodityEntity findByComID(Long id);

}
