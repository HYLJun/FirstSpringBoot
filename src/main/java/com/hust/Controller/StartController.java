package com.hust.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HYLJ on 2018/5/31 0031.
 */
@RestController
@RequestMapping(value = "/hello")
public class StartController {

   // @Autowired
   // private GrilProperties grilProperties;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String start()
    {
        return "aaaaa";//grilProperties.getCupSize();
    }
}
