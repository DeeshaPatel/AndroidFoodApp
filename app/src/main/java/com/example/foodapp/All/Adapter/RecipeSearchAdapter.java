package com.example.foodapp.All.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.foodapp.All.Database.Service.ApiUtils;
import com.example.foodapp.All.Database.Service.RecipeDataModel;

import com.example.foodapp.All.Database.Service.RecipeSearchByNameSubModel;
import com.example.foodapp.All.Database.Service.RecipeSearchDataModel;
import com.example.foodapp.All.Database.Service.RecipeSubDataModel;
import com.example.foodapp.All.Database.Service.UserClient;
import com.example.foodapp.All.Fragment.RecipeFragment;
import com.example.foodapp.All.Fragment.RecipeViewDetailsFragment;
import com.example.foodapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeSearchAdapter extends RecyclerView.Adapter<RecipeSearchAdapter.ViewHolder>{

    static Context context;
    ArrayList<RecipeSearchByNameSubModel> recipeModels;
    static RecipeSubDataModel searchByNameSubModels;
    static SharedPreferences sharedPreferences;
    static String token;
    public static ProgressDialog progressDialog;


    public RecipeSearchAdapter(Context context, ArrayList<RecipeSearchByNameSubModel> recipeModels)
    {
        this.context = context;
        this.recipeModels = recipeModels;
    }

    @NonNull
    @Override
    public RecipeSearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_recipe, parent, false);
        return new RecipeSearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecipeSearchAdapter.ViewHolder holder, final int position) {

        holder.mealname.setText(recipeModels.get(position).getRecipeName());

        Picasso.get().load(recipeModels.get(position).getImagePath()).into(holder.image);

//        try {
//            URL url = new URL(recipeModels.get(position).getImagePath());
//            Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            holder.image.setImageBitmap(image);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        holder.r_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showProgress();
                getSearchedView(recipeModels.get(position).getId());

            }
        });

    }

    @Override
    public int getItemCount() {
        return recipeModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView mealname,cal;
        RelativeLayout r_view;
        CardView card_view_recipe;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.img_view_recipe);
            mealname = (TextView)itemView.findViewById(R.id.recipe_meal_name);
            cal = (TextView)itemView.findViewById(R.id.recipe_meal_cal);
            card_view_recipe = itemView.findViewById(R.id.card_view_recipe);
            r_view = (RelativeLayout) itemView.findViewById(R.id.rl_view_recipe);

        }
    }

    public static void getSearchedView(final String id)
    {
        RecipeFragment.dataModels.clear();
        sharedPreferences = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        token = "Bearer "+sharedPreferences.getString("token","");
        UserClient userClient = ApiUtils.getAPIService().create(UserClient.class);

        Call<RecipeSearchDataModel> call = userClient.getSearchDescriptionData(id,token);
        call.enqueue(new Callback<RecipeSearchDataModel>() {
            @Override
            public void onResponse(Call<RecipeSearchDataModel> call, Response<RecipeSearchDataModel> response) {

                if (!response.isSuccessful())
                {
                    Toast.makeText(context,"BEEE",Toast.LENGTH_LONG).show();
                }

                Log.d("BBBBBBBBBBBBBBB", String.valueOf(response.body()));
                //progressDialog.dismiss();
                if (response.body()!=null)
                {
                    RecipeSubDataModel data = response.body().getData();

                    progressDialog.dismiss();
                    RecipeFragment.dataModels.clear();
                    AppCompatActivity activity = (AppCompatActivity) context;
                    RecipeViewDetailsFragment myFragment = new RecipeViewDetailsFragment(data.getIngredient(),data.getNotes(),data.getTotalCarb(),data.getTotalFat(),data.getTotalFiber(),data.getTotalProtein(),data.getProcedure(),data.getImagePath());
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

                }
                else {

                    Toast.makeText(context,"Wrong",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RecipeSearchDataModel> call, Throwable t) {
                Log.d("FFFFFFF",t.getMessage());
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
