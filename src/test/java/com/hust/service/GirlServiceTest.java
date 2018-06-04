package com.hust.service;

import com.hust.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by HYLJ on 2018/6/4 0004.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void testFindOne() throws Exception {
        Girl girl =  girlService.findOne(1);

        Assert.assertEquals(new Integer(2),girl.getAge());

    }
}