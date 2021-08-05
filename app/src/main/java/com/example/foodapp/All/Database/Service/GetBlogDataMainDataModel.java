package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBlogDataMainDataModel {
    @SerializedName("Title")
    String Title;

    @SerializedName("Body")
    String Body;

    @SerializedName("BlogImage")
    String BlogImage;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getBlogImage() {
        return BlogImage;
    }

    public void setBlogImage(String blogImage) {
        BlogImage = blogImage;
    }
}
