package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class MainController {

    @ResponseBody
    @RequestMapping("/")
public Name home(){
        System.out.println("--------------Start--------------");
        log.trace("This is TRACE");
        log.debug("this is debug");
        log.info("this is info");
        log.warn("this is warn");
        log.error("this is error");

        return Name.builder()
                .name("nmson")
                .email("sonnguyenece@gmail.com")
                .build();

    }
}
