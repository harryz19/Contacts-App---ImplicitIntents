package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class createactivity extends AppCompatActivity implements View.OnClickListener {

    EditText name,cn,web,add;
    ImageView grs,reds,yes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createactivity);

        name= findViewById(R.id.name);
        cn = findViewById(R.id.cn);
        web = findViewById(R.id.web);
        add = findViewById(R.id.add);

        grs = findViewById(R.id.grs);
        reds = findViewById(R.id.reds);
        yes = findViewById(R.id.yes);

        grs.setOnClickListener(this);
        reds.setOnClickListener(this);
        yes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent();
        intent.putExtra("Name",name.getText().toString());
        intent.putExtra("Contact",cn.getText().toString());
        intent.putExtra("Webs",web.getText().toString());
        intent.putExtra("Address",add.getText().toString());

        if(view.getId()==R.id.grs)
        {
            intent.putExtra("Mood","Green");
        }
        else if(view.getId()==R.id.reds)
        {
            intent.putExtra("Mood","Red");
        }
        else
        {
            intent.putExtra("Mood","Yellow");
        }

        setResult(RESULT_OK,intent);
        createactivity.this.finish();
    }
}