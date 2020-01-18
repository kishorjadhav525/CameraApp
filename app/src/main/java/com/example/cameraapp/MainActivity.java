package com.example.cameraapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {
    ImageView iv;
    Button bm;
    ImageButton ib;
    Intent cameraintent;
    Bitmap bitmap;

    private final int clickcode=100;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



           if(resultCode==RESULT_OK)
           {

              Bundle bundle= data.getExtras();
              // data pass image
               bitmap= (Bitmap) bundle.get("data");
               iv.setImageBitmap(bitmap);


           }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.iv);
        ib=findViewById(R.id.ib);
        bm=findViewById(R.id.bm);


        InputStream inputStream=getResources().openRawResource(R.drawable.image_three);
              bitmap= BitmapFactory.decodeStream(inputStream);


        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               cameraintent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraintent, clickcode);

            }
        });

   bm.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v)
       {


           try {
               getApplication().setWallpaper(bitmap);
           } catch (IOException e) {
               e.printStackTrace();
           }

       }
   });



    }
}
