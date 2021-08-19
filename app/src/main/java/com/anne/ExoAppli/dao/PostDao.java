package com.anne.ExoAppli.dao;

import com.anne.ExoAppli.model.Post;
import com.anne.ExoAppli.model.CivilityEnum;
import java.util.ArrayList;
import java.util.List;

public final class PostDao {

    private static PostDao S_INSTANCE;

    private List<Post> data;

    private PostDao() {
        this.data = new ArrayList<>();
        data.add(new Post("Perte Lunettes de soleil", "on m'a volé mes lunettes au bec de Jazz", "pentes de la croix rousse", CivilityEnum.MRS, "Anne", "Saint-Georges", "anne.saintgeorges@gmail.com", "0661149437"));

    }
public static PostDao getInstance(){
        if (S_INSTANCE == null){
            S_INSTANCE = new PostDao();
        }
        return S_INSTANCE;
}
public boolean create (Post post) {
        return data.add(post);
}

public List<Post> findAll() {
return data;
    }

    public boolean remove(Post post){
        return data.remove(post);
    }
}
