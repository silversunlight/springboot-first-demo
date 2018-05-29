package com.example.demo.service;

import com.example.demo.domain.Girl;
import com.example.demo.repository.GirlReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlReposity girlReposity;
    //事务注解
    @Transactional
    public void insertTwo(Integer age1,String name1,
                          Integer age2,String name2) {
        Girl girl1=new Girl();
        girl1.setName(name1);
        girl1.setAge(age1);
        girlReposity.save(girl1);

        Girl girl2=new Girl();
        girl2.setName(name2);
        girl2.setAge(age2);
        girlReposity.save(girl2);
    }
}
