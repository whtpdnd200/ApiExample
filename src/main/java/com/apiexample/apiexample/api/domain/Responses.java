package com.apiexample.apiexample.api.domain;

import lombok.Data;

import java.util.List;

@Data
public class Responses {

    private String status;
    private String pageCnt;
    private String currentPage;
    private String sidoList;
    private String sggList;
    private String timing;
    private List<KinderInfo> kinderInfo;


}
