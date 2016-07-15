package cn.com.tcsl.mvptest.View;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public interface IUserView {
    int getID();
    String getFirstName();
    String getLastName();
    void setFirstName(String firstName);
    void setLastName(String lastName);
}
