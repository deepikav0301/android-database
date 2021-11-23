package com.example.applicationdb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class RetrieveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        Button submit=findViewById(R.id.button1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase mydatabase = openOrCreateDatabase("Product_details", MODE_PRIVATE, null);
                EditText id = findViewById(R.id.searchid);
                TextView p_id = (TextView) findViewById(R.id.pid);
                TextView p_name = (TextView) findViewById(R.id.pname);
                TextView p_brand = (TextView) findViewById(R.id.pbrand);
                TextView p_desc = (TextView) findViewById(R.id.pdesc);
                TextView p_price = (TextView) findViewById(R.id.pprice);
                int searchid = Integer.parseInt(id.getText().toString());
                Cursor res = mydatabase.rawQuery( "select * from products WHERE product_id=" + searchid +";", null );
                if(res.getCount() == 0) {
                    // show message
                    showMessage("Error", "Product not found");
                    return;
                }
                res.moveToFirst();
                while(!res.isAfterLast()) {
                    p_id.setText(res.getString(res.getColumnIndex("product_id")));
                    p_name.setText(res.getString(res.getColumnIndex("product_name")));
                    p_brand.setText(res.getString(res.getColumnIndex("product_brand")));
                    p_desc.setText(res.getString(res.getColumnIndex("description")));
                    p_price.setText(res.getString(res.getColumnIndex("product_price")));
                    res.moveToNext();
                }
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