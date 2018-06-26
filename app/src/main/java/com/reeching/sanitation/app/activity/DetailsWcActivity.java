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
import com.reeching.sanitation.app.bean.WcDetailBean;
import com.reeching.sanitation.app.component.DaggerActivityComponent;
import com.reeching.sanitation.app.contract.DetailsWcContract;
import com.reeching.sanitation.app.presenter.DetailsWcPresenter;
import com.reeching.sanitation.app.util.ImageUtil;
import com.reeching.sanitation.app.util.LogUtils;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;
import com.reeching.sanitation.app.util.ToastUtil;
import com.reeching.sanitation.app.view.MyGridView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.reeching.sanitation.R.id.add_1;
import static com.reeching.sanitation.R.id.add_2;
import static com.reeching.sanitation.R.id.add_3;
import static com.reeching.sanitation.R.id.add_4;
import static com.reeching.sanitation.R.id.add_area;
import static com.reeching.sanitation.R.id.add_kind_tv;
import static com.reeching.sanitation.R.id.add_operation;
import static com.reeching.sanitation.R.id.add_way;
import static com.reeching.sanitation.R.id.add_wcClass;
import static com.reeching.sanitation.R.id.add_wcClassify;
import static com.reeching.sanitation.R.id.audit_status;
import static com.reeching.sanitation.R.id.recycler1_iv;
import static com.reeching.sanitation.R.id.recycler_iv;
import static com.reeching.sanitation.app.contant.Contants.SERVIECE;

/**
 * 公厕详情
 */
public class DetailsWcActivity extends AppCompatActivity implements DetailsWcContract.View {

    @Inject
    DetailsWcPresenter detailsWcPresenter;
    @Bind(R.id.top_finish)
    ImageView topFinish;
    @Bind(R.id.top_name)
    TextView topName;
    @Bind(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @Bind(R.id.add_num)
    EditText addNum;
    @Bind(R.id.add_grade)
    EditText addGrade;
    @Bind(R.id.add_name)
    EditText addName;
    @Bind(R.id.add_name1)
    EditText addName1;
    @Bind(R.id.add_okey)
    TextView addOkey;

    @Bind(R.id.add_okey_tv)
    TextView addOkeyTV;
    @Bind(R.id.add_company_tv)
    TextView addCompanyTV;
    @Bind(add_kind_tv)
    TextView addKindTV;
    @Bind(R.id.add_operation_tv)
    TextView add_operation_tv;
    @Bind(R.id.add_area_tv)
    TextView add_area_tv;
    @Bind(R.id.add_4_tv)
    TextView add_4_tv;
    @Bind(R.id.add_3_tv)
    TextView add_3_tv;
    @Bind(R.id.add_2_tv)
    TextView add_2_tv;
    @Bind(R.id.add_way_tv)
    TextView add_way_tv;
    @Bind(R.id.add_wcClass_tv)
    TextView add_wcClass_tv;
    @Bind(R.id.add_wcClassify_tv)
    TextView add_wcClassify_tv;
    @Bind(R.id.add_1_tv)
    TextView add_1_tv;

    @Bind(R.id.ll_add_okey)
    LinearLayout llAddOkey;
    @Bind(R.id.add_grids)
    EditText addGrids;
    @Bind(R.id.add_site)
    EditText addSite;
    @Bind(R.id.add_unit)
    EditText addUnit;
    @Bind(R.id.add_company)
    Spinner addCompany;
    @Bind(R.id.ll_add_company)
    LinearLayout llAddCompany;
    @Bind(R.id.add_classify)
    Spinner addClassify;
    @Bind(R.id.add_inspection_site)
    EditText addInspectionSite;
    @Bind(R.id.add_kind)
    Spinner addKind;
    @Bind(R.id.a)
    TextView a;
    @Bind(R.id.add_place)
    TextView addPlace;
    @Bind(R.id.add_principal)
    TextView addPrincipal;
    @Bind(R.id.add_element)
    TextView addElement;
    @Bind(R.id.add_element_principal)
    TextView addElementPrincipal;
    @Bind(R.id.add_class)
    TextView addClass;
    @Bind(R.id.add_class_principal)
    TextView addClassPrincipal;
    @Bind(add_1)
    Spinner add1;
    @Bind(add_wcClassify)
    Spinner addWcClassify;
    @Bind(add_wcClass)
    Spinner addWcClass;
    @Bind(add_way)
    Spinner addWay;
    @Bind(R.id.add_mancount)
    EditText addMancount;
    @Bind(R.id.add_womancount)
    EditText addWomancount;
    @Bind(R.id.add_count)
    EditText addCount;
    @Bind(R.id.add_counts)
    EditText addCounts;
    @Bind(add_2)
    Spinner add2;
    @Bind(add_3)
    Spinner add3;
    @Bind(add_4)
    Spinner add4;
    @Bind(add_area)
    Spinner addArea;
    @Bind(add_operation)
    Spinner addOperation;
    @Bind(R.id.add_5)
    EditText add5;
    @Bind(R.id.add_6)
    EditText add6;
    @Bind(R.id.add_7)
    TextView add7;
    @Bind(R.id.add_8)
    EditText add8;
    @Bind(R.id.add_9)
    TextView add9;
    @Bind(R.id.add_10)
    TextView add10;
    @Bind(R.id.add_11)
    EditText add11;
    @Bind(R.id.add_12)
    TextView add12;
    @Bind(R.id.add_13)
    TextView add13;
    @Bind(R.id.add_14)
    EditText add14;
    @Bind(R.id.add_note)
    EditText addNote;
    @Bind(R.id.recycler)
    RecyclerView recycler;
    @Bind(recycler_iv)
    ImageView recyclerIv;
    @Bind(R.id.textView9)
    TextView textView9;
    @Bind(R.id.recycler1)
    RecyclerView recycler1;
    @Bind(recycler1_iv)
    MyGridView recycler1Iv;
    @Bind(R.id.textView1)
    TextView textView1;
    @Bind(audit_status)
    EditText auditStatus;
    @Bind(R.id.approve)
    Button approve;
    @Bind(R.id.audit_failure)
    Button auditFailure;
    @Bind(R.id.details_audit)
    LinearLayout details_audit;
    private String id;
    private String userId;
    private PaymentdetailsGridAdapter mGridAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wc_details);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("id");
        DaggerActivityComponent.builder()
                .appComponent(App.getsInstance().getAppComponent())
                .build()
                .inject(this);
        String roleName = SharedPreferencesUtil.getInstance().getString("roleName");
        LogUtils.i(roleName);
        if ("基层角色".equals(roleName)){
            details_audit.setVisibility(View.GONE);
            auditStatus.setVisibility(View.GONE);
        }
        mGridAdapter = new PaymentdetailsGridAdapter(DetailsWcActivity.this);

        initData();
    }

    private void initData() {
        topName.setText("公厕详情");
        detailsWcPresenter.attachView(this);
        detailsWcPresenter.getWcDetails(id);
        userId = SharedPreferencesUtil.getInstance().getString("userId");
    }

    @OnClick({R.id.top_finish, R.id.approve, R.id.audit_failure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_finish:
                finish();
                break;
            case R.id.approve:
                detailsWcPresenter.getApprove(id, userId);
                break;
            case R.id.audit_failure:
                new InputDialog.Builder(this)
                        .setTitle("请输入审核不通过原因")
                        .setHint("")
                        .setLines(5)
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                Toast.makeText(DetailsWcActivity.this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
                                detailsWcPresenter.getAuditFailure(id, userId, view.getTag().toString());
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
    public void showWcDetail(WcDetailBean data) {
        addOkeyTV.setVisibility(View.VISIBLE);
        addOkey.setVisibility(View.GONE);
        addCompanyTV.setVisibility(View.VISIBLE);
        addCompany.setVisibility(View.GONE);
        addKindTV.setVisibility(View.VISIBLE);
        addKind.setVisibility(View.GONE);
        add_operation_tv.setVisibility(View.VISIBLE);
        addOperation.setVisibility(View.GONE);
        add_area_tv.setVisibility(View.VISIBLE);
        addArea.setVisibility(View.GONE);
        add_4_tv.setVisibility(View.VISIBLE);
        add4.setVisibility(View.GONE);
        add_3_tv.setVisibility(View.VISIBLE);
        add3.setVisibility(View.GONE);
        add_2_tv.setVisibility(View.VISIBLE);
        add2.setVisibility(View.GONE);
        add_way_tv.setVisibility(View.VISIBLE);
        addWay.setVisibility(View.GONE);
        add_wcClass_tv.setVisibility(View.VISIBLE);
        addWcClass.setVisibility(View.GONE);
        add_wcClassify_tv.setVisibility(View.VISIBLE);
        addWcClassify.setVisibility(View.GONE);
        add_1_tv.setVisibility(View.VISIBLE);
        add1.setVisibility(View.GONE);
        recyclerIv.setVisibility(View.VISIBLE);
        recycler.setVisibility(View.GONE);
        recycler1Iv.setVisibility(View.VISIBLE);
        recycler1.setVisibility(View.GONE);


        WcDetailBean.InfosBean infosBean = data.getInfos();
        String statusName = infosBean.getAuditStatusName();
        if (statusName.equals("审核完成")){
            details_audit.setVisibility(View.GONE);
            auditStatus.setVisibility(View.GONE);
        }
        addCompanyTV.setText(infosBean.getCompanyName());
        addKindTV.setText(infosBean.getTioletTypeName());
        addOkeyTV.setText(infosBean.getObjectKey());
        add_1_tv.setText(infosBean.getPropertyRightName());
        add_2_tv.setText(infosBean.getBarrierFacilitiesName());
        add_4_tv.setText(infosBean.getManageTypeName());
        add_area_tv.setText(infosBean.getAreaTypeName());
        add_operation_tv.setText(infosBean.getAuditStatusName());
        add_wcClassify_tv.setText(infosBean.getTioletTypeName());
        add_wcClass_tv.setText(infosBean.getTioletLevel());


        addNum.setText(infosBean.getNumber());
        addGrade.setText(infosBean.getMarkNo());
        addName.setText(infosBean.getName());
        addNum.setFocusable(false);
        addGrade.setFocusable(false);
        addName.setFocusable(false);
        addName1.setFocusable(false);
        addSite.setFocusable(false);
        addUnit.setFocusable(false);
        addInspectionSite.setFocusable(false);
        addMancount.setFocusable(false);
        addWomancount.setFocusable(false);
        addCount.setFocusable(false);
        addCounts.setFocusable(false);
        addName1.setText(infosBean.getCheckName());
//        addGrids.setText(infosBean.getNumber());
        addSite.setText(infosBean.getAreaType());
        addUnit.setText(infosBean.getManageUnit());
        addInspectionSite.setText(infosBean.getCheckArea());
        a.setText(infosBean.getLeaderName());
        addPlace.setText(infosBean.getFieldTeamName());
        addPrincipal.setText(infosBean.getFieldTeamManagerName());
        addElement.setText(infosBean.getFieldUnitName());
        addElementPrincipal.setText(infosBean.getFieldUnitManagerName());
        addClass.setText(infosBean.getWorkTeamName());
        addClassPrincipal.setText(infosBean.getWorkTeamManagerName());
        addMancount.setText(infosBean.getMalePosition());
        addWomancount.setText(infosBean.getFemalePosition());
        addCount.setText(infosBean.getDisabledPosition());
        addCounts.setText(infosBean.getStationTotal());
        add5.setFocusable(false);
        add6.setFocusable(false);
        add7.setFocusable(false);
        add8.setFocusable(false);
        add9.setFocusable(false);
        add10.setFocusable(false);
        add11.setFocusable(false);
        add12.setFocusable(false);
        add13.setFocusable(false);
        add14.setFocusable(false);
        addNote.setFocusable(false);


        add5.setText(infosBean.getManagerNumber());
        add6.setText(infosBean.getCoveredArea());
        add7.setText(infosBean.getCreateDate());
        add8.setText(infosBean.getOperationSituation());
        add9.setText(infosBean.getOpenCloseTime());
        add10.setText(infosBean.getUpdateDate());
        add11.setText(infosBean.getSelfCheck());
        add12.setText(infosBean.getBelongStreetName());
        add13.setText(infosBean.getBelongCommunityName());
//        add14.setText(infosBean.getda());
        addNote.setText(infosBean.getRemark());

        String aroundPhoto = infosBean.getToiletsAroundPhoto();
        String photoUrl = infosBean.getToiletPhoto();
        if (!TextUtils.isEmpty(photoUrl)){
            photoUrl=photoUrl.substring(1,photoUrl.length());
            final String finalAroundPhoto = SERVIECE + photoUrl;
            ImageLoader.getInstance().displayImage(finalAroundPhoto,
                    recyclerIv);
            recyclerIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageUtil.showImage(DetailsWcActivity.this, finalAroundPhoto);
                }
            });
        }

        if (!"".equals(aroundPhoto) && null != aroundPhoto) {
            String sourceStr = aroundPhoto;
            String[] sourceStrArray = sourceStr.split("\\|");
            final List<String> lists = new ArrayList<String>();
            for (int ii = 1; ii < sourceStrArray.length; ii++) {
                String str = sourceStrArray[ii];
                if (!TextUtils.isEmpty(str)){
                    lists.add(SERVIECE +str);
                }
            }
            LogUtils.i(lists.size());
            mGridAdapter.setData(lists);
            recycler1Iv.setAdapter(mGridAdapter);
            recycler1Iv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ImageUtil.showImage(DetailsWcActivity.this,lists,position);
                }
            });
        }

    }

    @Override
    public void showApprove(String res) {
        if (res.equals("0")) {
            ToastUtil.showToast(DetailsWcActivity.this, "失败");
        } else if (res.equals("1")) {
            ToastUtil.showToast(DetailsWcActivity.this, "成功");
            finish();
        } else if (res.equals("2")) {
            ToastUtil.showToast(DetailsWcActivity.this, "已存在");
        }
    }

    @Override
    public void showAuditFailure(String res) {
        if (res.equals("0")) {
            ToastUtil.showToast(DetailsWcActivity.this, "失败");
        } else if (res.equals("1")) {
            ToastUtil.showToast(DetailsWcActivity.this, "成功");
            finish();
        } else if (res.equals("2")) {
            ToastUtil.showToast(DetailsWcActivity.this, "已存在");
        }

    }
}
