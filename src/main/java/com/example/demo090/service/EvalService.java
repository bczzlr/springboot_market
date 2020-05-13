package com.example.demo090.service;

import com.example.demo090.dao.entity.Evaluate;
import com.example.demo090.domain.EvalInformation;

import java.util.Set;

public interface EvalService {
    public Set<EvalInformation> reMold(Set<Evaluate> evaluates);
}
