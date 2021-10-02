package com.longtraidep.androidtest.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface StudentAPI {
    //API: https://613394787859e700176a3755.mockapi.io/api/student/        Student

    StudentAPI studentAPI = new Retrofit.Builder()
            .baseUrl("https://613394787859e700176a3755.mockapi.io/api/student/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentAPI.class);

    @GET("Student")
    Call<List<Student>> getAllStudent();

    @GET("Student/{id}")
    Call<Student> getStudentById(@Path("id") int studentId);

    //Setup this method
    @POST("Student")
    Call<Student> postStudent(@Body Student student);

    @PUT("Student/{id}")
    Call<Student> updateStudent(@Path("id") int studentId, @Body Student student);

}
