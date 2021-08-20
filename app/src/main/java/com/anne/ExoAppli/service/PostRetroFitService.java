package com.anne.ExoAppli.service;

import com.anne.ExoAppli.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostRetroFitService {
    @GET("posts")
    Call<List<Post>> fetchAllPosts();

    @POST("posts")
    Call<Post> createPost(@Body Post post);
}
