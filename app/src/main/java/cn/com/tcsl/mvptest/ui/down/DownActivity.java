package cn.com.tcsl.mvptest.ui.down;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.tcsl.mvptest.R;
import cn.com.tcsl.mvptest.base.BaseActivity;

/**
 * Created by wjx on 2016/7/23.
 */
public class DownActivity extends BaseActivity<DownContract.Presenter> implements DownContract.View {
    @BindView(R.id.btn_down)
    Button btnDown;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        mPresenter = new DownPresenter(this);
        mPresenter.start();
    }

    @Override
    public void updateProgress(int progress) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismisProgress() {

    }
    /**
     * 安装apk
     * @param file
     */
    @Override
    public void intallAPK(File file) {
        Uri uri=Uri.fromFile(file);
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri,"application/vnd.android.package-archive");
        startActivity(intent);
    }

    @OnClick(R.id.btn_down)
    public void onClick() {
        mPresenter.downLoad("");
    }
}
