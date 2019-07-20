package com.itdel.asemjr.dwgapps;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
/**
 * Created by asemJr on 2/2/2018.
 */

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.register);
        Toolbar TTentang = (Toolbar) findViewById(R.id.TPengaturan);
        TTentang.setTitle("Daftar akun");
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS,
                WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS |
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        setSupportActionBar(TTentang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final DBHandler db = new DBHandler(this);
        Button   BDaftar    = (Button)   findViewById(R.id.BDaftar);
        BDaftar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText ETUsername = (EditText) findViewById(R.id.username);
                    String txtUsername = ETUsername.getText().toString();
                EditText ETPassword = (EditText) findViewById(R.id.password);
                    String txtPassword = ETPassword.getText().toString();


                if (txtUsername.matches("") || txtPassword.matches("")) {
                    ETUsername.setText("");
                    ETPassword.setText("");
                    Toast.makeText(getApplicationContext(),"Isi Username atau Password",Toast.LENGTH_LONG).show();
//                    Snackbar snackbar = Snackbar
//                            .make(findViewById(android.R.id.content), "Isi Username atau Password ", Snackbar.LENGTH_LONG);
//
//                    snackbar.show();
                }
                else {
                    ETUsername.setText("");
                    ETPassword.setText("");
                    Toast.makeText(getApplicationContext(),"Akun berhasil didaftarkan",Toast.LENGTH_LONG).show();
                    db.addContact(new User(10, txtUsername, txtPassword));
//
//                    Snackbar snackbar = Snackbar
//                            .make(findViewById(android.R.id.content), "Akun sudah terdaftar", Snackbar.LENGTH_LONG).setAction("Login", new View.OnClickListener() {
//                                @Override
//                                public void onClick(View view) {
//                                 //   Snackbar.make(getView(), "CheckIn Cancelled", Snackbar.LENGTH_SHORT).show();
//                                }
//                            });
//
//                    snackbar.show();

                }

                // Do something in response to button click
            }
        });

    }
    public void click(View v) {
        Intent intent = null;
        switch(v.getId()) {
            case R.id.tLoginKembali: // R.id.textView1
                intent = new Intent(this, Autentikasi.class);
                break;
//            case R.id.complain: // R.id.textView2
//                intent = new Intent(this, Third.class);
//                break;
//            case R.id.feed: // R.id.textView3
//                intent = new Intent();
        }
        startActivity(intent);
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}










