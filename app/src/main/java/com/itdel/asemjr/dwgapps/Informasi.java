package com.itdel.asemjr.dwgapps;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asemJr on 2/12/2018.
 */

public class Informasi extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.informasi);
        Toolbar TManajemenAir = (Toolbar) findViewById(R.id.TManajemenAir);
        TManajemenAir.setTitle("Finance Monitor");
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS,
                WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS |
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        setSupportActionBar(TManajemenAir);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        Window w = getWindow();
//        w.setFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS,
//                WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS |
//                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        w.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
//        Toolbar TInformasi = (Toolbar) findViewById(R.id.TInformasi);
//        TInformasi.setTitle("Informasi");
//        setSupportActionBar (TInformasi);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//        listView = (ListView) findViewById(R.id.listViewHeroes);
        getHeroes();


    }

    private void getHeroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoYWNrYXRvblVzZXIiLCJzY29wZXMiOiJBRE1JTiIsIm5leHQiOiJLWUMiLCJpYXQiOjE1NjM1ODExMTcsImV4cCI6MTU2NDQ0NTExN30.Kd2DyPPwHmjZkeXC-yjdepk9-DuALYL5gemWdgr19BC1x_tnJglEFFNWYu24cua-miAEiP3dB-1UrBbWkr2ywA";
        Call<List<Hero>> call = api.getHeroes("Bearer "+token);

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroList = response.body();

                //Creating an String array for the ListView
                String[] heroes = new String[heroList.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = "Name :"+heroList.get(i).getName();
                }


                //displaying the string array into listview
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
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
