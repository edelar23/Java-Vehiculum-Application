package com.example.carsales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=new Intent(this,SearchPage.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        ConnectionClass connection = new ConnectionClass();
        TextView textView1 = (TextView)findViewById(R.id.textView);
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        Button NextPage=(Button) findViewById(R.id.NextPage);
        Button PreviousPage=(Button) findViewById(R.id.PreviousPage);
        Button Search=(Button) findViewById(R.id.SearchButton);

        try {
            Connection conn = connection.CONN();
                String query = "SELECT * FROM Carsales.`Vehicles`;";
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(query);
                    rs.next();
                    ImageView imageView=(ImageView) findViewById(R.id.imageView3);
                    Picasso.get().load(rs.getString("Picture")).into(imageView);
                    textView1.setText("Vin Number: "+rs.getString("VinNumber")+"\n"+"Mileage: "+rs.getString("Mileage")+
                            "\n"+"Color: "+rs.getString("Color")+"\n"+"Year: "+rs.getString("Year")+"\n"+"Make: "+rs.getString("Make")+"\n"+"Model: "+rs.getString("Model"));
                    rs.next();
                ImageView imageView2=(ImageView) findViewById(R.id.imageView1);
                Picasso.get().load(rs.getString("Picture")).into(imageView2);
                textView2.setText("Vin Number: "+rs.getString("VinNumber")+"\n"+"Mileage: "+rs.getString("Mileage")+
                        "\n"+"Color: "+rs.getString("Color")+"\n"+"Year: "+rs.getString("Year")+"\n"+"Make: "+rs.getString("Make")+"\n"+"Model: "+rs.getString("Model"));
                rs.next();
                ImageView imageView3=(ImageView) findViewById(R.id.imageView2);
                Picasso.get().load(rs.getString("Picture")).into(imageView3);
                textView3.setText("Vin Number: "+rs.getString("VinNumber")+"\n"+"Mileage: "+rs.getString("Mileage")+
                        "\n"+"Color: "+rs.getString("Color")+"\n"+"Year: "+rs.getString("Year")+"\n"+"Make: "+rs.getString("Make")+"\n"+"Model: "+rs.getString("Model"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        NextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Connection conn = connection.CONN();
                    String query = "SELECT * FROM Carsales.`Vehicles`;";
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = stmt.executeQuery(query);
                    rs.beforeFirst();
                    rs.next();
                    ImageView imageView = (ImageView) findViewById(R.id.imageView3);
                    Picasso.get().load(rs.getString("Picture")).into(imageView);
                    textView1.setText("Vin Number: " + rs.getString("VinNumber") + "\n" + "Mileage: " + rs.getString("Mileage") +
                            "\n" + "Color: " + rs.getString("Color") + "\n" + "Year: " + rs.getString("Year") + "\n" + "Make: " + rs.getString("Make") + "\n" + "Model: " + rs.getString("Model"));
                    rs.next();
                    ImageView imageView2 = (ImageView) findViewById(R.id.imageView1);
                    Picasso.get().load(rs.getString("Picture")).into(imageView2);
                    textView2.setText("Vin Number: " + rs.getString("VinNumber") + "\n" + "Mileage: " + rs.getString("Mileage") +
                            "\n" + "Color: " + rs.getString("Color") + "\n" + "Year: " + rs.getString("Year") + "\n" + "Make: " + rs.getString("Make") + "\n" + "Model: " + rs.getString("Model"));
                    rs.next();
                    ImageView imageView3 = (ImageView) findViewById(R.id.imageView2);
                    Picasso.get().load(rs.getString("Picture")).into(imageView3);
                    textView3.setText("Vin Number: " + rs.getString("VinNumber") + "\n" + "Mileage: " + rs.getString("Mileage") +
                            "\n" + "Color: " + rs.getString("Color") + "\n" + "Year: " + rs.getString("Year") + "\n" + "Make: " + rs.getString("Make") + "\n" + "Model: " + rs.getString("Model"));
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        PreviousPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Connection conn = connection.CONN();
                    String query = "SELECT * FROM Carsales.`Vehicles`;";
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = stmt.executeQuery(query);
                    rs.previous();
                    rs.previous();
                    rs.previous();
                    rs.next();
                    ImageView imageView = (ImageView) findViewById(R.id.imageView1);
                    Picasso.get().load(rs.getString("Picture")).into(imageView);
                    textView1.setText("Vin Number: " + rs.getString("VinNumber") + "\n" + "Mileage: " + rs.getString("Mileage") +
                            "\n" + "Color: " + rs.getString("Color") + "\n" + "Year: " + rs.getString("Year") + "\n" + "Make: " + rs.getString("Make") + "\n" + "Model: " + rs.getString("Model"));
                    rs.next();
                    ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
                    Picasso.get().load(rs.getString("Picture")).into(imageView2);
                    textView2.setText("Vin Number: " + rs.getString("VinNumber") + "\n" + "Mileage: " + rs.getString("Mileage") +
                            "\n" + "Color: " + rs.getString("Color") + "\n" + "Year: " + rs.getString("Year") + "\n" + "Make: " + rs.getString("Make") + "\n" + "Model: " + rs.getString("Model"));
                    rs.next();
                    ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
                    Picasso.get().load(rs.getString("Picture")).into(imageView3);
                    textView3.setText("Vin Number: " + rs.getString("VinNumber") + "\n" + "Mileage: " + rs.getString("Mileage") +
                            "\n" + "Color: " + rs.getString("Color") + "\n" + "Year: " + rs.getString("Year") + "\n" + "Make: " + rs.getString("Make") + "\n" + "Model: " + rs.getString("Model"));
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);

            }
        });


    }
}