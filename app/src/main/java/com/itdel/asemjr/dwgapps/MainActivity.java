package com.itdel.asemjr.dwgapps;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import android.widget.ArrayAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//    public static final int MESSAGE_STATE_CHANGE = 1;
//    public static final int MESSAGE_READ = 2;
//    public static final int MESSAGE_WRITE = 3;
//    public static final int MESSAGE_DEVICE_NAME = 4;
//    public static final int MESSAGE_TOAST = 5;
//    public static final String DEVICE_NAME = "device_name";
//    public static final String TOAST = "toast";
//    private static final int REQUEST_CONNECT_DEVICE = 1;
//    private static final int REQUEST_ENABLE_BT = 2;
//    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    private String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;
    private static String url = "http://api.androidhive.info/contacts/";


    ListView listView;
    ArrayList<HashMap<String, String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);








































































        //









        //
//        mBluetoothAdapter.enable();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView tv;

        Button ConnectDevice = (Button)findViewById(R.id.buttonConnectDevice);
        ConnectDevice.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent IDevice = new Intent(getApplicationContext(),DeviceListActivity.class);
                startActivity(IDevice);
            }
        });

        Button AturAir = (Button)findViewById(R.id.aturAir);
        AturAir.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent IAturAir = new Intent(getApplicationContext(),ManajemenAir.class);
                startActivity(IAturAir);
            }
        });
        Button InfoAir = (Button)findViewById(R.id.informasiAir);
        InfoAir.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent IInformasi = new Intent(getApplicationContext(),Informasi.class);
                startActivity(IInformasi);
            }
        });
        setSupportActionBar(toolbar);
        DBHandler db = new DBHandler(this);
        Log.d("Insert: ", "Inserting ..");

        Log.d("Reading: ", "Reading all contacts..");
        List<User> contacts = db.getAllContacts();
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//        View headerView = navigationView.getHeaderView(0);
//        TextView name = (TextView) headerView.findViewById(R.id.name);
//        TextView email = (TextView) headerView.findViewById(R.id.email);
//
//
//        Autentikasi auth = new Autentikasi();
//        name.setText("Novalin");
//        email.setText("if315020@Students.del.ac.id");

    }























    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        TextView acc = (TextView) findViewById(R.id.name);
        acc.setText("Novalin");

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Keluar){
            finish();
            System.exit(0);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.PengaturanAkun) {

            Intent IPengaturanAkun = new Intent(getApplicationContext(), PengaturanAkun.class);
            startActivity(IPengaturanAkun);
        }


        else if (id == R.id.Tentang) {

            Intent ITentang = new Intent(getApplicationContext(),CustomRecyclerViewScrollActivity.class);
            startActivity(ITentang);
        }

        else if (id == R.id.Keluar) {

            Intent ILogin = new Intent(getApplicationContext(),Autentikasi.class);
            startActivity(ILogin);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
