package com.paras.roomsample.user.userlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.paras.roomsample.LauncherApp;
import com.paras.roomsample.R;
import com.paras.roomsample.model.database.AppDatabase;
import com.paras.roomsample.model.datamodel.Address;
import com.paras.roomsample.model.datamodel.User;

public class AddUserView extends AppCompatActivity {
    EditText etFname, etLname, etStreet, etCity, etState, etPIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_view);
        etFname = (EditText) findViewById(R.id.etFName);
        etLname= (EditText) findViewById(R.id.etLName);
        etStreet= (EditText) findViewById(R.id.etStreet);
        etCity= (EditText) findViewById(R.id.etCity);
        etState= (EditText) findViewById(R.id.etState);
        etPIN= (EditText) findViewById(R.id.etPin);
        Button add= (Button) findViewById(R.id.btnAddUser);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user= new User();
                user.setFirstName(etFname.getText().toString());
                user.setLastName(etLname.getText().toString());
                Address address= new Address();
                address.setCity(etCity.getText().toString());
                address.setStreet(etStreet.getText().toString());
                address.setState(etState.getText().toString());
                address.setPostCode(Integer.parseInt(etPIN.getText().toString()));
                user.setAddress(address);
                AppDatabase database = LauncherApp.getDbInstanc();
                UserContract.UserDao userDao = database.userDao();
                userDao.insertAll(user);
            }
        });
    }
}
