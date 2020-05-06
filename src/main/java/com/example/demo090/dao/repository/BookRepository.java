package com.example.demo090.dao.repository;

import com.example.demo090.dao.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    public List<BookEntity> findByNameLike(String keyword);

    public List<BookEntity> findByPriceBetween(Double lowprice,Double highprice);
}
