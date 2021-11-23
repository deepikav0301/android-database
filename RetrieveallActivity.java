package com.example.applicationdb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;

public class RetrieveallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieveall);
        Button submit=findViewById(R.id.button2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase mydatabase = openOrCreateDatabase("Product_details", MODE_PRIVATE, null);
                EditText p_brand = findViewById(R.id.searchbrand);
                String s_brand = p_brand.getText().toString();
                Cursor res = mydatabase.rawQuery( "select * from products WHERE product_brand='" + s_brand +"';", null);
                if(res.getCount() == 0) {
                    // show message
                    showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :"+ res.getInt(0)+"\n");
                    buffer.append("Name :"+ res.getString(1)+"\n");
                    buffer.append("Brand :"+ res.getString(2)+"\n");
                    buffer.append("Description :"+ res.getString(3)+"\n");
                    buffer.append("Price :"+ res.getInt(4)+"\n\n");
                }
                showMessage("Products : ",buffer.toString());
            }
        });

    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}