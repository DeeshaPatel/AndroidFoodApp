package com.example.foodapp.All.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.foodapp.All.Adapter.CustomCalendar_WithourDisplay_Two;
import com.example.foodapp.All.Adapter.MealPlanMainAdapter;
import com.example.foodapp.All.Adapter.RecipeAdapter;
import com.example.foodapp.All.Adapter.RecipeCategoryAdapter;
import com.example.foodapp.All.Database.Service.ApiUtils;
import com.example.foodapp.All.Database.Service.Data;
import com.example.foodapp.All.Database.Service.MealPlanMealUpsertDto;
import com.example.foodapp.All.Database.Service.MealPlanModel;
import com.example.foodapp.All.Database.Service.RecipeCategoryDataModel;
import com.example.foodapp.All.Database.Service.RecipeCategorySubDataModel;
import com.example.foodapp.All.Database.Service.RecipeDataModel;
import com.example.foodapp.All.Database.Service.RecipeSubDataModel;
import com.example.foodapp.All.Database.Service.UserClient;
import com.example.foodapp.All.Models.RecipeModel;
import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecipeFragment extends Fragment {

    static RecyclerView recyclerView;
    RecyclerView rv_cateogries;
    LinearLayout l1,l2,l3,l4,l5,l6;
    public static ProgressDialog progressDialog;
    public static int pageno=1;
    public static String token="";
    static SharedPreferences sharedPreferences;
    public static Context context;
    public static String searchName="Asian",Id="";
    NestedScrollView nestedScrollView;
    static ProgressBar progress_bar_load_new_item;
    public static ArrayList<RecipeSubDataModel> dataModels=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.rcv_recipe);
        rv_cateogries = view.findViewById(R.id.recycler_view_categories);
        nestedScrollView = view.findViewById(R.id.nested_scroll_view_recipe);
        progress_bar_load_new_item = view.findViewById(R.id.progress_bar_load_new_item);
        
        context = getContext();

        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())
                {
                    pageno++;
                    Log.d("GGGGG","Yes");
                    progress_bar_load_new_item.setVisibility(View.VISIBLE);
                    getRecipeData(searchName,Id);
                }
            }
        });

        loadCategories();


        return view;
    }

    private void loadCategories() {

        //showProgress();

        sharedPreferences = getActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        token = "Bearer "+sharedPreferences.getString("token","");

        UserClient userClient = ApiUtils.getAPIService().create(UserClient.class);

        Call<RecipeCategoryDataModel> call = userClient.getRecipeCategories(token);
        Log.d("WWWWWWWWW",token);
        call.enqueue(new Callback<RecipeCategoryDataModel>() {
            @Override
            public void onResponse(Call<RecipeCategoryDataModel> call, Response<RecipeCategoryDataModel> response) {

                Log.d("QQQQQQQQQQ", String.valueOf(response.body()));
                //progressDialog.dismiss();

                if (response.body()!=null)
                {
                    ArrayList<RecipeCategorySubDataModel> recipeDataModels;
                    List<RecipeCategorySubDataModel> data = response.body().getData();
                    recipeDataModels = new ArrayList<>(data);
                    Log.d("Check karo ben ba", String.valueOf(data.size()));
                    RecipeCategoryAdapter recipeAdapter = new RecipeCategoryAdapter(getContext(),recipeDataModels);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
                    rv_cateogries.setLayoutManager(staggeredGridLayoutManager);
                    rv_cateogries.setAdapter(recipeAdapter);
                    getRecipeData(searchName,"73505ebb-bd2f-4cdc-bb2d-8bd52a2db7d7");
                }
                else {
                    Toast.makeText(context,"CHECK",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RecipeCategoryDataModel> call, Throwable t) {
                Toast.makeText(getContext(),"Something is wrong",Toast.LENGTH_LONG).show();
            }
        });

    }


    public static void getRecipeData(final String recipe,final String id)
    {
        sharedPreferences = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        token = "Bearer "+sharedPreferences.getString("token","");
        if (progress_bar_load_new_item.getVisibility()==View.GONE)
        {
            showProgress();
        }
        UserClient userClient = ApiUtils.getAPIService().create(UserClient.class);

        Call<RecipeDataModel> call = userClient.getAllRecipes(id,pageno,10,token);
        call.enqueue(new Callback<RecipeDataModel>() {
            @Override
            public void onResponse(Call<RecipeDataModel> call, Response<RecipeDataModel> response) {

                Log.d("Check Message", String.valueOf(response.body()));
                progressDialog.dismiss();


                if (response.body()!=null && !response.body().getData().isEmpty())
                {
                    List<RecipeSubDataModel> data = response.body().getData();
                    dataModels.addAll(data);
                    RecipeAdapter recipeAdapter = new RecipeAdapter(context,dataModels);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(staggeredGridLayoutManager);
                    recyclerView.setAdapter(recipeAdapter);
                    progress_bar_load_new_item.setVisibility(View.GONE);
                    progressDialog.dismiss();
                }
                else {

                    if (pageno>=2)
                    {
                        progressDialog.dismiss();
                        //Toast.makeText(context,"No more Data",Toast.LENGTH_LONG).show();
                    }
                    if (pageno==1)
                    {
                        progressDialog.dismiss();
                        Toast.makeText(context,"No data found",Toast.LENGTH_LONG).show();
                    }
                    if (progressDialog.isShowing())
                    {
                        progressDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<RecipeDataModel> call, Throwable t) {
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