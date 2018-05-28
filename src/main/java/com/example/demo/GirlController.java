package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    @Autowired
    private GirlReposity girlReposity;

    @Autowired
    private GirlService girlService;

    //查询所有的
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlReposity.findAll();
    }

    //新增一个
    @PostMapping(value = "/girls")
    public Girl addGirl(@RequestParam("name") String name,
                        @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setName(name);
        girl.setAge(age);
        return girlReposity.save(girl);
    }

    //根据id查询一个
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> findOne(@PathVariable("id") Integer id) {
        return girlReposity.findById(id);
    }

    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setAge(age);
        return girlReposity.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlReposity.deleteById(id);
    }

    //通过年龄查询
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlReposity.findByAge(age);
    }

    @PostMapping(value = "/girls/insertTwo")
    public void insertTwoGirl(@RequestParam("name1") String name1,
                              @RequestParam("age1") Integer age1,
                              @RequestParam("name2") String name2,
                              @RequestParam("age2") Integer age2) {
        girlService.insertTwo(age1,name1,age2,name2);
    }
}
