package cn.com.tcsl.mvptest.presenter;

import cn.com.tcsl.mvptest.View.IUserView;
import cn.com.tcsl.mvptest.bean.UserBean;
import cn.com.tcsl.mvptest.model.IUserModel;
import cn.com.tcsl.mvptest.model.UserModel;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class UserPresenter {
    private IUserModel mUserModel;
    private IUserView mUserView;


    public UserPresenter(IUserView mUserView) {
        this.mUserView = mUserView;
        mUserModel=new UserModel();
    }

    public void saveUser(int id,String firstName,String lastName){
        mUserModel.setID(id);
        mUserModel.setFirstName(firstName);
        mUserModel.setLastName(lastName);
    }

    public void loadUser(int id){
        UserBean user=mUserModel.load(id);
        mUserView.setFirstName(user.getmFirstName());//通过调用IUserView的方法更新显示
        mUserView.setLastName(user.getmLastName());
    }

}
