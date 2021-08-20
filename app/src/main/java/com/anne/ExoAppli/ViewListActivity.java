package com.anne.ExoAppli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.anne.ExoAppli.adapter.RVPostAdapter;
import com.anne.ExoAppli.model.Post;
import com.anne.ExoAppli.service.PostRetroFitService;
import com.anne.ExoAppli.service.PostService;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewListActivity extends AppCompatActivity {

private RecyclerView recyclerView;

public static final String KEY_BUNDLE_POST = "KEY_BUNDLE_POST";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        //set actionbar as visible
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        //get recyclerview
        recyclerView = findViewById(R.id.rv_post_list);

        //configure adapter and layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        RVPostAdapter.OnItemClickListener clickListener = new RVPostAdapter.OnItemClickListener() {
            @Override
            public void onClick(Post postClicked) {
               Intent intent = new Intent(ViewListActivity.this, DetailsPostActivity.class);
               intent.putExtra(KEY_BUNDLE_POST, postClicked);
               startActivity(intent);

            }
        };
        //get data

        PostRetroFitService postService = RetrofitApi.getInstance();
        Call<List<Post>> call = postService.fetchAllPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                //create and use adapter (class)
                List<Post> postList = response.body();
                RVPostAdapter rvPostAdapter = new RVPostAdapter(postList, clickListener);
                recyclerView.setAdapter(rvPostAdapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Snackbar.make(getParent().getWindow().getDecorView(), "Une erreur est survenu", Snackbar.LENGTH_SHORT).show();
            }
        });

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