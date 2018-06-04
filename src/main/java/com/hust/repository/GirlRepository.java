package com.hust.repository;

import com.hust.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HYLJ on 2018/6/1 0001.
 */
@Repository
public interface GirlRepository extends JpaRepository<Girl,Integer>{

    //通过年龄来查询
    public List<Girl> findByAge(Integer age);
}
