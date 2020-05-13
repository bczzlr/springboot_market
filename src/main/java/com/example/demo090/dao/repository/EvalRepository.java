package com.example.demo090.dao.repository;

import com.example.demo090.dao.entity.Evaluate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EvalRepository extends JpaRepository<Evaluate,Long>, JpaSpecificationExecutor<Evaluate> {
}
