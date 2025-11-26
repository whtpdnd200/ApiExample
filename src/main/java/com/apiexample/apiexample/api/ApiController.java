package com.apiexample.apiexample.api;

import com.apiexample.apiexample.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/api")
@Controller
public class ApiController {

    @Autowired
    private ApiService apiService;

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {

        return "hello!!";
    }

    @GetMapping("/main")
    public String view() {

        return "/api/apiMain";
    }

    @ResponseBody
    @GetMapping("/house")
    public String getWeather() {

        return apiService.get();
    }
}
