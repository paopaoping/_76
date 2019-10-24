package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/consumer")
public class StudentHandler {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        //必须在StudentHandler 加这个@LoadBalanced 才能识别provider这个别称
        return restTemplate.getForEntity("http://provider/student/findAll",Collection.class).getBody();
//        return restTemplate.getForEntity("http://localhost:8010/student/findAll",Collection.class).getBody();
    }
}
