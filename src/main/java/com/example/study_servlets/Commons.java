package com.example.study_servlets;

import java.util.UUID; // 유니크한 ID를 생성한다는 의미

public class Commons {
    public String generateUUID() {
        return UUID.randomUUID().toString();
    }
}