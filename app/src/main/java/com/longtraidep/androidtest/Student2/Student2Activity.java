package com.longtraidep.androidtest.Student2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.longtraidep.androidtest.R;
import com.longtraidep.androidtest.Student.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Student2Activity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnGetAll, mBtnGetById;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student2);

        mBtnGetAll = (Button) findViewById(R.id.btn_get_all2);
        mBtnGetById = (Button) findViewById(R.id.btn_get_by_id2);

        mBtnGetById.setOnClickListener(this);
        mBtnGetAll.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_get_all2:
                getAllStudent2();
                break;
            case R.id.btn_get_by_id2:
                getStudent2ById();
                break;
        }
    }

    public void getAllStudent2()
    {
        StudentAPI2.studentAPI2.getAllStudent2().enqueue(new Callback<List<Student2>>() {
            @Override
            public void onResponse(Call<List<Student2>> call, Response<List<Student2>> response) {
                if (response.code() == 200)
                {
                    List<Student2> student2s = response.body();
                    for (Student2 student2 : student2s)
                    {
                        Log.i("student2", student2.toString());
                    }
                }
                else {
                    Log.i("student2 err", "Err");
                }
            }

            @Override
            public void onFailure(Call<List<Student2>> call, Throwable t) {
                Log.i("student2 err2", t.getMessage());
            }
        });
    }

    public void getStudent2ById()
    {
        StudentAPI2.studentAPI2.getStudent2ById(8L).enqueue(new Callback<Student2>() {
            @Override
            public void onResponse(Call<Student2> call, Response<Student2> response) {
                if (response.code() == 200)
                {
                    Student2 student2 = response.body();
                    Log.i("student2 id", student2.toString());
                }
                else {
                    Log.i("student2 err2 byId", "Err");
                }
            }

            @Override
            public void onFailure(Call<Student2> call, Throwable t) {
                Log.i("student2 err2 byId", t.getMessage());
            }
        });
    }
}

