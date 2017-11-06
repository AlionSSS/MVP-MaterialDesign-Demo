package com.example.materialtest.fruit;

/**
 * Created by Administrator on 2017/6/28.
 *
 * @author ALion on 2017/6/28 20:27
 */

public interface FruitInteractor {

    interface OnFinishedListener {
        void onFinished(int resId);
    }

    /**
     * 查找数据
     * @param listener 查找结束后的回调
     */
    void findData(String fruitName, OnFinishedListener listener);
}
