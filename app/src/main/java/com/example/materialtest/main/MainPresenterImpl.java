package com.example.materialtest.main;

import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;

import com.example.materialtest.bean.FruitBean;
import com.example.materialtest.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Main Presenter
 *
 * @author ALion
 * @version 2017/6/26 16:29
 */

public class MainPresenterImpl implements Main.Presenter {

    private Main.View mainView;
    private MainInteractor mainInteractor;

    public MainPresenterImpl(@NonNull Main.View mainView) {
        this.mainView = mainView;
        this.mainInteractor = new MainInteractorImpl();
    }

    @Override
    public void start() {
        ArrayList<FruitBean> cache = getCache();
        if (cache != null) {
            mainView.setData(cache);//显示到界面
        }

        boolean isHaveNet = true;
        if (isHaveNet) {//是否有网
            startRequest();
        } else {
            mainView.showToast("抱歉，没有网络");
        }
    }

    /**
     * 获取缓存
     */
    private ArrayList<FruitBean> getCache() {
        ArrayList<FruitBean> fruitList = null;
        boolean deadline = false;
        if (!deadline) {//如果没超过cache的截止期限
            fruitList = new MainInteractorImpl().getData();//模拟从数据库获取缓存数据
        }
        return fruitList;
    }

    /**
     * 开始网络请求
     */
    private void startRequest() {
        mainView.showRefreshing(true);
        mainInteractor.findData(new MainInteractor.OnFinishedListener() {
            @Override
            public void onFinished(ArrayList<FruitBean> data) {
                mainView.setData(data);
                mainView.showRefreshing(false);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mainView.showDrawer(false);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabtn:
                mainView.showSnackbar(v);
                break;
        }
    }

    @Override
    public void onRefresh() {
        startRequest();
    }

    @Override
    public void onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mainView.showDrawer(true);
                break;
            case R.id.backup:
                mainView.showToast("You clicked Backup");
                break;
            case R.id.delete:
                int i = new Random().nextInt(5);
                mainView.removeItem(i);
                mainView.showToast("删除了第" + (i + 1) + "个条目");
                break;
            case R.id.setting:
                mainView.showToast("You clicked Setting");
                break;
        }
    }

}
