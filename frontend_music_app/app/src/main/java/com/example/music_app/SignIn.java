package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music_app.model.Topic;
import com.example.music_app.model.User;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {

    private EditText email, password;
    private Button btnSignIn;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = findViewById(R.id.txtEmailOrName);
        password = findViewById(R.id.txtPassWordSignIn);
        btnSignIn = findViewById(R.id.btSignIn);
        textView = findViewById(R.id.textView4);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(email.getText().toString(), password.getText().toString());
                DataService dataService = APIService.getService();
                Call<User> call = dataService.getUser(user);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user1 = response.body();
                        if(user1 != null) {
                            Toast.makeText(getApplicationContext(), "Login is successfully", Toast.LENGTH_LONG).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                                    intent.putExtra("myUser", user1);
                                    startActivity(intent);
                                }
                            }, 2000);
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Email or Password is invalid", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), Register.class);
                startActivity(it);
            }
        });

    }
}