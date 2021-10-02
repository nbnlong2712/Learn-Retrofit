package com.longtraidep.androidtest;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.longtraidep.androidtest.Model.Price;

import java.util.List;

public class PriceAdapter extends RecyclerView.Adapter<PriceAdapter.PriceHolder> {
    List<Price> mPriceList;
    public OnChangePriceListener mOnChangePriceListener;

    public PriceAdapter()
    {

    }

    public void setData(List<Price> prices)
    {
        mPriceList = prices;
        notifyDataSetChanged();
    }

    public void setOnChangePriceListener(OnChangePriceListener onChangePriceListener) {
        mOnChangePriceListener = onChangePriceListener;
    }

    @NonNull
    @Override
    public PriceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_edt, parent, false);
        return new PriceHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PriceHolder holder, int position) {
        Price price = mPriceList.get(position);
        holder.mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (holder.mEditText.getText().toString().isEmpty()){
                    price.setPrice(0);
                    holder.mEditText.setText("0");
                }
                else {
                    price.setPrice(Long.parseLong(holder.mEditText.getText().toString()));
                }
                mOnChangePriceListener.onPriceChange(position, price.getPrice());
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    @Override
    public int getItemCount() {
        if (mPriceList != null)
            return mPriceList.size();
        return 0;
    }

    public class PriceHolder extends RecyclerView.ViewHolder{
        EditText mEditText;

        public PriceHolder(@NonNull View itemView) {
            super(itemView);

            mEditText = (EditText) itemView.findViewById(R.id.edt);
        }
    }
}
