package com.paras.roomsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.paras.roomsample.model.database.AppDatabase;
import com.paras.roomsample.user.userlist.AddUserView;
import com.paras.roomsample.user.userlist.UserContract;
import com.paras.roomsample.user.userlist.UserListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.lvUsers);
        AppDatabase database = LauncherApp.getDbInstanc();
        UserContract.UserDao userDao = database.userDao();
        UserListAdapter adapter = new UserListAdapter(this, userDao.getAll());
        listView.setAdapter(adapter);
        Button addUser = (Button) findViewById(R.id.btnAddUser);
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddUserView.class);
                startActivity(intent);
            }
        });
    }
}
