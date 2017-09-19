package com.thunderivenstudios.stackoverflowuser.config;

/**
 * Created by Vincent Ngo on 9/17/2017.
 * ©Vincent Ngo. All rights reserved.
 */

public class Config {
    private Config() {}

    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";
    public static final String API_SITE = "stackoverflow";

    public static int CACHE_SIZE = 10 * 1024 * 1024; // 10 MB
}
