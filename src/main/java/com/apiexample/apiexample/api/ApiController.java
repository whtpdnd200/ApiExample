package com.apiexample.apiexample.api;

import com.apiexample.apiexample.api.domain.Responses;
import com.apiexample.apiexample.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
    public String view(Model model
                        , @RequestParam(name = "sgg", required = false) String sgg) {

        System.out.println(sgg);
        List<String> lst = new ArrayList<>();
        lst.add("서울");
        lst.add("전라북도");
        lst.add("전라남도");
        lst.add("경상북도");
        lst.add("경상남도");

        model.addAttribute("cityList", lst);

        return "/api/apiMain";
    }

    @GetMapping("/sgg")
    public String sgg() {

        return "/api/test";
    }

    @ResponseBody
    @GetMapping("/sgg-list")
    public List<String> sggList() {

        List<String> sggList = new ArrayList<>();
        sggList.add("강남구");
        sggList.add("강동구");
        sggList.add("강서구");
        sggList.add("강북구");

        return sggList;
    }

    @ResponseBody
    @GetMapping("/house")
    public Responses getWeather() {
        Responses responses = null;
        try {
            responses = apiService.get();
        } catch (Exception e) {
            return null;
        }

        return responses;
    }
}
