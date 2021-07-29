package com.example.foodapp.All.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodapp.R;

public class PersonalDetails extends AppCompatActivity {

    Button submit;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_personal_details);

        back = (ImageView)findViewById(R.id.personal_details_back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(i);
            }
        });

        submit = (Button)findViewById(R.id.btn_personal_details_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PersonalDetails.this, Questionnaire1.class);
                startActivity(i);
            }
        });
    }

}
