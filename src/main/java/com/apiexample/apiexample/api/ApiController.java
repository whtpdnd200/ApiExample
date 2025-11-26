package com.apiexample.apiexample.api;

import com.apiexample.apiexample.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {

    @Autowired
    private ApiService apiService;

    @ResponseBody
    @GetMapping("/api/hello")
    public String hello() {

        return "hello!!";
    }

    @ResponseBody
    @GetMapping("/api/weather")
    public String getWeather() {

        return apiService.get();
    }
}
