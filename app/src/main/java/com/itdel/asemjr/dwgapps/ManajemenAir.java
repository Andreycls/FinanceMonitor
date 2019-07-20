package com.itdel.asemjr.dwgapps;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
/**
 * Created by asemJr on 2/2/2018.
 */

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;


public class ManajemenAir extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//       final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.manajemen_air);
        Toolbar TManajemenAir = (Toolbar) findViewById(R.id.TManajemenAir);
        TManajemenAir.setTitle("Atur Air");
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS,
                WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS |
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        setSupportActionBar(TManajemenAir);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        final Switch SwitchAturKeran = (Switch) findViewById(R.id.SwitchAturKeran);



//        SwitchAturKeran.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View view) {
//                if (SwitchAturKeran.isChecked()){
//
//                    mBluetoothAdapter.enable();
//                    Snackbar snackbar = Snackbar
//                            .make(findViewById(android.R.id.content), "Keran sudah hidup", Snackbar.LENGTH_LONG);
//
//                    snackbar.show();
//                    int StatusAir = 1;
//                }
//                else if (!SwitchAturKeran.isChecked()){
//                    mBluetoothAdapter.disable();
//                    Snackbar snackbar = Snackbar
//                            .make(findViewById(android.R.id.content), "Keran sudah mati", Snackbar.LENGTH_LONG);
//
//                    snackbar.show();
//
//                    int StatusAir = 0;
//                }
//
//
//            }});



        Button setAir = (Button) findViewById(R.id.BsetAtur);
        setAir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText inputTime = (EditText) findViewById(R.id.inputTIme);
                String Time = inputTime.getText().toString();
                Switch SwitchAturKeran = (Switch) findViewById(R.id.SwitchAturKeran);

                if (Time.matches("") || !SwitchAturKeran.isChecked()) {
                    Snackbar snackbar = Snackbar
                            .make(findViewById(android.R.id.content), "Keran belum hidup atau Volume belum diisi", Snackbar.LENGTH_LONG);

                    snackbar.show();


                }
                else {
                    Snackbar snackbar = Snackbar
                            .make(findViewById(android.R.id.content), "Keran sudah di set", Snackbar.LENGTH_LONG);

                    snackbar.show();

                }

                // Do something in response to button click
            }
        });




    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}










