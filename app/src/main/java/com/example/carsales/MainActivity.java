package com.example.carsales;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=new Intent(this,MainPage.class);
        ConnectionClass connection;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.Resultss);
        TextView login=(TextView)findViewById(R.id.Login);
        connection=new ConnectionClass();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit =  (EditText) findViewById(R.id.UsernameTextbox);
                String usersname=edit.getText().toString();
                EditText edit2 =  (EditText) findViewById(R.id.PasswordTextbox);
                String passwords=edit2.getText().toString();
                if(usersname.trim().equals("")||passwords.trim().equals("")){
                    textView.setText("Please enter all fields");
                }
                else {
                    try {
                        Connection conn = connection.CONN();
                        if (conn == null) {
                            textView.setText("Check internet connection");
                        } else {
                            String query = "SELECT * FROM Carsales.`User Data`;";
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY);
                            ResultSet rs = stmt.executeQuery(query);
                            while (rs.next()) {
                                if (rs.getString("Usernames").equals(usersname) && rs.getString("Passwords").equals(passwords)) {
                                    textView.setText("Login Success");
                                    startActivity(intent);
                                    break;
                                } else {
                                    textView.setText("Login Failed");
                                }
                            }

                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        textView.setText("Fail");
                    }
                    }
                }
        });

    }


    public void LoginClicked(View v){



    }
}