package com.example.materialtest.main;


import android.view.MenuItem;

import com.example.materialtest.bean.FruitBean;

import java.util.ArrayList;

/**
 * Main Interface
 *
 * @author ALion
 * @version 2017/6/26 16:32
 */

public interface Main {

    interface View {

        /**
         * 设置数据
         */
        void setData(ArrayList<FruitBean> fruitList);

        /**
         * 显示刷新的动画
         */
        void showRefreshing(boolean refreshing);

        /**
         * 打开、关闭导航抽屉
         */
        void showDrawer(boolean open);

        /**
         * 展示Snackbar
         */
        void showSnackbar(android.view.View view);

        /**
         * 显示Toast
         */
        void showToast(String msg);

        /**
         * 删除recyclerView的item
         */
        void removeItem(int position);

    }

    interface Presenter {

        /**
         * 开始业务
         */
        void start();

        /**
         * NavigationView的item被点击时调用
         */
        boolean onNavigationItemSelected(MenuItem item);

        /**
         * view被点击时调用
         */
        void onClick(android.view.View v);

        /**
         * 下拉刷新时调用
         */
        void onRefresh();

        /**
         * Actionbar的item被点击
         */
        void onOptionsItemSelected(MenuItem item);

    }
}
