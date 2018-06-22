package com.reeching.sanitation.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.jiangyy.easydialog.InputDialog;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.App;
import com.reeching.sanitation.app.bean.RoadDetailBean;
import com.reeching.sanitation.app.component.DaggerActivityComponent;
import com.reeching.sanitation.app.contract.DetailsRoadContract;
import com.reeching.sanitation.app.presenter.DetailsRoadPresenter;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;
import com.reeching.sanitation.app.util.ToastUtil;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.reeching.sanitation.R.id.add_areaType;
import static com.reeching.sanitation.R.id.add_road_4;

/**
 * 道路详情
 */
public class DetailsRoadActivity extends AppCompatActivity implements DetailsRoadContract.View {
    @Inject
    DetailsRoadPresenter detailsRoadPresenter;
    String id;
    @Bind(R.id.top_finish)
    ImageView topFinish;
    @Bind(R.id.top_name)
    TextView topName;
    @Bind(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @Bind(R.id.add_road_1)
    EditText addRoad1;
    @Bind(R.id.textView27)
    TextView textView27;
    @Bind(R.id.add_road_2)
    EditText addRoad2;
    @Bind(R.id.add_road_3)
    EditText addRoad3;
    @Bind(add_road_4)
    TextView addRoad4;
    @Bind(R.id.add_road_5)
    Spinner addRoad5;
    @Bind(add_areaType)
    Spinner addAreaType;
    @Bind(R.id.add_road_6)
    EditText addRoad6;
    @Bind(R.id.add_road_7)
    EditText addRoad7;
    @Bind(R.id.add_road_8)
    EditText addRoad8;
    @Bind(R.id.add_road_9)
    TextView addRoad9;
    @Bind(R.id.add_road_10)
    TextView addRoad10;
    @Bind(R.id.add_road_11)
    TextView addRoad11;
    @Bind(R.id.add_road_12)
    TextView addRoad12;
    @Bind(R.id.add_road_13)
    TextView addRoad13;
    @Bind(R.id.add_road_14)
    TextView addRoad14;
    @Bind(R.id.add_road_15)
    TextView addRoad15;
    @Bind(R.id.add_road_company)
    Spinner addRoadCompany;
    @Bind(R.id.add_road_16)
    Spinner addRoad16;
    @Bind(R.id.add_road_17)
    EditText addRoad17;
    @Bind(R.id.add_road_18)
    EditText addRoad18;
    @Bind(R.id.add_road_19)
    EditText addRoad19;
    @Bind(R.id.add_road_20)
    EditText addRoad20;
    @Bind(R.id.add_road_21)
    TextView addRoad21;
    @Bind(R.id.add_road_22)
    TextView addRoad22;
    @Bind(R.id.add_road_23)
    EditText addRoad23;
    @Bind(R.id.add_road_24)
    EditText addRoad24;
    @Bind(R.id.add_road_orderNo)
    EditText addRoadOrderNo;
    @Bind(R.id.add_road_25)
    EditText addRoad25;
    @Bind(R.id.add_road_26)
    EditText addRoad26;
    @Bind(R.id.add_road_27)
    EditText addRoad27;
    @Bind(R.id.audit_status)
    EditText auditStatus;
    @Bind(R.id.approve)
    Button approve;
    @Bind(R.id.audit_failure)
    Button auditFailure;
    @Bind(R.id.add_road_4Tv)
    TextView add_road_4Tv;
    @Bind(R.id.add_road_5Tv)
    TextView add_road_5Tv;
    @Bind(R.id.add_areaTypeTv)
    TextView add_areaTypeTv;
    @Bind(R.id.add_road_companyTv)
    TextView add_road_companyTv;
    @Bind(R.id.add_road_16Tv)
    TextView add_road_16Tv;
    @Bind(R.id.details_road)
    LinearLayout details_road;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_road);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("id");
        DaggerActivityComponent.builder()
                .appComponent(App.getsInstance().getAppComponent())
                .build()
                .inject(this);

        initData();
    }

    private void initData() {
        topName.setText("道路详情");
        detailsRoadPresenter.attachView(this);
        detailsRoadPresenter.getRoadDetails(id);
        userId = SharedPreferencesUtil.getInstance().getString("userId");
        String roleName = SharedPreferencesUtil.getInstance().getString("roleName");
        if ("基层角色".equals(roleName)){
            details_road.setVisibility(View.GONE);
            auditStatus.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.top_finish, R.id.approve, R.id.audit_failure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_finish:
                finish();
                break;
            case R.id.approve:
                detailsRoadPresenter.getApprove(id, userId);
                break;
            case R.id.audit_failure:
                new InputDialog.Builder(this)
                        .setTitle("请输入审核不通过原因")
                        .setHint("提示内容！！！")
                        .setLines(5)
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                Toast.makeText(DetailsRoadActivity.this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
                                detailsRoadPresenter.getAuditFailure(id, userId, view.getTag().toString());
                            }
                        }).setNegativeButton("取消", null).show();
                break;
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void showRoadDetail(RoadDetailBean data) {
        RoadDetailBean.InfosBean infosBean = data.getInfos();
        String statusName = infosBean.getAuditStatusName();
        if (statusName.equals("审核完成")){
            details_road.setVisibility(View.GONE);
            auditStatus.setVisibility(View.GONE);
        }
        addRoad1.setFocusable(false);
        addRoad2.setFocusable(false);
        addRoad3.setFocusable(false);
        addRoad6.setFocusable(false);
        addRoad7.setFocusable(false);
        addRoad8.setFocusable(false);
        addRoad16.setFocusable(false);
        addRoad17.setFocusable(false);
        addRoad18.setFocusable(false);
        addRoad19.setFocusable(false);
        addRoad20.setFocusable(false);
        addRoad23.setFocusable(false);
        addRoad24.setFocusable(false);
        addRoad25.setFocusable(false);
        addRoad26.setFocusable(false);
        addRoad27.setFocusable(false);
        addRoadOrderNo.setFocusable(false);
        addRoad1.setText(infosBean.getMarkNo());
        addRoad2.setText(infosBean.getBranchesNo());
        addRoad3.setText(infosBean.getStreetName());
        addRoad7.setText(infosBean.getStreetStart());
        addRoad8.setText(infosBean.getStreetEnd());
        addRoad9.setText(infosBean.getLeaderName());
        addRoad10.setText(infosBean.getFieldTeamName());
        addRoad11.setText(infosBean.getFieldTeamManagerName());
        addRoad12.setText(infosBean.getFieldUnitName());
        addRoad13.setText(infosBean.getFieldUnitManagerName());
        addRoad14.setText(infosBean.getWorkTeamName());
        addRoad15.setText(infosBean.getWorkTeamManagerName());
        addRoad17.setText(infosBean.getSegmentNo());
        addRoad18.setText(infosBean.getStreetSegment());
        addRoad19.setText(infosBean.getMinStreetStart());
        addRoad20.setText(infosBean.getMaxStreetEnd());
        addRoad21.setText(infosBean.getBelongStreetName());
        addRoad22.setText(infosBean.getBelongCommunityName());
        addRoad23.setText(infosBean.getBelongGrid());
        addRoad24.setText(infosBean.getSimpleNo());
        addRoadOrderNo.setText(infosBean.getOrderNo());
        addRoad25.setText(infosBean.getCreateDate());
//        addRoad26.setText(infosBean.getd);
        addRoad27.setText(infosBean.getRemark());
        addRoad4.setVisibility(View.GONE);
        addRoad5.setVisibility(View.GONE);
        addRoad16.setVisibility(View.GONE);
        addAreaType.setVisibility(View.GONE);
        addRoadCompany.setVisibility(View.GONE);
        add_road_4Tv.setText(infosBean.getObjectKey());
        add_road_5Tv.setText(infosBean.getStreetLevelName());
        add_areaTypeTv.setText(infosBean.getAreaTypeName());
        add_road_companyTv.setText(infosBean.getCompanyTypeName());

        add_road_16Tv.setText(infosBean.getCompanyName());
    }

    @Override
    public void showApprove(String res) {
        if (res.equals("0")) {
            ToastUtil.showToast(DetailsRoadActivity.this, "失败");
        } else if (res.equals("1")) {
            ToastUtil.showToast(DetailsRoadActivity.this, "成功");
            finish();
        } else if (res.equals("2")) {
            ToastUtil.showToast(DetailsRoadActivity.this, "已存在");
        }
    }

    @Override
    public void showAuditFailure(String res) {
        if (res.equals("0")) {
            ToastUtil.showToast(DetailsRoadActivity.this, "失败");
        } else if (res.equals("1")) {
            ToastUtil.showToast(DetailsRoadActivity.this, "成功");
            finish();
        } else if (res.equals("2")) {
            ToastUtil.showToast(DetailsRoadActivity.this, "已存在");
        }

    }
}
