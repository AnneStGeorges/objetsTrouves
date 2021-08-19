package com.anne.ExoAppli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import com.anne.ExoAppli.model.Post;

public class DetailsPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_post);
        TextView tvName = findViewById(R.id.activity_details_item_title);
        TextView tvDescription = findViewById(R.id.activity_details_item_description);
        TextView tvAdresse = findViewById(R.id.activity_details_item_adress);

        // Get bundle post
        Intent intent = getIntent();
        if (intent.hasExtra(ViewListActivity.KEY_BUNDLE_POST)) {
            Post post = intent.getParcelableExtra(ViewListActivity.KEY_BUNDLE_POST);
            tvName.setText(post.getName());
            tvDescription.setText(post.getDescription());
            tvAdresse.setText(post.getAddress());
        }
    }
}