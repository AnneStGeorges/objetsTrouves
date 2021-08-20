package com.anne.ExoAppli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioGroup;

import com.anne.ExoAppli.model.CivilityEnum;
import com.anne.ExoAppli.model.Post;
import com.anne.ExoAppli.service.PostService;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;



public class CreatePostActivity extends AppCompatActivity {
    private String title;
    private String description;
    private String address;
    private String name;
    private String firstname;
    private String email;
    private String phoneNumber;
    private CivilityEnum gender;
    private Button publishBtn ;
    private PostService postService;
    private TextInputLayout titleLayout ;
    private TextInputLayout descriptionLayout ;
    private  TextInputLayout addressLayout ;
    private TextInputLayout nameLayout ;
    private TextInputLayout firstnameLayout ;
    private  TextInputLayout emailLayout ;
    private  TextInputLayout phoneNumberLayout;
    private  RadioGroup genderRadioLayout;
    private Button addPicture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set back arrow as visible
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_create_post);
       postService = PostService.getInstance();
        titleLayout = findViewById(R.id.addTitle);
       descriptionLayout = findViewById(R.id.description);
           addressLayout = findViewById(R.id.address);
      nameLayout = findViewById(R.id.name);
     firstnameLayout = findViewById(R.id.firstName);
         emailLayout = findViewById(R.id.email);
          phoneNumberLayout = findViewById(R.id.phoneNumber);
       genderRadioLayout = findViewById(R.id.genderRadio);
         addPicture = findViewById(R.id.addPicture);
            addPicture.setOnClickListener(this::onAddPostClicked);
        addPicture = findViewById(R.id.addPicture);
        addPicture.setOnClickListener(this::onPickPictureFromGallery);

    }

    private void onAddPostClicked(View view){
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

        };

        //method to go back to previous page
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home : finish();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_CANCELED) {

            switch (requestCode) {
                case REQUEST_CODE_PICK_PICTURE:
                    if (resultCode == RESULT_OK && data != null) {
                        Uri selectedPicture = data.getData();
                        imageViewPicture.setImageURI(selectedPicture);
                    }
                    break;
            }

        }
    }

    private void onPickPictureFromGallery(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE_PICK_PICTURE);
    }
}