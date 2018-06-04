package com.hust.service;

import com.hust.enums.ResultEnum;
import com.hust.exception.GirlException;
import com.hust.handle.ExceptionHandle;
import com.hust.repository.GirlRepository;
import com.hust.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

/**
 * Created by HYLJ on 2018/6/2 0002.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(15);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(25);
        girlRepository.save(girlB);
    }

    public void getAgeById(Integer id) throws Exception{
        Girl girl =girlRepository.getOne(id);
        Integer age = girl.getAge();
        if (age < 10){
            throw  new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            throw  new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

    }

    /**
     * 通过id找一个girl
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.getOne(id);
    }
}
