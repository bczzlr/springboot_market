package com.example.demo090.dao.repository;

import com.example.demo090.dao.entity.CommodityEntity;
import com.example.demo090.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    public UserEntity findByUsernameAndPassword(String username,String password);
    public UserEntity findByUsername(String username);

    public Optional<UserEntity> findById(Long id);

    @Query("select DISTINCT g from CommodityEntity g left join g.user where g.user.username = ?1")//正确
    public Set<CommodityEntity> findSet(String name);

}
