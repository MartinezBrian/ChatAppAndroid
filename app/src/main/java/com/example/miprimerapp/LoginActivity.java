package com.example.miprimerapp;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText userName;
    private Button login;
    private TextView errorMSG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.userName = findViewById(R.id.userName);
        this.login = findViewById(R.id.login);
        this.errorMSG = findViewById(R.id.errorMSG);
    }
    private void loginAction() {
        LoginService  speakerService = ApplicationConstants.getRetrofitBuilder(LoginService.class);
        Call <User> call = speakerService.SingUp(new User(this.userName.getText().toString()));

        call.enqueue(new Callback <User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
              Intent iR =  new Intent();
              iR.putExtra("id",user.Id);
              iR.putExtra("name",User.Name);
              iR.putExtra("status",User.status);
              iR.putExtra("pendingMSG",User.pendingMSG);

              setResult(Activity.RESULT_OK,iR);
              finish();
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("User", "NO COMPILA MAAAAS");
                errorMSG.setText(t.getLocalizedMessage());
            }
        }
    }


}
