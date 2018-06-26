package com.reeching.sanitation.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.jiangyy.easydialog.InputDialog;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.App;
import com.reeching.sanitation.app.adapter.PaymentdetailsGridAdapter;
import com.reeching.sanitation.app.bean.WasteDetailBean;
import com.reeching.sanitation.app.component.DaggerActivityComponent;
import com.reeching.sanitation.app.contract.DetailsWasteContract;
import com.reeching.sanitation.app.presenter.DetailsWastePresenter;
import com.reeching.sanitation.app.util.ImageUtil;
import com.reeching.sanitation.app.util.LogUtils;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;
import com.reeching.sanitation.app.util.ToastUtil;
import com.reeching.sanitation.app.view.MyGridView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.reeching.sanitation.app.contant.Contants.SERVIECE;

/**
 * 垃圾篓详情
 */
public class DetailsWasteActivity extends AppCompatActivity implements DetailsWasteContract.View {
    @Inject
    DetailsWastePresenter detailsWastePresenter;
    @Bind(R.id.top_finish)
    ImageView topFinish;
    @Bind(R.id.top_name)
    TextView topName;
    @Bind(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @Bind(R.id.add_waste1)
    EditText addWaste1;
    @Bind(R.id.add_waste2)
    EditText addWaste2;
    @Bind(R.id.add_waste3)
    EditText addWaste3;
    @Bind(R.id.add_waste4)
    TextView addWaste4;
    @Bind(R.id.add_waste5)
    EditText addWaste5;
    @Bind(R.id.add_waste6)
    Spinner addWaste6;
    @Bind(R.id.add_waste7)
    TextView addWaste7;
    @Bind(R.id.add_waste8)
    TextView addWaste8;
    @Bind(R.id.add_waste9)
    TextView addWaste9;
    @Bind(R.id.add_waste10)
    TextView addWaste10;
    @Bind(R.id.add_waste11)
    TextView addWaste11;
    @Bind(R.id.add_waste12)
    TextView addWaste12;
    @Bind(R.id.add_waste13)
    TextView addWaste13;
    @Bind(R.id.add_waste14)
    Spinner addWaste14;
    @Bind(R.id.add_waste15)
    Spinner addWaste15;
    @Bind(R.id.add_waste16)
    EditText addWaste16;
    @Bind(R.id.add_waste17)
    Spinner addWaste17;
    @Bind(R.id.add_waste18)
    TextView addWaste18;
    @Bind(R.id.add_waste19)
    TextView addWaste19;
    @Bind(R.id.add_waste20)
    EditText addWaste20;
    @Bind(R.id.add_waste21)
    EditText addWaste21;
    @Bind(R.id.add_waste22)
    EditText addWaste22;
    @Bind(R.id.add_waste23)
    EditText addWaste23;
    @Bind(R.id.add_waste_recycler)
    RecyclerView addWasteRecycler;
    @Bind(R.id.add_waste_textView9)
    TextView addWasteTextView9;
    @Bind(R.id.add_waste_recycler1)
    RecyclerView addWasteRecycler1;
    @Bind(R.id.recycler1_iv)
    MyGridView recycler1_iv;
    @Bind(R.id.recycler_iv)
    ImageView recycler_iv;
    @Bind(R.id.add_waste_textView1)
    TextView addWasteTextView1;
    @Bind(R.id.audit_status)
    EditText auditStatus;
    @Bind(R.id.approve)
    Button approve;
    @Bind(R.id.audit_failure)
    Button auditFailure;
    @Bind(R.id.add_waste4Tv)
    TextView add_waste4Tv;
    @Bind(R.id.add_waste6Tv)
    TextView add_waste6Tv;
    @Bind(R.id.add_waste14Tv)
    TextView add_waste14Tv;
    @Bind(R.id.add_waste15Tv)
    TextView add_waste15Tv;
    @Bind(R.id.add_waste17Tv)
    TextView add_waste17Tv;
    @Bind(R.id.details_audit)
    LinearLayout details_audit;
    private String userId;
    private String id;
    private PaymentdetailsGridAdapter mGridAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_waste);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("id");
        DaggerActivityComponent.builder()
                .appComponent(App.getsInstance().getAppComponent())
                .build()
                .inject(this);
        String roleName = SharedPreferencesUtil.getInstance().getString("roleName");
        if ("基层角色".equals(roleName)){
            details_audit.setVisibility(View.GONE);
            auditStatus.setVisibility(View.GONE);
        }
        mGridAdapter = new PaymentdetailsGridAdapter(DetailsWasteActivity.this);
        initData();
    }

    private void initData() {
        topName.setText("垃圾篓详情");
        detailsWastePresenter.attachView(this);
        detailsWastePresenter.getWasteDetails(id);
        userId = SharedPreferencesUtil.getInstance().getString("userId");
    }

    @OnClick({R.id.top_finish, R.id.approve, R.id.audit_failure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_finish:
                finish();
                break;
            case R.id.approve:
                detailsWastePresenter.getApprove(id, userId);
                break;
            case R.id.audit_failure:
                new InputDialog.Builder(this)
                        .setTitle("请输入审核不通过原因")
                        .setHint("")
                                        .setLines(5)
                                        .setPositiveButton("确定", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
//                                Toast.makeText(DetailsWasteActivity.this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
                                detailsWastePresenter.getAuditFailure(id, userId, view.getTag().toString());
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
    public void showWasteDetail(WasteDetailBean data) {
        WasteDetailBean.InfosBean infosBean = data.getInfos();
        String statusName = infosBean.getAuditStatusName();
        if (statusName.equals("审核完成")){
            details_audit.setVisibility(View.GONE);
            auditStatus.setVisibility(View.GONE);
        }
        addWaste1.setText(infosBean.getMarkNo());
        addWaste2.setText(infosBean.getRubbishName());
        addWaste3.setText(infosBean.getRubbishNo());
        addWaste5.setText(infosBean.getCreateDate());
        addWaste7.setText(infosBean.getLeaderName());
        addWaste8.setText(infosBean.getFieldTeamName());
        addWaste9.setText(infosBean.getFieldTeamManagerName());
        addWaste10.setText(infosBean.getFieldUnitName());
        addWaste11.setText(infosBean.getFieldUnitManagerName());
        addWaste12.setText(infosBean.getWorkTeamName());
        addWaste13.setText(infosBean.getWorkTeamManagerName());
        addWaste16.setText(infosBean.getSelfCheck());
        addWaste18.setText(infosBean.getBelongStreetName());
        addWaste19.setText(infosBean.getCompanyName());
        addWaste20.setText(infosBean.getBelongGrid());
        addWaste21.setText(infosBean.getCreateDate());
//        addWaste22.setText(infosBean.getdat);
        addWaste23.setText(infosBean.getRemark());
        addWaste4.setVisibility(View.GONE);
        addWaste6.setVisibility(View.GONE);
        addWaste14.setVisibility(View.GONE);
        addWaste15.setVisibility(View.GONE);
        addWaste17.setVisibility(View.GONE);
        recycler_iv.setVisibility(View.VISIBLE);
        addWasteRecycler.setVisibility(View.GONE);
        recycler1_iv.setVisibility(View.VISIBLE);
        addWasteRecycler1.setVisibility(View.GONE);
        add_waste4Tv.setText(infosBean.getObjectKey());
        add_waste6Tv.setText(infosBean.getPropertyRightName());
        add_waste14Tv.setText(infosBean.getAreaTypeName());
        add_waste15Tv.setText(infosBean.getRubbishName());
        add_waste17Tv.setText(infosBean.getCompanyName());

        addWaste16.setFocusable(false);
        addWaste20.setFocusable(false);
        addWaste21.setFocusable(false);
        addWaste22.setFocusable(false);
        addWaste23.setFocusable(false);
        addWaste1.setFocusable(false);
        addWaste2.setFocusable(false);
        addWaste3.setFocusable(false);
        addWaste5.setFocusable(false);
        String aroundPhoto = infosBean.getPhotoa();
        if (!TextUtils.isEmpty(aroundPhoto)){
            aroundPhoto=aroundPhoto.substring(1,aroundPhoto.length());
            final String finalAroundPhoto=SERVIECE+aroundPhoto;
            ImageLoader.getInstance().displayImage(finalAroundPhoto,
                    recycler_iv);
            recycler_iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageUtil.showImage(DetailsWasteActivity.this, finalAroundPhoto);
                }
            });
        }

        String photoUrl = infosBean.getPhotob();
        LogUtils.i(photoUrl);
        if (!"".equals(photoUrl) && null != photoUrl) {
            String sourceStr = photoUrl;
            String[] sourceStrArray = sourceStr.split("\\|");
            final ArrayList<String> lists = new ArrayList<String>();
            for (int ii = 1; ii < sourceStrArray.length; ii++) {
                String str = sourceStrArray[ii];
                if (!TextUtils.isEmpty(str)){
                    lists.add(SERVIECE +str);
                }
            }
            LogUtils.i(lists.size());
            mGridAdapter.setData(lists);
            recycler1_iv.setAdapter(mGridAdapter);
            recycler1_iv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ImageUtil.showImage(DetailsWasteActivity.this,lists,position);
                }
            });
        }
    }

    @Override
    public void showApprove(String res) {
        if (res.equals("0")) {
            ToastUtil.showToast(DetailsWasteActivity.this, "失败");
        } else if (res.equals("1")) {
            ToastUtil.showToast(DetailsWasteActivity.this, "成功");
            finish();
        } else if (res.equals("2")) {
            ToastUtil.showToast(DetailsWasteActivity.this, "已存在");
        }
    }

    @Override
    public void showAuditFailure(String res) {
        if (res.equals("0")) {
            ToastUtil.showToast(DetailsWasteActivity.this, "失败");
        } else if (res.equals("1")) {
            ToastUtil.showToast(DetailsWasteActivity.this, "成功");
            finish();
        } else if (res.equals("2")) {
            ToastUtil.showToast(DetailsWasteActivity.this, "已存在");
        }

    }
}
