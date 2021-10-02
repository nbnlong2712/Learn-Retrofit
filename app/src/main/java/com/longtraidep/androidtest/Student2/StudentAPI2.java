package com.longtraidep.androidtest.Student2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StudentAPI2 {
    //API: http://localhost:3000/api/list_student/

    //Thay localhost:3000 bằng địa chỉ IP của máy, sau đó điều chỉnh Port của webservice trùng với Port của IP của máy

    StudentAPI2 studentAPI2 = new Retrofit.Builder()
            .baseUrl("http://192.168.4.14/api/list_student/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentAPI2.class);

    @GET("getall")
    Call<List<Student2>> getAllStudent2();

    @GET("get/{id}")
    Call<Student2> getStudent2ById(@Path("id") Long id);
}
