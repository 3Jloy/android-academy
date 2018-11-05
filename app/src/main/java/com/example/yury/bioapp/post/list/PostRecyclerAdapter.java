package com.example.yury.bioapp.post.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.yury.bioapp.model.Post;
import com.example.yury.bioapp.R;
import com.example.yury.bioapp.post.details.PostDetailActivity;

import java.util.List;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.ViewHolder> {

    @NonNull
    private final List<Post> posts;

    @NonNull
    private final LayoutInflater inflater;

    @NonNull
    private final Context context;

    @NonNull
    private final RequestManager imageLoader;

    PostRecyclerAdapter(@NonNull Context context, @NonNull List<Post> posts) {
        this.posts = posts;
        this.context = context;
        this.inflater = LayoutInflater.from(context);

        RequestOptions imageOption = new RequestOptions();
        this.imageLoader = Glide.with(context).applyDefaultRequestOptions(imageOption);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(posts.get(position));

        viewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                context.startActivity(PostDetailActivity.makePostDetailIntent(
                        context,
                        posts.get(position)
                ));
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView postTitle;
        private final TextView postCategory;
        private final ImageView postImage;
        private final TextView postPreviewText;
        private final TextView postDate;

        private ItemClickListener itemClickListener;

        ViewHolder(@NonNull View itemView) {
            super(itemView);


            this.postTitle = itemView.findViewById(R.id.post_title);
            this.postCategory = itemView.findViewById(R.id.post_category);
            this.postImage = itemView.findViewById(R.id.post_image);
            this.postPreviewText = itemView.findViewById(R.id.post_preview_text);
            this.postDate = itemView.findViewById(R.id.post_date);

            itemView.setOnClickListener(this);
        }

        void bind(Post post) {
            postTitle.setText(post.getTitle());
            postCategory.setText(post.getCategory().getTitle());
            postPreviewText.setText(post.getPreviewText());
            imageLoader.load(post.getImage())
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(postImage);


            postDate.setText(post.getUserFriendlyDate());
        }

        void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition());
        }
    }
}
