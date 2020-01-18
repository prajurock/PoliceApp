package com.example.policeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BeatActivity extends AppCompatActivity {

    TextView names;
    TextView mobile;
    EditText time;
    EditText local;
    EditText assin;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beat);
        String name = getIntent().getExtras().getString("Name");
        String mobileNo = getIntent().getExtras().getString("MobileNo");
        String timee = getIntent().getExtras().getString("timeshift");
        String locals = getIntent().getExtras().getString("location");
        String assign = getIntent().getExtras().getString("assignedx");

        names=findViewById(R.id.textView1);
        mobile=findViewById(R.id.textView2);
        time=findViewById(R.id.edit_text1);
        local=findViewById(R.id.edit_text2);
        assin=findViewById(R.id.edit_text3);

        names.setText(name.toUpperCase());
        mobile.setText(mobileNo);
        Linkify.addLinks(mobile, Linkify.ALL);
        time.setText(timee);
        local.setText(locals);
        assin.setText(assign);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d=mobile.getText().toString();
                String a=time.getText().toString();
                String b=local.getText().toString();
                String c=assin.getText().toString();

                Reportbw bw=new Reportbw(getApplicationContext());
                bw.execute(d,a,b,c);
                time.setText("");
                local.setText("");
                assin.setText("");


                finish();

            }
        });



    }
}
