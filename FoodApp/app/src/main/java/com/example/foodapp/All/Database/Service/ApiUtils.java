package com.example.foodapp.All.Database.Service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://mymeal.rapidlogistic.in/";

    public static Retrofit getAPIService() {

        HttpLoggingInterceptor h = new HttpLoggingInterceptor();
        h.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(h).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public static UserClient getUserServices()
    {
        UserClient userClient = getAPIService().create(UserClient.class);
        return userClient;
    }
}
