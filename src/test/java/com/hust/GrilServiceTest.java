package com.hust;

import com.hust.domain.Girl;
import com.hust.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by HYLJ on 2018/6/4 0004.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GrilServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
       Girl girl =  girlService.findOne(1);

        Assert.assertEquals(new Integer(2),girl.getAge());
    }

}

