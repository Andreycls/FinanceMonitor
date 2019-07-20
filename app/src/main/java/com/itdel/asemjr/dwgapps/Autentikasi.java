package com.itdel.asemjr.dwgapps;
//
//import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by asemJr on 2/2/2018.
 */


import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Created by asemJr on 2/9/2018.
 */

public class Autentikasi extends AppCompatActivity {

//    SQLiteOpenHelper openHelper;
//    SQLiteDatabase DWGApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.login);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS,
                WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS |
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

//        BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
//        if (bluetoothAdapter == null) {
//
//            Toast.makeText(getApplicationContext(),"Device tidak mendukung Bluetooth",Toast.LENGTH_SHORT).show();
//          //  Message.message(getApplicationContext(),"Insertion Successful");
//        }
//        else {
//            Toast.makeText(getApplicationContext(),"Device mendukung Bluetooth",Toast.LENGTH_SHORT).show();
//
//
//        }









        final EditText EUsername = (EditText) findViewById(R.id.userName);
        final EditText EUserPassword = (EditText) findViewById(R.id.userPassword);
        Button BMasuk = (Button) findViewById(R.id.BMasuk);

//        final DBHandler login = new DBHandler(this);
        //login.addContact(new User(3,"admin", "admin"));
        BMasuk.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String Username = EUsername.getText().toString();
                    String Password = EUserPassword.getText().toString();
                    Intent ILogin = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(ILogin);
//
////                    final Boolean Login = login.checkUser(Username);
//                    String User = "User";
//                    if (User=="User") {
////                        Toast.makeText(Autentikasi.this, "Username and password is correct",
////                                    Toast.LENGTH_SHORT).show();
////                        Intent ILogin = new Intent(getApplicationContext(), MainActivity.class);
//                        startActivity(ILogin);
//
//                    }
//                    else {
//                        Snackbar snackbar = Snackbar
//                                .make(findViewById(android.R.id.content), "Username atau Password salah!", Snackbar.LENGTH_LONG);
//
//                        snackbar.show();
//
//                    }

                    // Do something in response to button click
                }
            });






    }
    public void click(View v) {
        Intent intent = null;
        switch(v.getId()) {
            case R.id.tDaftar: // R.id.textView1
                intent = new Intent(this, Register.class);
                break;
//            case R.id.complain: // R.id.textView2
//                intent = new Intent(this, Third.class);
//                break;
//            case R.id.feed: // R.id.textView3
//                intent = new Intent();
        }
        startActivity(intent);
    }

}

