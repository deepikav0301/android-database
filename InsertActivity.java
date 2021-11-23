package com.example.applicationdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InsertActivity extends AppCompatActivity {
    String p_name="";
    String brand="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Button submit=findViewById(R.id.btnSubmit);
        Spinner spinner = findViewById(R.id.productname);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Dairy Milk");
        arrayList.add("Munch");
        arrayList.add("Kit-Kat");
        arrayList.add("Gems");
        arrayList.add("Milky Bar");
        arrayList.add("Hide and Seek");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(InsertActivity.this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                p_name = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase mydatabase = openOrCreateDatabase("Product_details",MODE_PRIVATE,null);
                EditText id = findViewById(R.id.productid);
                RadioButton rb1, rb2;
                rb1 = findViewById(R.id.cadbury);
                rb2 = findViewById(R.id.nestle);
                EditText desc = findViewById(R.id.description);
                EditText price = findViewById(R.id.productprice);
                String TABLE_NAME = "products";
                int p_id = Integer.parseInt(id.getText().toString());
                if(rb1.isChecked())  {
                    brand = rb1.getText().toString();
                }
                if(rb2.isChecked())  {
                    brand = rb2.getText().toString();
                }
                String description = desc.getText().toString();
                int p_price = Integer.parseInt(price.getText().toString());
                String PRODUCT_PRICE = "product_price";

                ContentValues contentValues = new ContentValues();
                contentValues.put("product_id",p_id);
                contentValues.put("product_name",p_name);
                contentValues.put("product_brand",brand);
                contentValues.put("description",description);
                contentValues.put("product_price",p_price);
                long result = mydatabase.insert(TABLE_NAME,null ,contentValues);
                if(result == -1) {
                    Toast.makeText(InsertActivity.this, "Product not Inserted", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(InsertActivity.this,"Product Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}