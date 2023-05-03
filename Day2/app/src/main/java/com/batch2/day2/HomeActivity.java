package com.batch2.day2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText edtxt1, edtxt2, edtxt3;
    ImageView imcap1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button b1 = (Button) findViewById(R.id.but1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });

        edtxt1 = findViewById(R.id.txtUsername);
        edtxt2 = findViewById(R.id.txtEmail);
        edtxt3 = findViewById(R.id.txtPassword);
        imcap1 = findViewById(R.id.imgCapt);
    }

    public void but2Click(View view) {
        String Username = edtxt1.getText().toString();
        String Email = edtxt2.getText().toString();
        String Password = edtxt3.getText().toString();
        String toastMsg = "Welcome" + Username + "Email" + Email + "Password" + Password;
        Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();

        Intent in2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(in2, 69);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==69 && resultCode==RESULT_OK){
            Bundle b1 = data.getExtras();
            Bitmap bmp1 = (Bitmap) b1.get("data");
            imcap1.setImageBitmap((bmp1));
        }
    }

}