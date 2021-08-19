package com.anne.ExoAppli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.anne.ExoAppli.model.Post;
import com.anne.ExoAppli.service.PostService;

public class MainActivity extends AppCompatActivity {

    private static int i = 0;
    private PostService postService = PostService.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("onCreate", "index="+i);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(Post p : postService.getAllPosts()){
            Log.d("list posts", p.toString());
        }

        Button createPostBtn = findViewById(R.id.btn_create_post);
        createPostBtn.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, CreatePostActivity.class);
            MainActivity.this.startActivity(i);
        });

        Button viewListBtn = findViewById(R.id.btn_view_list);
        viewListBtn.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, ViewListActivity.class);
            MainActivity.this.startActivity(i);
        });
        };

    @Override
    protected void onPause() {
        i++;
        Log.d("onPause", "index="+i);

        super.onPause();
    }

    @Override
    protected void onRestart() {
        i++;
        Log.d("onRestart", "index="+i);
        super.onRestart();
    }

    @Override
    protected void onResume() {
        i++;
        Log.d("onResume", "index="+i);
        Log.d("taille liste posts", String.valueOf(postService.getAllPosts().size()));
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        i++;
        Log.d("onDestroy", "OnDestroy"+i);
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        i++;
        Log.d("onStart", "index="+i);
        for(Post p : postService.getAllPosts()){
            Log.d("list posts", p.toString());
        }
        super.onStart();
    }

    @Override
    protected void onStop() {
        i++;
        Log.d("onStop", "index="+i);
        super.onStop();
    }
}