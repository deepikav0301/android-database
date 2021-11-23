package com.example.applicationdb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        Button submit=findViewById(R.id.button3);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase mydatabase = openOrCreateDatabase("Product_details", MODE_PRIVATE, null);
                EditText p_id = findViewById(R.id.deleteid);
                int d_id = Integer.parseInt(p_id.getText().toString());
                int d_rows = mydatabase.delete("products", "product_id = ?",new String[] {String.valueOf(d_id)});
                if(d_rows > 0)
                    Toast.makeText(DeleteActivity.this,"Product Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DeleteActivity.this,"Product not Deleted",Toast.LENGTH_LONG).show();
            }
        });
    }
}