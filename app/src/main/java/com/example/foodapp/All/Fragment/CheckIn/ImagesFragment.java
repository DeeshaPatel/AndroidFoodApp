package com.example.foodapp.All.Fragment.CheckIn;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.foodapp.R;

import java.io.IOException;


public class ImagesFragment extends Fragment {

    RelativeLayout u_front,u_back,u_side,r_front,r_back,r_side;
    Bitmap bitmap;
    ImageView ifront,iside,iback;
    int id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_images, container, false);

        u_front = (RelativeLayout)view.findViewById(R.id.btn_upload_front_photo);
        u_back = (RelativeLayout)view.findViewById(R.id.btn_upolad_back_photo);
        u_side = (RelativeLayout)view.findViewById(R.id.btn_upload_side_photo);
        r_front = (RelativeLayout)view.findViewById(R.id.btn_remove_front_photo);
        r_back = (RelativeLayout)view.findViewById(R.id.btn_remove_back_photo);
        r_side = (RelativeLayout)view.findViewById(R.id.btn_remove_side_photo);

        ifront = (ImageView)view.findViewById(R.id.ivfont1);
        iside = (ImageView)view.findViewById(R.id.ivback);
        iback = (ImageView)view.findViewById(R.id.ivside);

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


}