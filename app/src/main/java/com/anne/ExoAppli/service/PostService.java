package com.anne.ExoAppli.service;

import com.anne.ExoAppli.dao.PostDao;
import com.anne.ExoAppli.model.Post;

import java.util.List;

public final class PostService {

    private static PostService S_INSTANCE;

    private PostService(){

    }
    public static PostService getInstance(){
        if (S_INSTANCE==null){
            S_INSTANCE = new PostService();
        }
        return S_INSTANCE;
    }

    public boolean createPost(Post post){
        return PostDao.getInstance().create(post);
    }

    public List<Post> getAllPosts(){
        return PostDao.getInstance().findAll();
    }
}
