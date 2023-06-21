package com.example.study_servlets.commons;

import java.util.UUID;

public class Commons {
    public String generatUuid() {

        return UUID.randomUUID().toString();
    }
}
