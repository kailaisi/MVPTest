package cn.com.tcsl.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.com.tcsl.mvptest.View.IUserView;
import cn.com.tcsl.mvptest.presenter.UserPresenter;

public class MainActivity extends AppCompatActivity implements IUserView {
    private EditText mEtId;
    private EditText mEtFirstName;
    private EditText mEtLastName;
    private Button mBtnLoad;
    private Button mBtnSave;
    private UserPresenter mUserPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtId = (EditText) findViewById(R.id.et_id);
        mEtFirstName = (EditText) findViewById(R.id.et_first_name);
        mEtLastName = (EditText) findViewById(R.id.et_last_name);
        mBtnLoad = (Button) findViewById(R.id.btnLoad);
        mBtnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserPresenter.loadUser(getID());
            }
        });
        mBtnSave = (Button) findViewById(R.id.btnSave);
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserPresenter.saveUser(getID(), getFirstName(), getLastName());
            }
        });
        mUserPresenter = new UserPresenter(this);
    }

    @Override
    public int getID() {
        return Integer.parseInt(mEtId.getText().toString());
    }

    @Override
    public String getFirstName() {
        return mEtFirstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return mEtLastName.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        mEtFirstName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        mEtLastName.setText(lastName);
    }
}
