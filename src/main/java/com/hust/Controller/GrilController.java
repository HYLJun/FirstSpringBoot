package com.hust.Controller;

import com.hust.domain.Result;
import com.hust.exception.GirlException;
import com.hust.repository.GirlRepository;
import com.hust.domain.Girl;
import com.hust.service.GirlService;
import com.hust.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by HYLJ on 2018/6/1 0001.
 */
@RestController
public class GrilController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    private final static Logger logger = LoggerFactory.getLogger(GrilController.class);

    /**
     * 查询所有的girls
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("方法正在={}","获取所有girls中。。。。。");
        return  girlRepository.findAll();
    }

    @PostMapping(value = "/addGirl")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        return ResultUtil.success(girlRepository.save(girl));

    }
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> girlFindById(@PathVariable("id") Integer id){
        return girlRepository.findById(id);
    }

   @PutMapping(value = "girls/{id}")
   public Girl girlUpdateById(@PathVariable("id") Integer id,
                                        @RequestParam("cupSize") String cupSize,
                                        @RequestParam("age") Integer age){
       Girl girl = new Girl();
       girl.setId(id);
       girl.setAge(age);
       girl.setCupSize(cupSize);
       return girlRepository.save(girl);
   }

   @DeleteMapping(value = "girls/{id}")
    public void deleteGirlById(@PathVariable("id") Integer id){
       girlRepository.deleteById(id);
   }

    @GetMapping(value="/girls/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);

    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "girls/getAgeById/{id}")
    public void getAgeById(@PathVariable("id") Integer id) throws Exception {
        girlService.getAgeById(id);
    }



}
