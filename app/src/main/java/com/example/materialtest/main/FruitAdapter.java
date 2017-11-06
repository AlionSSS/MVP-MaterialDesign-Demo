package com.example.materialtest.main;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.materialtest.bean.FruitBean;
import com.example.materialtest.fruit.FruitActivity;
import com.example.materialtest.global.Keys;
import com.example.materialtest.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 水果列表Adapter
 *
 * @author ALion
 * @version 2017/4/21 16:23
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private Context mContext;
    private Activity activity;

    private ArrayList<FruitBean> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivFruit;
        private final CardView cardView;
        private final TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            ivFruit = (ImageView) itemView.findViewById(R.id.iv_fruit);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

    public void setData(ArrayList<FruitBean> fruitList) {
        mFruitList = fruitList;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void removeItem(int position) {
        if (position >= mFruitList.size()) return;
        mFruitList.remove(position);
        notifyItemRemoved(position);
    }

    public void changeItem(int position) {
        if (position >= mFruitList.size()) return;
        mFruitList.get(position).setName("呵呵哒");
        notifyItemChanged(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fruit, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (mFruitList == null || mFruitList.isEmpty()) {
            return;
        }

        FruitBean fruit = mFruitList.get(position);
        holder.tvName.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(holder.ivFruit);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FruitBean clickedFruit = mFruitList.get(holder.getAdapterPosition());
                Intent intent = new Intent(mContext, FruitActivity.class);
                intent.putExtra(Keys.FRUIT_NAME, clickedFruit.getName());
                intent.putExtra(Keys.FRUIT_IMAGE_ID, clickedFruit.getImageId());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    String transitionName = activity.getString(R.string.fruitTransitionName);
                    mContext.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                            activity, holder.cardView, transitionName).toBundle());
                } else {
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFruitList == null ? 0 : mFruitList.size();
    }

}
