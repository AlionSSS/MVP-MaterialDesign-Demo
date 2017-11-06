package com.example.materialtest.fruit;

import android.view.MenuItem;

/**
 * Fruit Presenter
 *
 * @author ALion on 2017/6/28 20:07
 */

public class FruitPresenterImpl implements Fruit.Presenter{

    private Fruit.View fruitView;
    private FruitInteractor fruitInteractor;

    private String fruitName;

    public FruitPresenterImpl(Fruit.View fruitView, Object... objects) {
        this.fruitView = fruitView;
        this.fruitInteractor = new FruitInteractorImpl();

        fruitName = (String) objects[0];
    }

    @Override
    public void start() {
        fruitView.showProgressDialog(true);
        fruitInteractor.findData(fruitName, new FruitInteractor.OnFinishedListener() {
            @Override
            public void onFinished(int resId) {
                fruitView.setContent(resId);
                fruitView.showProgressDialog(false);
            }
        });

    }

    @Override
    public void onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                fruitView.finishActivity();
                break;
        }
    }

}
