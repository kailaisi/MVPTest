package cn.com.tcsl.mvptest.ui.down;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import cn.com.tcsl.mvptest.base.BaseModel;
import cn.com.tcsl.mvptest.base.BasePresenter;
import cn.com.tcsl.mvptest.base.BaseView;

/**
 * Created by wjx on 2016/7/23.
 */
public interface DownContract {
    interface View extends BaseView{
        /**
         * 更新进度
         * @param progress 进度数据
         */
        void updateProgress(int progress);

        /**
         * 显示对话框
         */
        void showProgress();

        /**
         * 关闭对话框
         */
        void dismisProgress();

        /**
         * 安装apk
         * @param file apk位置
         */
        void intallAPK(File file);
    }


    interface Model extends BaseModel{
        /**
         * 将文件进行保存,
         * @param inputStream 输入流
         * @return 保存的文件
         */
        File writeToSD(InputStream inputStream);
    }

    interface Presenter extends BasePresenter{
        void downLoad(String url);
    }
}
