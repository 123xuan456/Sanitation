package com.reeching.sanitation.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.reeching.sanitation.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 基础数据平台-业务监察科-基础数据-修改数据
 */
public class Ins_ItemActivity extends AppCompatActivity {

    @Bind(R.id.top_finish)
    ImageView topFinish;
    @Bind(R.id.top_name)
    TextView topName;
    @Bind(R.id.approve)
    Button approve;
    @Bind(R.id.audit_failure)
    Button auditFailure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins__item);
        ButterKnife.bind(this);
        topName.setText("数据详情");

    }

    @OnClick({R.id.top_finish, R.id.approve, R.id.audit_failure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_finish:
                finish();
                break;
            //审核通过
            case R.id.approve:


                break;
            //审核不通过
            case R.id.audit_failure:
                break;
        }
    }

}
