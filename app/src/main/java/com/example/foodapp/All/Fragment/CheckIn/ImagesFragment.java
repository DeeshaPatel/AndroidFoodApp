package com.example.foodapp.All.Fragment.CheckIn;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.foodapp.All.Adapter.RecipeCategoryAdapter;
import com.example.foodapp.All.Database.Service.ApiUtils;
import com.example.foodapp.All.Database.Service.GetCheckInListMainModel;
import com.example.foodapp.All.Database.Service.GetCheckInListSubDataModel;
import com.example.foodapp.All.Database.Service.RecipeCategoryDataModel;
import com.example.foodapp.All.Database.Service.RecipeCategorySubDataModel;
import com.example.foodapp.All.Database.Service.UserClient;
import com.example.foodapp.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ImagesFragment extends Fragment {

    RelativeLayout u_front,u_back,u_side,r_front,r_back,r_side;
    Bitmap bitmap;
    ImageView ifront,iside,iback;
    int id;
    SharedPreferences sharedPreferences;
    String token="";
    static ProgressDialog progressDialog;
    static Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_images, container, false);

        context = getContext();

        u_front = (RelativeLayout)view.findViewById(R.id.btn_upload_front_photo);
        u_back = (RelativeLayout)view.findViewById(R.id.btn_upolad_back_photo);
        u_side = (RelativeLayout)view.findViewById(R.id.btn_upload_side_photo);
        r_front = (RelativeLayout)view.findViewById(R.id.btn_remove_front_photo);
        r_back = (RelativeLayout)view.findViewById(R.id.btn_remove_back_photo);
        r_side = (RelativeLayout)view.findViewById(R.id.btn_remove_side_photo);

        ifront = (ImageView)view.findViewById(R.id.ivfont1);
        iside = (ImageView)view.findViewById(R.id.ivback);
        iback = (ImageView)view.findViewById(R.id.ivside);

        loadImages();

        u_front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = 1;
                phototaking();
            }
        });
        u_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = 3;
                phototaking();
            }
        });
        u_side.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = 2;
                phototaking();
            }
        });
        r_front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ifront.setImageResource(R.drawable.photo);
            }
        });
        r_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iside.setImageResource(R.drawable.photo);
            }
        });
        r_side.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iback.setImageResource(R.drawable.photo);
            }
        });

        return view;

    }


    public void phototaking(){

        final String[] imageopion = {"Take photo", "Choose from Library", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Choose Option");
        builder.setCancelable(false);
        builder.setItems(imageopion, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (imageopion[item].equals("Take photo"))
                {
                    Log.d("Heello","helllo");
                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, 1);
                }
                else if (imageopion[item].equals("Choose from Library"))
                {
                    Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                }
                else if (imageopion[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            bitmap = (Bitmap) data.getExtras().get("data");
            if (id ==1) {
                ifront.setImageBitmap(bitmap);
            }
            if (id ==2){
                iback.setImageBitmap(bitmap);
            }
            if (id==3){
                iside.setImageBitmap(bitmap);
            }
        }
        if(requestCode==2){
            Uri selectedImage = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), selectedImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (id ==1) {
                ifront.setImageBitmap(bitmap);
            }
            if (id ==2){
                iback.setImageBitmap(bitmap);
            }
            if (id==3){
                iside.setImageBitmap(bitmap);
            }
        }
    }
    private void loadImages() {

        showProgress();

        sharedPreferences = getActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        token = "Bearer "+sharedPreferences.getString("token","");

        UserClient userClient = ApiUtils.getAPIService().create(UserClient.class);

        Call<GetCheckInListMainModel> call = userClient.getCheckInList(token);
        Log.d("WWWWWWWWW",token);
        call.enqueue(new Callback<GetCheckInListMainModel>() {
            @Override
            public void onResponse(Call<GetCheckInListMainModel> call, Response<GetCheckInListMainModel> response) {

                Log.d("QQQQQQQQQQ", String.valueOf(response.body()));
                progressDialog.dismiss();

                if (response.body()!=null)
                {
                    List<GetCheckInListSubDataModel> recipeCategorySubDataModels = response.body().getData();
                    Picasso.get().load(recipeCategorySubDataModels.get(0).getFrontImagePath()).into(ifront);
                    Picasso.get().load(recipeCategorySubDataModels.get(0).getBackImagePath()).into(iback);
                    Picasso.get().load(recipeCategorySubDataModels.get(0).getSideImagePath()).into(iside);

                }
                else {
                    Toast.makeText(getContext(),"CHECK",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GetCheckInListMainModel> call, Throwable t) {
                Toast.makeText(getContext(),"Something is wrong",Toast.LENGTH_LONG).show();
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