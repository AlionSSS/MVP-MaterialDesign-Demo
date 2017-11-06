package com.example.materialtest.main;

import com.example.materialtest.bean.FruitBean;

import java.util.ArrayList;

/**
 * Main FruitInteractor
 *
 * @author ALion
 * @version 2017/6/28 19:15
 */

public interface MainInteractor {

    interface OnFinishedListener {
        void onFinished(ArrayList<FruitBean> data);
    }

    /**
     * 查找数据
     * @param listener 查找结束后的回调
     */
    void findData(OnFinishedListener listener);

}
