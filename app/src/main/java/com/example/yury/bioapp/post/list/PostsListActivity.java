package com.example.yury.bioapp.post.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;

import com.example.yury.bioapp.R;
import com.example.yury.bioapp.data.PostsDataUtils;

public class PostsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_list);

        RecyclerView postsRecyclerView = findViewById(R.id.posts_list);
        PostRecyclerAdapter adapter = new PostRecyclerAdapter(this, PostsDataUtils.generatePosts());
        postsRecyclerView.setAdapter(adapter);

        int currentOrientation = getResources().getConfiguration().orientation;
        if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
            postsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            postsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }

        postsRecyclerView.addItemDecoration(new DividerItemDecoration(8, currentOrientation));
    }


}
