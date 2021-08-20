package com.anne.ExoAppli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.anne.ExoAppli.model.Post;

public class DetailsPostActivity extends AppCompatActivity {
private Post post;

    public DetailsPostActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_post);

        //set actionbar as visible
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        TextView tvName = findViewById(R.id.activity_details_item_title);
        TextView tvDescription = findViewById(R.id.activity_details_item_description);
        TextView tvAddress = findViewById(R.id.activity_details_item_address);
        ImageView tvImage = findViewById(R.id.image_annonce);


        // Get bundle post
        Intent intent = getIntent();
        if (intent.hasExtra(ViewListActivity.KEY_BUNDLE_POST)) {
            Post post = intent.getParcelableExtra(ViewListActivity.KEY_BUNDLE_POST);
            tvName.setText(post.getName());
            tvDescription.setText(post.getDescription());
            tvAddress.setText(post.getAddress());
            tvImage.setImageBitmap(post.getPictureBase64());
        }
    }

    //to display the share button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details_post, menu);
        return true;
    }

    //method to go back to previous page
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home : finish();
                break;
            case R.id.action_share: share(post);
            break;
        }
        return super.onOptionsItemSelected(item);
    }



    //share by SMS
    private void share(Post post) {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");


        StringBuilder sb = new StringBuilder();
        sb.append("<p>Salut ! J'ai trouvé une annonce importante sur Retrouvez-moi... :</p>");
        sb.append("<p>Nom : ").append(post.getName()).append("</p>");
        sb.append("<p>Description : ").append(post.getDescription()).append("</p>");
        sb.append("<p>Si vous trouvez, appelez le ").append(post.getPhoneNumber()).append("</p>");

        String content = Html.fromHtml(sb.toString()).toString();

        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, post.getName());
        intent.putExtra(android.content.Intent.EXTRA_TEXT, content);

        startActivity(Intent.createChooser(intent, getString(R.string.share_with)));
    }
}