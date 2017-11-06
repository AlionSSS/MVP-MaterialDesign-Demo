package com.example.materialtest.main;

import com.example.materialtest.R;
import com.example.materialtest.bean.FruitBean;

import java.util.ArrayList;
import java.util.Random;

/**
 * MainInteractorImpl
 *
 * @author ALion
 * @version 2017/6/26 16:39
 */

public class MainInteractorImpl implements MainInteractor {

    @Override
    public void findData(final OnFinishedListener listener) {
        //耗时操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    ArrayList<FruitBean> data = getData();

                    //获取到数据后回调
                    listener.onFinished(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private FruitBean[] fruits = {
            new FruitBean("Apple", R.drawable.apple), new FruitBean("Banana", R.drawable.banana),
            new FruitBean("Orange", R.drawable.orange), new FruitBean("Watermelon", R.drawable.watermelon),
            new FruitBean("Pineapple", R.drawable.pineapple), new FruitBean("Strawberry", R.drawable.strawberry),
            new FruitBean("Cherry", R.drawable.cherry), new FruitBean("Mango", R.drawable.mango),
            new FruitBean("Pear", R.drawable.pear), new FruitBean("Grape", R.drawable.grape)};

    /**
     * 生成随机数据
     */
    public ArrayList<FruitBean> getData() {
        ArrayList<FruitBean> fruitList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
        return fruitList;
    }
}
