package com.example.yury.bioapp.post.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yury.bioapp.R;
import com.example.yury.bioapp.model.Post;

public class PostDetailActivity extends AppCompatActivity {

    private static final String KEY_POST = "KEY_POST";

    public static Intent makePostDetailIntent(
            Context activity,
            Post post
    ) {
        Intent intent = new Intent(activity, PostDetailActivity.class);
        intent.putExtra(KEY_POST, post);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        Post post = getIntent().getParcelableExtra(KEY_POST);

        ImageView postImageView = findViewById(R.id.post_image);
        Toolbar postCategoryTitleView = findViewById(R.id.post_category_title);
        TextView postTitleView = findViewById(R.id.post_title);
        TextView postDateView = findViewById(R.id.post_date);
        TextView postTextView = findViewById(R.id.post_text);

        Glide.with(this).load(post.getImage()).into(postImageView);
        postCategoryTitleView.setTitle(post.getCategory().getTitle());
        postTitleView.setText(post.getTitle());
        postTextView.setText(post.getText());
        postDateView.setText(post.getUserFriendlyDate());
    }
}
