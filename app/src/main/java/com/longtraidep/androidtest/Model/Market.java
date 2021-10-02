package com.longtraidep.androidtest.Model;

import com.google.gson.annotations.SerializedName;
import com.longtraidep.androidtest.Model.Crypto;

import java.util.List;

public class Market {
    @SerializedName(value = "Crypto")
    private List<Crypto> mCryptos;
    @SerializedName(value = "Amount")
    private int amount;
    @SerializedName(value = "Trend")
    private String trend;

    public Market() {}

    public Market(List<Crypto> cryptos, int amount, String trend) {
        mCryptos = cryptos;
        this.amount = amount;
        this.trend = trend;
    }

    public List<Crypto> getCryptos() {
        return mCryptos;
    }

    public void setCryptos(List<Crypto> cryptos) {
        mCryptos = cryptos;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTrend() {
        return trend;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }

    @Override
    public String toString() {
        return "Market{" +
                "mCryptos=" + mCryptos.size() +
                ", amount=" + amount +
                ", trend='" + trend + '\'' +
                '}';
    }
}
