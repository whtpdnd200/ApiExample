package com.apiexample.apiexample.api.service;

import com.apiexample.apiexample.api.domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ApiService {

    private WebClient webClient = WebClient.builder()
                                    .baseUrl("https://apihub.kma.go.kr").build();

    public String get() {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .path("api/typ02/openApi/VilageFcstInfoService_2.0/getUltraSrtNcst")
                        .queryParam("authKey", "FscZkVe2TzWHGZFXto81-A")
                        .queryParam("numOfRows", "10")
                        .queryParam("pageNo", "1")
                        .queryParam("dataType", "JSON")
                        .queryParam("base_date", "20251125")
                        .queryParam("base_time", "0600")
                        .queryParam("nx", "55")
                        .queryParam("ny", "127")
                        .build()).retrieve()
                        .bodyToMono(String.class)
                        .block();

    }
}
