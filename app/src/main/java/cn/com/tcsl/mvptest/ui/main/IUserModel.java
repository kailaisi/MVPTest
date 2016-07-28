package cn.com.tcsl.mvptest.ui.main;

import cn.com.tcsl.mvptest.bean.UserBean;

/**
 * Created by wjx on 2016/7/1 0001.
 */
public interface IUserModel {
    void setID (int id);
    void setFirstName (String firstName);
    void setLastName (String lastName);
    UserBean load (int id);//通过id读取user信息,返回一个UserBean
}
