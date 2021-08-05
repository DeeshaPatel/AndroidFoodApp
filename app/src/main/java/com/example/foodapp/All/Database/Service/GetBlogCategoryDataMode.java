package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBlogCategoryDataMode {

    @SerializedName("BlogCategoryId")
    int BlogCategoryId;

    @SerializedName("BlogCategoryName")
    String BlogCategoryName;

    public int getBlogCategoryId() {
        return BlogCategoryId;
    }

    public void setBlogCategoryId(int blogCategoryId) {
        BlogCategoryId = blogCategoryId;
    }

    public String getBlogCategoryName() {
        return BlogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        BlogCategoryName = blogCategoryName;
    }
}


