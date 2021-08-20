package com.anne.ExoAppli;

import com.anne.ExoAppli.service.PostRetroFitService;
import com.anne.ExoAppli.service.PostService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitApi {
    private static final String BASE_URL = "http://10.0.2.2:3000/";
    private static PostRetroFitService postService;

    public static PostRetroFitService getInstance() {
        if (postService == null) {
            synchronized (PostRetroFitService.class) {
                createApiBuilder();
            }
        }
        return postService;
    }

    private static void createApiBuilder() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postService = retrofit.create(PostRetroFitService.class);
    }
}