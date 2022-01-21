package com.example.contactsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button cnew;
    ImageView call,locate,webs,face;
    String rname,rcontact,rweb,radd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cnew = findViewById(R.id.cnew);

        call = findViewById(R.id.call);
        locate = findViewById(R.id.locate);
        webs = findViewById(R.id.webs);
        face = findViewById(R.id.face);

        call.setVisibility(View.GONE);
        locate.setVisibility(View.GONE);
        webs.setVisibility(View.GONE);
        face.setVisibility(View.GONE);

        cnew.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,createactivity.class);
            startActivityForResult(intent,1);
        });

        call.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+rcontact));
            startActivity(intent);
        });

        locate.setOnClickListener(view -> {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+radd));
            startActivity(intent);
        });

        webs.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+rweb));
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1)
        {
            if(resultCode==RESULT_OK)
            {
                face.setVisibility(View.VISIBLE);
                call.setVisibility(View.VISIBLE);
                locate.setVisibility(View.VISIBLE);
                webs.setVisibility(View.VISIBLE);

                rname = data.getStringExtra("Name");
                rcontact = data.getStringExtra("Contact");
                rweb = data.getStringExtra("Webs");
                radd = data.getStringExtra("Address");

                if(data.getStringExtra("Mood").equals("Green"))
                {
                    face.setImageResource(R.drawable.green);
                }
                else if(data.getStringExtra("Mood").equals("Red"))
                {
                    face.setImageResource(R.drawable.red);
                }
                else
                {
                    face.setImageResource(R.drawable.yellow);
                }

            }

            if(resultCode==RESULT_CANCELED)
            {

            }

        }
    }
}