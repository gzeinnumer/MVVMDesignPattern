package com.gzeinnumer.mvvm.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.gzeinnumer.mvvm.BR;
import com.gzeinnumer.mvvm.Model.User;

public class LoginViewModel extends BaseObservable {

    private User user;

    @Bindable
    public String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public LoginViewModel() {
        user = new User("", "");
    }

    public void afterEmailTextChanged(CharSequence s) {
        user.setEmail(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        user.setPassword(s.toString());
    }

    public void onLoginClicked() {
        int loginCode = user.isValidData();
        if (loginCode == 0)
            setToastMessage("Masukan Email");
        else if(loginCode == 1)
            setToastMessage("masukan email yang benar");
        else if(loginCode == 2)
            setToastMessage("Harus lebih dari 6 huruf");
        else
            setToastMessage("Suksess!!");

    }
}