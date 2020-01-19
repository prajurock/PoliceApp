package com.example.policeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LookupNotices extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    Button butn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup_notices);

        ed1=(EditText)findViewById(R.id.off);
        butn=(Button)findViewById(R.id.appt);
    }


    public void req(View view)
    {
        String str_name=ed1.getText().toString();
        LookupBW bw=new LookupBW(this);
        bw.execute(str_name);
        ed1.setText("");

    }

}
