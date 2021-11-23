package com.example.applicationdb;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.TextView;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        final int DATABASE_VERSION = 1;
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
       /* TextView status;
        status = (TextView)findViewById(R.id.creation_status);
        status.setText("Database created successfully.");*/
    }
}