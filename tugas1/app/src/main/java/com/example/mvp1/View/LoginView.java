package com.example.mvp1.View;

public interface LoginView {

    void setUsernameError();
    void setPasswordError();
    void showProgressbar();
    void hideProgressbar();
    void onLoginSucces(String username);
    void onLoginError();
}
