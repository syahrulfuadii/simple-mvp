package com.example.mvp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvp1.Presenter.LoginPresenter;
import com.example.mvp1.View.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    EditText uname,pass;
    ProgressBar progressbar;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loginPresenter = new LoginPresenter(this, new LoginPresenter());
    }

    private void initViews() {
        uname = findViewById(R.id.uname);
        pass = findViewById(R.id.pass);
        progressbar = findViewById(R.id.progressbar);
    }

    public void loginMe(View View){
        showProgressbar();

        loginPresenter.validateCredentials(uname.getText().toString().trim());
    }

    @Override
    public void setUsernameError() {
        hideProgressbar();
        uname.setError("Username can't be empty!");

    }

    @Override
    public void setPasswordError() {
        hideProgressbar();
        pass.setError("password can't be empty!");

    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void onLoginSucces(String username) {
        Intent intent = new Intent(this,WelcomeActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    @Override
    public void onLoginError() {

        hideProgressbar();
        Toast.makeText(this,"Username or Password doesn't match",Toast.LENGTH_LONG)

    }
}
