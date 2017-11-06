package com.example.materialtest.fruit;

import com.example.materialtest.R;

/**
 * FruitInteractorImpl
 *
 * @author ALion on 2017/6/28 20:24
 */

public class FruitInteractorImpl implements FruitInteractor{

    @Override
    public void findData(final String fruitName, final OnFinishedListener listener) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//
//                    listener.onFinished(generateContentId(fruitName));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
        listener.onFinished(generateContentId(fruitName));
    }

    private int generateContentId(String fruitName) {
        int stringId = 0;
        switch (fruitName) {
            case "Watermelon":
                stringId = R.string.watermelon;
                break;
            case "Banana":
                stringId = R.string.banana;
                break;
            case "Cherry":
                stringId = R.string.cherry;
                break;
            case "Apple":
                stringId = R.string.apple;
                break;
            case "Orange":
                stringId = R.string.orange;
                break;
            case "Strawberry":
                stringId = R.string.strawberry;
                break;
            case "Pineapple":
                stringId = R.string.pineapple;
                break;
            case "Mango":
                stringId = R.string.mango;
                break;
            case "Pear":
                stringId = R.string.pear;
                break;
            case "Grape":
                stringId = R.string.grape;
                break;
        }

        return stringId;
    }

}
