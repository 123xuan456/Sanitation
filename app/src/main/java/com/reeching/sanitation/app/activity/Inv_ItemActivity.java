package com.reeching.sanitation.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiangyy.easydialog.InputDialog;
import com.reeching.sanitation.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 业务监察科-待审核数据-审核提交
 */
public class Inv_ItemActivity extends AppCompatActivity {

    @Bind(R.id.top_finish)
    ImageView topFinish;
    @Bind(R.id.top_name)
    TextView topName;
    @Bind(R.id.inv_verified)
    Button invVerified;
    @Bind(R.id.inv_non_approval)
    Button invNonApproval;
    @Bind(R.id.linearLayout)
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inv__item);
        ButterKnife.bind(this);
        topName.setText("审核详情");
    }

    @OnClick({R.id.top_finish, R.id.inv_verified, R.id.inv_non_approval})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_finish:
                finish();
                break;
            case R.id.inv_verified:

                break;
            case R.id.inv_non_approval:
                new InputDialog.Builder(this)
                        .setTitle("请输入审核不通过原因")
                        .setHint("提示内容！！！")
                        .setLines(5)
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(Inv_ItemActivity.this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("取消", null).show();
                break;
        }
    }
}
