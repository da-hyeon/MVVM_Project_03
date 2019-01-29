package com.example.hwangdahyeon.mvvm_project_03;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.hwangdahyeon.mvvm_project_03.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private UsersViewModel usersViewModel = new UsersViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        binding.setModel(usersViewModel);

        usersViewModel.onCreate();
    }

    @BindingAdapter("app:items")
    public static void setUserList(ListView listView , ObservableArrayList<UserViewModel> users) {
        UserListViewAdapter adapter;

        if(listView.getAdapter() == null){
            adapter = new UserListViewAdapter();
            listView.setAdapter(adapter);
        } else {
            adapter = (UserListViewAdapter) listView.getAdapter();
        }

        adapter.addAll(users);
    }
}
