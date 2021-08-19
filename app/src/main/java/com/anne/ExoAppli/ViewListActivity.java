package com.anne.ExoAppli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.anne.ExoAppli.adapter.RVPostAdapter;
import com.anne.ExoAppli.model.Post;
import com.anne.ExoAppli.service.PostService;

import java.util.List;

public class ViewListActivity extends AppCompatActivity {

private PostService postService = PostService.getInstance();

private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        //set actionbar as visible
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //get data
        List<Post> postList = postService.getAllPosts();
        //get recyclerview
        recyclerView = findViewById(R.id.rv_post_list);
        //create and use adapter (class)
        RVPostAdapter rvPostAdapter = new RVPostAdapter(this, R.layout.post_list_item);
        recyclerView.setAdapter(rvPostAdapter);
        //configure adapter and layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }

    //method to go back to previous page
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home : finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}