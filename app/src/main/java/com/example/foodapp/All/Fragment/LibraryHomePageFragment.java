package com.example.foodapp.All.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodapp.All.Adapter.LibraryHomePageHeadingAdapter;
import com.example.foodapp.All.Adapter.LibraryMainPageAdapter;
import com.example.foodapp.All.Adapter.RecipeSearchAdapter;
import com.example.foodapp.All.Database.Service.ApiUtils;
import com.example.foodapp.All.Database.Service.GetBlogCategoryDataMode;
import com.example.foodapp.All.Database.Service.GetBlogCategoryMainModel;
import com.example.foodapp.All.Database.Service.GetBlogDataMainDataModel;
import com.example.foodapp.All.Database.Service.GetBlogDataMainModel;
import com.example.foodapp.All.Database.Service.RecipeSearchByNameModel;
import com.example.foodapp.All.Database.Service.RecipeSearchByNameSubModel;
import com.example.foodapp.All.Database.Service.UserClient;
import com.example.foodapp.All.Models.LibraryMainPageModel;
import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LibraryHomePageFragment extends Fragment {

    static RecyclerView recyclerView;
    public static RecyclerView rcv_heading;
    ImageView back;
    static ProgressBar bar;
    public static SharedPreferences sharedPreferences;
    public static String token;
    public static ProgressDialog progressDialog;
    public static Context context;
    static ArrayList<GetBlogCategoryDataMode> getBlogCategoryDataModes = new ArrayList<>();
    public static ArrayList<GetBlogDataMainDataModel> dataModels = new ArrayList<>();

    public static LibraryMainPageAdapter libraryMainPageAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library_home_page, container, false);

        recyclerView = view.findViewById(R.id.rcv_library_main_page);
        bar = view.findViewById(R.id.progress_bar_library_home);

        context = getContext();

        rcv_heading  = view.findViewById(R.id.recycler_view_library_heaeding);


        back = (ImageView)view.findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                HomeFragment myFragment = new HomeFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });


        if (getBlogCategoryDataModes.size()==0)
        {
            addHeadingList();
        }
        else
        {
            LibraryHomePageHeadingAdapter adapter = new LibraryHomePageHeadingAdapter(context,getBlogCategoryDataModes);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL);
            rcv_heading.setLayoutManager(staggeredGridLayoutManager);
            rcv_heading.setAdapter(adapter);
        }
        if (dataModels.size()!=0)
        {
            libraryMainPageAdapter = new LibraryMainPageAdapter(context,dataModels);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(libraryMainPageAdapter);
            recyclerView.setNestedScrollingEnabled(false);
        }


        return view;
    }

    private void addHeadingList() {

        showProgress();
        sharedPreferences = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        token = "Bearer "+sharedPreferences.getString("token","");

        UserClient userClient = ApiUtils.getAPIService().create(UserClient.class);

        Call<GetBlogCategoryMainModel> call = userClient.getBlogCategory(token);
        call.enqueue(new Callback<GetBlogCategoryMainModel>() {
            @Override
            public void onResponse(Call<GetBlogCategoryMainModel> call, Response<GetBlogCategoryMainModel> response) {

                Log.d("Check Message", String.valueOf(response.body()));
                //progressDialog.dismiss();


                if (response.body()!=null && !response.body().getData().isEmpty())
                {
                    getBlogCategoryDataModes = response.body().getData();

                    LibraryHomePageHeadingAdapter adapter = new LibraryHomePageHeadingAdapter(context,getBlogCategoryDataModes);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL);
                    rcv_heading.setLayoutManager(staggeredGridLayoutManager);
                    rcv_heading.setAdapter(adapter);

                    if (dataModels.size()==0)
                    {

                        getLibraryData(getBlogCategoryDataModes.get(0).getBlogCategoryId(),token);
                    }
                    progressDialog.dismiss();
                }
                else {
                    if (progressDialog.isShowing())
                    {
                        progressDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<GetBlogCategoryMainModel> call, Throwable t) {
                Toast.makeText(context,"Something is wrong",Toast.LENGTH_LONG).show();
            }
        });

    }

    public static void getLibraryData(int id, String token)
    {
        bar.setVisibility(View.VISIBLE);

        UserClient userClient = ApiUtils.getAPIService().create(UserClient.class);

        Call<GetBlogDataMainModel> call = userClient.getBlogbyCategoryId(id,token);
        call.enqueue(new Callback<GetBlogDataMainModel>() {
            @Override
            public void onResponse(Call<GetBlogDataMainModel> call, Response<GetBlogDataMainModel> response) {

                showProgress();
                Log.d("Check Message", String.valueOf(response.body()));


                if (response.body()!=null && !response.body().getData().isEmpty())
                {
                    dataModels = response.body().getData();
                    Log.d("Size of data", String.valueOf(dataModels.size()));

                    libraryMainPageAdapter = new LibraryMainPageAdapter(context,dataModels);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(libraryMainPageAdapter);
                    recyclerView.setNestedScrollingEnabled(false);

                    bar.setVisibility(View.GONE);

                }
                else {
                    if (progressDialog.isShowing())
                    {
                        progressDialog.dismiss();
                    }
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<GetBlogDataMainModel> call, Throwable t) {
                Toast.makeText(context,"Something is wrong",Toast.LENGTH_LONG).show();
            }
        });
    }

    private static void showProgress() {

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Food App");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please wait");
        progressDialog.show();

    }

}