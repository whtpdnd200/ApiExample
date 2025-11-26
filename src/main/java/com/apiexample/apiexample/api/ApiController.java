package com.apiexample.apiexample.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {

    @ResponseBody
    @GetMapping("/api/hello")
    public String hello() {

        return "hello!!";
    }
}
