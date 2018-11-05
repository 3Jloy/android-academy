package com.example.yury.bioapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post implements Parcelable {
    private final String title;
    private final String image;
    private final Category category;
    private long date;
    private final String previewText;
    private final String text;


    public Post(
            String title,
            String image,
            Category category,
            Date date,
            String previewText,
            String text
    ) {
        this.title = title;
        this.image = image;
        this.category = category;
        this.date = date.getTime();
        this.previewText = previewText;
        this.text = text;
    }

    protected Post(Parcel in) {
        title = in.readString();
        image = in.readString();
        category = in.readParcelable(Category.class.getClassLoader());
        date = in.readLong();
        previewText = in.readString();
        text = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(image);
        dest.writeParcelable(category, flags);
        dest.writeLong(date);
        dest.writeString(previewText);
        dest.writeString(text);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public long getDate() {
        return date;
    }

    public String getUserFriendlyDate() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("d MMMM yyyy");
        return dateFormatter.format(new Date(this.date));
    }

    public String getPreviewText() {
        return previewText;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }
}
