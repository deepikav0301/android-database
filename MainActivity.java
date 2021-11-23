package com.example.applicationdb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ca=findViewById(R.id.create);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String TABLE_NAME = "products";
                final String PRODUCT_ID = "product_id";
                final String PRODUCT_NAME = "product_name";
                final String PRODUCT_BRAND = "product_brand";
                final String DESCRIPTION = "description";
                final String PRODUCT_PRICE = "product_price";
                SQLiteDatabase mydatabase = openOrCreateDatabase("Product_details",MODE_PRIVATE,null);
                mydatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME + ";");
                String CREATE_PRODUCTS_TABLE = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"("+PRODUCT_ID +" INTEGER PRIMARY KEY, "+PRODUCT_NAME+" TEXT, "+PRODUCT_BRAND +" TEXT,"+ DESCRIPTION +" TEXT, "+PRODUCT_PRICE +" INTEGER);";
                mydatabase.execSQL(CREATE_PRODUCTS_TABLE);
                builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
                builder.setMessage("Database created successfully.")
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getApplicationContext(),"Product database created",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Database creation");
                alert.show();
            }
        });
        Button ia=findViewById(R.id.insert);
        ia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,InsertActivity.class);
                startActivity(intent);
            }
        });
        Button ua = findViewById(R.id.update);
        ua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
                startActivity(intent);
            }
        });
        Button da = findViewById(R.id.delete);
        da.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DeleteActivity.class);
                startActivity(intent);
            }
        });
        Button ra = findViewById(R.id.retrieve);
        ra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RetrieveActivity.class);
                startActivity(intent);
            }
        });
        Button r_all = findViewById(R.id.retrieve_all);
        r_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RetrieveallActivity.class);
                startActivity(intent);
            }
        });
    }
}