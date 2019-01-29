package com.example.hwangdahyeon.mvvm_project_03;

import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.TextUtils;

import java.util.Random;

public class UsersViewModel implements BaseViewModel {

    public final ObservableArrayList<UserViewModel> users = new ObservableArrayList<>();
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> age = new ObservableField<>();
    public final ObservableBoolean isValid = new ObservableBoolean();

    @Override
    public void onCreate() {
        isValid.set(false);

        name.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                validation();
            }
        });

        age.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                validation();
            }
        });
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    private void validation(){
        boolean isValidName = !TextUtils.isEmpty(name.get());
        boolean isValidAge = !TextUtils.isEmpty(age.get());
        isValid.set(isValidName && isValidAge);
    }

    public void newUser(){
        users.add(new UserViewModel("Name : " + name.get() , "Age : " + age.get()));
    }
}
