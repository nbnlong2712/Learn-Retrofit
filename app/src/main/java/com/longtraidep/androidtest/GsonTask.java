package com.longtraidep.androidtest;

import android.content.Context;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.google.gson.Gson;
import com.longtraidep.androidtest.Model.Market;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import cz.msebera.android.httpclient.Header;

public class GsonTask extends AsyncTaskLoader<Market> {
    public GsonTask(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public Market loadInBackground() {
        String url = "https://run.mocky.io/v3/d93713de-8467-4a74-ac88-b5a41ff99bae";
        Market market1 = new Market();
        SyncHttpClient syncHttpClient = new SyncHttpClient();
        Looper.prepare();
        syncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                setUseSynchronousMode(true);
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String json = new String(responseBody);

                Gson gson = new Gson();
                Market market = gson.fromJson(json, Market.class);
                market1.setAmount(market.getAmount());
                market1.setCryptos(market.getCryptos());
                market1.setTrend(market.getTrend());
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {}
        });
        return market1;
    }
}