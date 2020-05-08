package com.example.demo090.dao.repository;

import com.example.demo090.control.param.UserReq;
import com.example.demo090.dao.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminRepository extends JpaRepository<AdminEntity,Long>, JpaSpecificationExecutor<AdminEntity>{

    public AdminEntity findByUsernameAndPassword(String username,String password);

}
