package com.example.amir.foodorder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddFood extends AppCompatActivity {

    private ImageButton foodImage;
    private  static final int CALLRQ=1;
    private EditText name,desc,price;
    private Uri uri=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        name=(EditText)findViewById(R.id.itemName);
        desc=(EditText)findViewById(R.id.itemDesc);
        price=(EditText)findViewById(R.id.itemPrice);
    }

    public void AddToMenu(View view) {
    }

    public void Imagebtu(View view) {
        Intent imageIntent=new Intent(Intent.ACTION_GET_CONTENT);
        imageIntent.setType("Image/*");
        startActivityForResult(imageIntent,CALLRQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CALLRQ&&resultCode==RESULT_OK)
        {
            uri=data.getData();
            foodImage=(ImageButton)findViewById(R.id.imagebutton);
            foodImage.setImageURI(uri);

        }
    }
}
