package com.hust.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by HYLJ on 2018/6/4 0004.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GrilControllerTest {

    @Autowired
    private MockMvc mvc;
    @Test
    public void testGirlList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girls")).
                andExpect(MockMvcResultMatchers.status().isOk());
    //    .andExpect(MockMvcResultMatchers.content().string("ABC"));

    }
}