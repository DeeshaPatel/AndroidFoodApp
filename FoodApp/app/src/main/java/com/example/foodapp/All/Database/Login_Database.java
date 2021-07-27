package com.example.foodapp.All.Database;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.foodapp.All.Activitys.Questionnaire1;

import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Login_Database extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    String user_name,user_pass;
    ProgressDialog progressDialog;

    public Login_Database(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        String login_url = "http://mymeal.rapidlogistic.in/api/Login/CustomerLogin";
        try {

            Log.d("ERROR point 1","e");
            user_name = strings[0];
            user_pass = strings[1];
            URL url = new URL(login_url);
            Log.d("ERROR point 1","e");


            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            Log.d("ERROR point 1","e");

            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("UserName", "UTF-8")+"="+URLEncoder.encode(user_name, "UTF-8")+"&"+URLEncoder.encode("Password", "UTF-8")+"="+URLEncoder.encode(user_pass, "UTF-8");
            Log.d("URL",post_data);
            String nurl = login_url + "?" + post_data;
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            Log.d("ERROR point 1","e");
            Log.d("ERROR point 1",nurl);

            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String json;
            Log.d("ERROR point 1","e");
            while ((json = bufferedReader.readLine()) != null) {
                sb.append(json + "\n");
            }
            Log.d("bbbbbbb",sb.toString());
            return sb.toString().trim();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
    @Override
    protected void onPreExecute() {

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Food App");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please wait");
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        progressDialog.dismiss();
        String message="",status="";
        Log.d("MESSAGE",s);
//        if (s.contains("Message"))
//        {
//            try {
//                JSONArray jsonArray = new JSONArray(s);
//                JSONObject obj = jsonArray.getJSONObject(0);
//                message = obj.getString("Message");
//                status = obj.getString("Status");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        if (message.equalsIgnoreCase("User Not Found"))
//        {
//            Toast.makeText(context,"User Not Found", Toast.LENGTH_LONG).show();
//        }
//        else
//        {
//            SharedPreferences sharedPreferences = context.getSharedPreferences("Mypref", Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("namekey",user_name);
//            editor.putString("passwordkey",user_pass);
//            editor.putBoolean("key",true);
//            editor.commit();
//
//            if (status.equalsIgnoreCase("true"))
//            {
//                Intent i = new Intent(context, Questionnaire1.class);
//                context.startActivity(i);
//            }
//        }
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Food App");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please wait");
        progressDialog.show();
    }
}
