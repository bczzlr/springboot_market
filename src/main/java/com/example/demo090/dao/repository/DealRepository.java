package com.example.demo090.dao.repository;

import com.example.demo090.dao.entity.CommodityEntity;
import com.example.demo090.dao.entity.DealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Email;
import java.util.List;

public interface DealRepository extends JpaRepository<DealEntity ,Long>, JpaSpecificationExecutor<DealEntity> {
    public DealEntity findByDealID(Long id);
    public DealEntity findByDealLocation(String location);

    @Query(nativeQuery =true,value = "select * FROM deal where out_user_id = (:id)")
    public List<DealEntity> findoutid(@Param("id") Long id);
}
