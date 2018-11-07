package com.example.yury.bioapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {
    private final int id;

    private final String title;

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

    protected Category(Parcel in) {
        id = in.readInt();
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
