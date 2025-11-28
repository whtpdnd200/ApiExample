package com.apiexample.apiexample.api.service;

import com.apiexample.apiexample.api.domain.KinderInfo;
import com.apiexample.apiexample.api.domain.Responses;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class ApiService {

    private WebClient webClient = WebClient.builder()
                                    .baseUrl("https://e-childschoolinfo.moe.go.kr").build();

    private Map<String, Object> kinderMap;

    private final String key = "a3387fbb90064f7d8dd219ab02a08978";

    public void setKinderMap() throws JsonProcessingException {

        List<KinderInfo> res = get().getKinderInfo();

        for(KinderInfo kinder : res) {
            kinderMap.put("key", kinder.getKey());
            kinderMap.put("kinderInfo", kinder);
        }
    }

    public Map<String, Object> getKinderMap() {
        return kinderMap;
    }

    public Responses get() throws JsonProcessingException {

          String res = webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path("/api/notice/basicInfo2.do")
                                .queryParam("key", key)
                                .queryParam("sidoCode", "11")
                                .queryParam("sggCode", "11140")
                                .build())
                        .header("Content-Type","application/json")
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();

        ObjectMapper mapper = new ObjectMapper();
        Responses responses = mapper.readValue(res, Responses.class);
        return responses;
    }
}
