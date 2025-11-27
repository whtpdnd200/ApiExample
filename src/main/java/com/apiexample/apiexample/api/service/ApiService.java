package com.apiexample.apiexample.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ApiService {

    private WebClient webClient = WebClient.builder()
                                    .baseUrl("https://e-childschoolinfo.moe.go.kr").build();
    private final String key = "a3387fbb90064f7d8dd219ab02a08978";

    public String get() {


        return  webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/notice/basicInfo2.do")
                        .queryParam("key", key)
                        .queryParam("sidoCode", "11")
                        .queryParam("sggCode", "11140")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
