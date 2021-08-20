package com.anne.ExoAppli.service;

import com.anne.ExoAppli.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostRetroFitService {
    @GET("posts")
    Call<List<Post>> fetchAllPosts();
}
