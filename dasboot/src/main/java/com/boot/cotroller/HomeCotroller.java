package com.boot.cotroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCotroller {

    @RequestMapping("/")
    public String home(){
        return "Das Boot, reporting for duty";
    }
}
