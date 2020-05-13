package com.example.demo090.service.impl;

import com.example.demo090.dao.entity.Evaluate;
import com.example.demo090.domain.EvalInformation;
import com.example.demo090.service.EvalService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EvalServiceImpl implements EvalService {

    @Override
    public Set<EvalInformation> reMold(Set<Evaluate> evaluates) {
        Set<EvalInformation> results = new HashSet<>();
        for (Evaluate evaluate : evaluates) {
            EvalInformation evalInformation = new EvalInformation();

            evalInformation.setC_name(evaluate.getDeal().getCommodityEntity().getComName());
            evalInformation.setC_price(evaluate.getDeal().getCommodityEntity().getComPrice());
            evalInformation.setD_location(evaluate.getDeal().getDealLocation());
            evalInformation.setD_time(evaluate.getDeal().getDealChangeTime());
            evalInformation.setE_comment(evaluate.getEvalComment());
            evalInformation.setE_starts(Integer.parseInt(evaluate.getEvalStars()));
            evalInformation.setU_name(evaluate.getDeal().getCommodityEntity().getUser().getUsername());

            results.add(evalInformation);

        }

        return results;
    }
}
