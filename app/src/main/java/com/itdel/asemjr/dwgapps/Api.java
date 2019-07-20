package com.itdel.asemjr.dwgapps;

/**
 * Created by asemJr on 7/11/2019.
 */
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by Belal on 10/2/2017.
 */

public interface Api {

    String BASE_URL = "https://oob.mandiriwhatthehack.com/api/";
    String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoYWNrYXRvblVzZXIiLCJzY29wZXMiOiJBRE1JTiIsIm5leHQiOiJLWUMiLCJpYXQiOjE1NjM1ODExMTcsImV4cCI6MTU2NDQ0NTExN30.Kd2DyPPwHmjZkeXC-yjdepk9-DuALYL5gemWdgr19BC1x_tnJglEFFNWYu24cua-miAEiP3dB-1UrBbWkr2ywA";
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("getBranch")
    Call<List<Hero>> getHeroes(@Header("Authorization") String auth);
//
//    @GET("create")
//    Call<List<Hero>> createHeroes(@Field("name") String employee_name,
//                                  @Field("salary") String employee_salary,
//                                  @Field("age") long employee_age);
}
