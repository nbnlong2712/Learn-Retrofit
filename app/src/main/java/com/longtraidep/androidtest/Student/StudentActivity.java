package com.longtraidep.androidtest.Student;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.longtraidep.androidtest.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentActivity extends AppCompatActivity {

    private Button mBtnGetAll, mBtnGetById, mBtnPostStudent, mBtnUpdateStudent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        mBtnGetAll = (Button) findViewById(R.id.btn_get_all);
        mBtnGetById = (Button) findViewById(R.id.btn_get_by_id);
        mBtnPostStudent = (Button) findViewById(R.id.btn_post_student);
        mBtnUpdateStudent = (Button) findViewById(R.id.btn_update_student);

        mBtnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentAPI.studentAPI.getAllStudent().enqueue(new Callback<List<Student>>() {
                    @Override
                    public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                        List<Student> students = response.body();
                        Log.i("size", students.size() + "");

                        for (int i=0; i<students.size(); i++)
                        {
                            Log.i("Student", students.toString());
                        }
                    }
                    @Override
                    public void onFailure(Call<List<Student>> call, Throwable t) {
                        Log.i("errorrrrrrr", t.getMessage());
                    }
                });
            }
        });

        mBtnGetById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentAPI.studentAPI.getStudentById(1).enqueue(new Callback<Student>() {
                    @Override
                    public void onResponse(Call<Student> call, Response<Student> response) {
                        Student student = response.body();

                        Log.i("student id", student.getName() + ", " + student.getAvatar() + ", " + student.getId());
                    }
                    @Override
                    public void onFailure(Call<Student> call, Throwable t) {
                        Log.i("errorrrrrrr", t.getMessage());
                    }
                });
            }
        });

        mBtnPostStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student("Hanh", "avatar111");
                StudentAPI.studentAPI.postStudent(student).enqueue(new Callback<Student>() {
                    @Override
                    public void onResponse(Call<Student> call, Response<Student> response) {
                        Log.i("Successsssss", "yeah!!");
                    }
                    @Override
                    public void onFailure(Call<Student> call, Throwable t) {
                        Log.i("errorrrrrrr", t.getMessage());
                    }
                });
            }
        });

        mBtnUpdateStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student("Long", "avt1111");
                StudentAPI.studentAPI.updateStudent(1, student).enqueue(new Callback<Student>() {
                    @Override
                    public void onResponse(Call<Student> call, Response<Student> response) {
                        Log.i("Succestststs", "yeah!!");
                    }
                    @Override
                    public void onFailure(Call<Student> call, Throwable t) {}
                });
            }
        });
    }
}
