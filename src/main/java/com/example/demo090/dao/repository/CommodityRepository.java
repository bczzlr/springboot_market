package com.example.demo090.dao.repository;

import com.example.demo090.dao.entity.CommodityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommodityRepository extends JpaRepository<CommodityEntity,Long> , JpaSpecificationExecutor<CommodityEntity> {
    public CommodityEntity findByComID(Long id);
    public List<CommodityEntity> findByComStatus(String status);



    @Modifying
    @Query("update CommodityEntity u set u.comStatus = ?1 where u.comID = ?2")
    int changeStatus(String status, Long id);

}
