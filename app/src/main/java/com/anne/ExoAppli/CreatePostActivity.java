package com.anne.ExoAppli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioGroup;

import com.anne.ExoAppli.model.CivilityEnum;
import com.anne.ExoAppli.model.Post;
import com.anne.ExoAppli.service.PostService;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class CreatePostActivity extends AppCompatActivity {
    private String title;
    private String description;
    private String address;
    private String name;
    private String firstname;
    private String email;
    private String phoneNumber;
    private CivilityEnum gender;
    private Button publishBtn;
    private PostService postService = PostService.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set back arrow as visible
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);




        setContentView(R.layout.activity_create_post);
        TextInputLayout titleLayout = findViewById(R.id.addTitle);
        TextInputLayout descriptionLayout = findViewById(R.id.description);
        TextInputLayout addressLayout = findViewById(R.id.address);
        TextInputLayout nameLayout = findViewById(R.id.name);
        TextInputLayout firstnameLayout = findViewById(R.id.firstName);
        TextInputLayout emailLayout = findViewById(R.id.email);
        TextInputLayout phoneNumberLayout = findViewById(R.id.phoneNumber);
        RadioGroup genderRadioLayout = findViewById(R.id.genderRadio);

        publishBtn = findViewById(R.id.publish);
        publishBtn.setOnClickListener(view -> {
           title = titleLayout.getEditText().getText().toString();
           description = descriptionLayout.getEditText().getText().toString();
           address = addressLayout.getEditText().getText().toString();
           name = nameLayout.getEditText().getText().toString();
           firstname = firstnameLayout.getEditText().getText().toString();
           email = emailLayout.getEditText().getText().toString();
           phoneNumber = phoneNumberLayout.getEditText().getText().toString();
           genderRadioLayout.setOnCheckedChangeListener(((radioGroup, checkedId) ->{
                switch(checkedId){
                    case R.id.radioWoman: gender = CivilityEnum.MRS;
                        break;
                    case R.id.radioMan: gender = CivilityEnum.MR;
                        break;
                }
            }));
            Post post = new Post(title, description, address, gender, name, firstname, email, phoneNumber);
            postService.createPost(post);

            //snackbar (success message)
            Snackbar snackbar = Snackbar.make(view, R.string.post_created_successfully, Snackbar.LENGTH_SHORT);
                snackbar.addCallback(new Snackbar.Callback(){
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event){
                        if (event ==Snackbar.Callback.DISMISS_EVENT_TIMEOUT){
                            finish();
                        }
                    }
                });
                snackbar.show();

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