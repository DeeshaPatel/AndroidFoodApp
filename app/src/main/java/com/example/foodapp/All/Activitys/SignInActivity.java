package com.example.foodapp.All.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodapp.All.Database.Login_Database;
import com.example.foodapp.All.Database.Service.ApiUtils;
import com.example.foodapp.All.Database.Service.LoginRequest;
import com.example.foodapp.All.Database.Service.UserClient;
import com.example.foodapp.All.Fragment.FoodDiaryMainView;
import com.example.foodapp.All.Models.LoginUser;
import com.example.foodapp.R;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignInActivity extends AppCompatActivity {

    TextView tvSignUP;
    SharedPreferences sharedPreferences;
    RelativeLayout rlSignup;
    EditText username,password;
    ProgressDialog progressDialog;

    UserClient userClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //tvSignUP=findViewById(R.id.tvSignUP);

        rlSignup = findViewById(R.id.rlsignup);
        username = findViewById(R.id.etEmail_id);
        password = findViewById(R.id.etPassword);

        rlSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(username.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Enter User Name",Toast.LENGTH_LONG).show();
                }
                if(TextUtils.isEmpty(password.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Enter password",Toast.LENGTH_LONG).show();
                }
                else
                {
                      sendNetworkRequest(username.getText().toString(),password.getText().toString());
//                    Login_Database login_database = new Login_Database(SignInActivity.this);
//                    login_database.execute(username.getText().toString(), password.getText().toString());
                }
            }
        });


//        tvSignUP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
//                startActivity(intent);
//
//            }
//        });


    }

    private void sendNetworkRequest(String username,String password)
    {

        progressDialog = new ProgressDialog(SignInActivity.this);
        progressDialog.setTitle("Food App");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please wait");
        progressDialog.show();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        loginRequest.setPassword(password);

        Call<LoginUser> my_call = ApiUtils.getUserServices().userLogin(loginRequest);

        my_call.enqueue(new Callback<LoginUser>() {
            @Override
            public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {
                if (response.body().getMessage().equalsIgnoreCase("Login successfully"))
                {

                    sharedPreferences = getSharedPreferences("MySharedPref",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("token",response.body().getData().getToken());
                    editor.apply();
                    progressDialog.dismiss();

                    Intent i = new Intent(getApplicationContext(),Questionnaire1.class);
                    //Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext()," "+response.body().getMessage(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginUser> call, Throwable t)     {
                progressDialog.dismiss();
                Log.d("Error",t.getMessage());
                Toast.makeText(getApplicationContext()," "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

//        List<LoginUser> loginUsers = new ArrayList<LoginUser>();
//        LoginUser loginUser = new LoginUser(username,password);
//        loginUsers.add(loginUser);
//
//        HashMap<String,String> stringStringMap = new HashMap<>();
//        stringStringMap.put("UserName", username);
//        stringStringMap.put("Password",password);
//        JSONObject jsonObject = new JSONObject(stringStringMap);
//        Log.d("LOGIN USER",jsonObject.toString());
//        userClient.userLogin(loginUser).enqueue(new Callback<LoginUser>() {
//            @Override
//            public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {
//                if (response.code() == 200)
//                {
//                    if (response.body()!=null)
//                    {
//                        Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG).show();
//                        Log.d("OoOoOoOo",response.body().toString());
//                    }
//
//                }
//                else
//                {
//
//                    Log.d("OoOoOoOo",response.raw().toString());
//                    Toast.makeText(getApplicationContext(),"Error "+ response.code(),Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LoginUser> call, Throwable t) {
//                Log.e("OoOoOoOoO", "Unable to submit post to API.");
//            }
//        });
    }


}