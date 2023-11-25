package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music_app.model.User;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    private EditText email, password, name;
    private Button btnSignUp;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.rInpPassword);
        name = findViewById(R.id.rInpFullname);
        btnSignUp = findViewById(R.id.btnRegister);
        textView = findViewById(R.id.textView2);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(email.getText().toString(), password.getText().toString());
                user.setName(name.getText().toString());
                user.setRoleid(1L);
                DataService dataService = APIService.getService();
                Call<User> call = dataService.register(user);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user1 = response.body();
                        if(user1 != null) {
                            Toast.makeText(getApplicationContext(), "Register is succesful", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Register is failure", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}