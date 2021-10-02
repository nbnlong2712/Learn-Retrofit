package com.longtraidep.androidtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.longtraidep.androidtest.Model.Market;
import com.longtraidep.androidtest.Model.Price;
import com.longtraidep.androidtest.Student.StudentActivity;
import com.longtraidep.androidtest.Student2.Student2Activity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Market> {
    private RecyclerView mRecyclerView;
    private TextView mTextView, mTextView1;
    private PriceAdapter mAdapter;
    private List<Price> mLongs;
    private ProgressDialog mPrdLogin;
    private Button mBtnStudent, mBtnStudent2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mLongs = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.rcv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTextView = (TextView) findViewById(R.id.tv_sum_price);
        mTextView1 = (TextView) findViewById(R.id.tv_gson);

        mBtnStudent = (Button) findViewById(R.id.btn_student);
        mBtnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StudentActivity.class));
            }
        });

        mBtnStudent2 = (Button) findViewById(R.id.btn_student2);
        mBtnStudent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Student2Activity.class));
            }
        });

        mAdapter = new PriceAdapter();

        mLongs.add(new Price(0));
        mLongs.add(new Price(0));
        mLongs.add(new Price(0));
        mLongs.add(new Price(0));
        mLongs.add(new Price(0));
        mLongs.add(new Price(0));
        mLongs.add(new Price(0));
        mLongs.add(new Price(0));

        mAdapter.setData(mLongs);
        mAdapter.setOnChangePriceListener(new OnChangePriceListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onPriceChange(int position, long value) {
                mLongs.get(position).setPrice(value);
                mTextView.setText(sum(mLongs) + "");
            }
        });
        mRecyclerView.setAdapter(mAdapter);

        LoaderManager.getInstance(this).initLoader(0, null, this);
    }

    public long sum(List<Price> list) {
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getPrice();
        }
        return sum;
    }

    // ----------     LOADER     ----------
    @NonNull
    @Override
    public Loader<Market> onCreateLoader(int id, @Nullable Bundle args) {
        mPrdLogin = new ProgressDialog(MainActivity.this);
        mPrdLogin.show();
        mPrdLogin.setContentView(R.layout.dialog);
        mPrdLogin.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        mPrdLogin.setCanceledOnTouchOutside(false);
        return new GsonTask(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Market> loader, Market data) {
        mPrdLogin.dismiss();
        Log.i("Loader test", data.toString());
        mTextView1.setText(data.toString());
    }


    @Override
    public void onLoaderReset(@NonNull Loader<Market> loader) {

    }
}