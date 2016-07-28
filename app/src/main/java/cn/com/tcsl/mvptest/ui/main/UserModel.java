package cn.com.tcsl.mvptest.ui.main;


import android.util.SparseArray;

import cn.com.tcsl.mvptest.bean.UserBean;
import cn.com.tcsl.mvptest.ui.main.IUserModel;

public class UserModel implements IUserModel {

    private String mFristName;
    private String mLastName;
    private int mID;
    private SparseArray<UserBean> mUsererArray = new SparseArray<UserBean>();

    @Override
    public void setID(int id) {
        mID = id;
    }

    @Override
    public void setFirstName(String firstName) {
        mFristName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        mLastName = lastName;
        UserBean UserBean = new UserBean(mFristName, mLastName);
        mUsererArray.append(mID, UserBean);
    }


    @Override
    public UserBean load(int id) {
        mID = id;
        UserBean userBean = mUsererArray.get(mID, new UserBean("not found",
                "not found"));
        return userBean;

    }

}
