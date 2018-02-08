package com.example.materialtest.fruit;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.materialtest.R;
import com.example.materialtest.global.Keys;

/**
 * 水果详细信息页面Activity
 *
 * @author ALion on 2017/4/22 15:23
 */
public class FruitActivity extends AppCompatActivity implements Fruit.View {

    private ImageView ivFruit;
    private TextView tvFruit;

    private String fruitName;
    private int fruitImageId;
    private Fruit.Presenter fruitPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        fruitName = getIntent().getStringExtra(Keys.FRUIT_NAME);
        fruitImageId = getIntent().getIntExtra(Keys.FRUIT_IMAGE_ID, 0);

        initView();

        fruitPresenter = new FruitPresenterImpl(this, fruitName);
        fruitPresenter.start();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(fruitName);
        ivFruit = (ImageView) findViewById(R.id.iv_fruit);
        tvFruit = (TextView) findViewById(R.id.tv_fruit);

        Glide.with(this).load(fruitImageId).into(ivFruit);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        fruitPresenter.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setContent(int resId) {
        tvFruit.setText(getResources().getString(resId != 0 ? resId : R.string.error));
    }

    @Override
    public void finishActivity() {
//        finish();
        onBackPressed();
    }

    private ProgressDialog dialog;

    @Override
    public void showProgressDialog(boolean show) {
        if (show) {
            if (dialog == null) {
                dialog = new ProgressDialog(FruitActivity.this);
            }
            dialog.setMessage("正在获取信息...");
            dialog.show();
        } else {
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

}
