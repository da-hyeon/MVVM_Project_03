package com.example.hwangdahyeon.mvvm_project_03;

import android.databinding.ObservableField;

public class UserViewModel {
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> email = new ObservableField<>();

    public UserViewModel(String name , String email){
        this.name.set(name);
        this.email.set(email);
    }
}
