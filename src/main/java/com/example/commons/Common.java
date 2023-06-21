package com.example.commons;

import java.util.UUID;

public class Common {
    public String Commons() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
