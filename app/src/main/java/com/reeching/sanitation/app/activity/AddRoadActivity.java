package com.reeching.sanitation.app.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.jiangyy.easydialog.LoadingDialog;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.adapter.SpinnerWorkCompanyAdapter;
import com.reeching.sanitation.app.adapter.SpinnersAdapter;
import com.reeching.sanitation.app.base.BaseAddActivity;
import com.reeching.sanitation.app.bean.AddSpinnerBean;
import com.reeching.sanitation.app.bean.FindBaseIdBean;
import com.reeching.sanitation.app.bean.WorkCompanyBean;
import com.reeching.sanitation.app.component.AppComponent;
import com.reeching.sanitation.app.component.DaggerActivityComponent;
import com.reeching.sanitation.app.contract.AddRoadContract;
import com.reeching.sanitation.app.presenter.IAddRoadPresenter;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.interfaces.OnItemClickListener;
import com.reeching.sanitation.app.util.LogUtils;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;
import com.reeching.sanitation.app.util.ToastUtil;
import com.reeching.sanitation.app.view.SpinnerPopWindow;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

import static com.reeching.sanitation.R.id.add_road_14;
import static com.reeching.sanitation.R.id.add_road_22;
import static com.reeching.sanitation.R.id.add_road_9;
import static com.reeching.sanitation.R.id.add_road_orderNo;
import static com.reeching.sanitation.app.contant.Contants.ADD_BLOCK;
import static com.reeching.sanitation.app.contant.Contants.ADD_CLASS;
import static com.reeching.sanitation.app.contant.Contants.ADD_CLASS_PRINCIPAL;
import static com.reeching.sanitation.app.contant.Contants.ADD_COMMUNITY;
import static com.reeching.sanitation.app.contant.Contants.ADD_ELEMENT;
import static com.reeching.sanitation.app.contant.Contants.ADD_ELEMENT_PRINCIPAL;
import static com.reeching.sanitation.app.contant.Contants.ADD_LEADER;
import static com.reeching.sanitation.app.contant.Contants.ADD_PLACE;
import static com.reeching.sanitation.app.contant.Contants.ADD_PRINCIPAL;

/**
 * 道路添加
 */
public class AddRoadActivity extends BaseAddActivity implements AddRoadContract.View {

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
    @Bind(R.id.add_road_4)
    TextView addRoad4;
    @Bind(R.id.add_road_5)
    Spinner addRoad5;
    @Bind(R.id.add_road_6)
    EditText addRoad6;
    @Bind(R.id.add_areaType)
    Spinner addAreaType;
    @Bind(R.id.add_road_7)
    EditText addRoad7;
    @Bind(R.id.add_road_8)
    EditText addRoad8;
    @Bind(add_road_9)
    TextView addRoad9;
    @Bind(R.id.add_road_10)
    TextView addRoad10;
    @Bind(R.id.add_road_11)
    TextView addRoad11;
    @Bind(R.id.add_road_12)
    TextView addRoad12;
    @Bind(R.id.add_road_13)
    TextView addRoad13;
    @Bind(add_road_14)
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
    @Bind(add_road_22)
    TextView addRoad22;
    @Bind(R.id.add_road_23)
    EditText addRoad23;
    @Bind(R.id.add_road_24)
    EditText addRoad24;
    @Bind(add_road_orderNo)
    EditText addRoadOrderNo;
    @Bind(R.id.add_road_25)
    EditText addRoad25;
    @Bind(R.id.add_road_26)
    EditText addRoad26;
    @Bind(R.id.add_road_27)
    EditText addRoad27;
    @Bind(R.id.add_)
    Button add;
    private boolean checkMark;
    private String userId;
    @Inject
    IAddRoadPresenter iAddRoadPresenter;
    private String objectKeyId;//基础id
    private String workCompanyId;//作业公司
    private String areaTypeId;// 区域
    private String streetLevelId;// 道路级别
    private String addRoadCompanyId;//专业
    private String placeId;//	场队id
    private String elementId;//	分队id
    private String classId;//	班组id
    private String classPrincipalId;//班组负责人
    private String elementPrincipalId;//分队负责人
    private String principalId;//场队负责人
    private String leaderId; //分管领导
    private String blockId;//所属街乡
    private String communityId;//所属社区
    private SpinnerPopWindow<FindBaseIdBean.InfosBean> mSpinerPopWindow;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_road;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initDatas() {
        addRoad1.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(android.view.View v, boolean hasFocus) {
                if (hasFocus) {
                    LogUtils.i("获取焦点");
                } else {
                    String etNum = addRoad1.getText().toString();
                    iAddRoadPresenter.checkMarkNoToilet(etNum);
                }
            }
        });
        setSpinner();//下拉框
    }

    private void setSpinner() {
        iAddRoadPresenter.getObjectKeySpinner();
        iAddRoadPresenter.getWorkCompanySpinner();
        iAddRoadPresenter.getAreaTypeSpinner();
        iAddRoadPresenter.getStreetLevelSpinner();
        iAddRoadPresenter.getCompanyTypeSpinner();
    }

    @Override
    public void configViews() {
        iAddRoadPresenter.attachView(this);
        int type = getIntent().getIntExtra("type", -1);
        userId = SharedPreferencesUtil.getInstance().getString("userId");
        topName.setText(R.string.ins_addroad);
    }

    @Override
    public void initPicture() {

    }

    Intent i = new Intent();
    @OnClick({R.id.top_finish, R.id.add_road_4,R.id.add_road_21,add_road_22,R.id.add_,R.id.add_road_9,R.id.add_road_10,R.id.add_road_11,R.id.add_road_12,R.id.add_road_13, add_road_14,R.id.add_road_15})
    public void onViewClicked(android.view.View view) {
        switch (view.getId()) {
            case R.id.top_finish:
                finish();
                break;
            case R.id.add_road_4:
//                mSpinerPopWindow.setWidth(addRoad4.getWidth());
                if(mSpinerPopWindow!=null){
                    mSpinerPopWindow.showAsDropDown(addRoad4);
                }
                break;

            case R.id.add_road_21://所属街乡
                i.setClass(AddRoadActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_BLOCK);
                startActivityForResult(i, ADD_BLOCK);
                break;
            case add_road_22://所属社区
                i.setClass(AddRoadActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_COMMUNITY);
                startActivityForResult(i, ADD_COMMUNITY);
                break;
            case R.id.add_road_9:
                i.setClass(AddRoadActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_LEADER);
                startActivityForResult(i, ADD_LEADER);
                break;
            case R.id.add_road_10:
                i.setClass(AddRoadActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_PLACE);
                startActivityForResult(i, ADD_PLACE);
                break;
            case R.id.add_road_11://场队负责人
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddRoadActivity.this, "请先选择场对");
                    return;
                } else
                    i.setClass(AddRoadActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_PRINCIPAL);
                i.putExtra("placeId", placeId);
                startActivityForResult(i, ADD_PRINCIPAL);
                break;
            case R.id.add_road_12://分队
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddRoadActivity.this, "请先选择场对");
                    return;
                } else
                    i.setClass(AddRoadActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_ELEMENT);
                i.putExtra("placeId", placeId);
                startActivityForResult(i, ADD_ELEMENT);
                break;
            case R.id.add_road_13://分队负责人
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddRoadActivity.this, "请先选择场对");
                    return;
                } else
                    i.setClass(AddRoadActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_ELEMENT_PRINCIPAL);
                i.putExtra("placeId", placeId);
                startActivityForResult(i, ADD_ELEMENT_PRINCIPAL);
                break;
            case add_road_14://班组
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddRoadActivity.this, "请先选择场对");
                    return;
                } else if (TextUtils.isEmpty(elementId)) {
                    ToastUtil.showToast(AddRoadActivity.this, "请先选择分对");
                    return;
                } else
                    i.setClass(AddRoadActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_CLASS);
                i.putExtra("placeId", placeId);
                i.putExtra("elementId", elementId);
                startActivityForResult(i, ADD_CLASS);
                break;
            case R.id.add_road_15://班组负责人
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddRoadActivity.this, "请先选择场对");
                    return;
                } else if (TextUtils.isEmpty(elementId)) {
                    ToastUtil.showToast(AddRoadActivity.this, "请先选择分对");
                    return;
                } else if (TextUtils.isEmpty(classId)) {
                    ToastUtil.showToast(AddRoadActivity.this, "请先选择班组");
                    return;
                } else
                    i.setClass(AddRoadActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_CLASS_PRINCIPAL);
                i.putExtra("placeId", placeId);
                i.putExtra("elementId", elementId);
                i.putExtra("classId", classId);
                startActivityForResult(i, ADD_CLASS_PRINCIPAL);
                break;

            case R.id.add_:
                String markNo=addRoad1.getText().toString();//标号
                String branchesNo=addRoad2.getText().toString();//编号
                String streetName=addRoad3.getText().toString();//道路名称
                String streetStart=addRoad7.getText().toString();//路段起点
                String streetEnd=addRoad8.getText().toString();//路段止点
                String segmentNo=addRoad17.getText().toString();// 分段编号
                String streetSegment=addRoad18.getText().toString();//道路分段
                String minStreetStart=addRoad19.getText().toString();//最小段起点
                String maxStreetEnd=addRoad20.getText().toString();//最小段止点
                String belongGrid=addRoad23.getText().toString();// 所属网格
                String orderNo=addRoadOrderNo.getText().toString();//顺码
                String simpleNo=addRoad24.getText().toString();//简码
                String submitAuditTime=addRoad25.getText().toString();//审核时间
                String remark=addRoad27.getText().toString();//备注
                LogUtils.i(objectKeyId);
                if (checkMark){
                    iAddRoadPresenter.saveMessage(userId,objectKeyId,markNo,branchesNo,streetName,streetLevelId,streetStart,streetEnd,
                            leaderId,placeId,principalId,elementId,elementPrincipalId,classId,classPrincipalId,addRoadCompanyId,
                            workCompanyId,segmentNo,streetSegment,minStreetStart,maxStreetEnd,blockId,communityId,belongGrid,orderNo,
                            simpleNo,submitAuditTime,remark,areaTypeId);
                }



                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                //所属街乡
                case ADD_BLOCK:
                    String blockName = data.getStringExtra("name");
                    blockId = data.getStringExtra("id");
                    addRoad21.setText(blockName);
                    break;
                //所属社区
                case ADD_COMMUNITY:
                    String communityName = data.getStringExtra("name");
                    communityId = data.getStringExtra("id");
                    addRoad22.setText(communityName);
                    break;
                //分管领导
                case ADD_LEADER:
                    String leaderName = data.getStringExtra("name");
                    leaderId = data.getStringExtra("id");
                    addRoad9.setText(leaderName);
                    break;
                //所属场队
                case ADD_PLACE:
                    placeId = data.getStringExtra("id");
                    String name = data.getStringExtra("name");
                    addRoad10.setText(name);
                    break;
                //场队负责人
                case ADD_PRINCIPAL:
                    String name1 = data.getStringExtra("name");
                    principalId = data.getStringExtra("id");
                    addRoad11.setText(name1);
                    break;
                //所属分队
                case ADD_ELEMENT:
                    elementId = data.getStringExtra("id");
                    String elementName = data.getStringExtra("name");
                    addRoad12.setText(elementName);
                    break;
                //分队负责人
                case ADD_ELEMENT_PRINCIPAL:
                    String name2 = data.getStringExtra("name");
                    elementPrincipalId = data.getStringExtra("id");
                    addRoad13.setText(name2);
                    break;
                //所属班组
                case ADD_CLASS:
                    classId = data.getStringExtra("id");
                    String className = data.getStringExtra("name");
                    addRoad14.setText(className);
                    break;
                //班组负责人
                case ADD_CLASS_PRINCIPAL:
                    String name3 = data.getStringExtra("name");
                    classPrincipalId = data.getStringExtra("id");
                    addRoad15.setText(name3);
                    break;
            }
        }


    }

    @Override
    public void complete() {
        new LoadingDialog.Builder(this).dismiss();
    }

    @Override
    public void start() {
        new LoadingDialog.Builder(this).setTitle("提交中...").setCanceledOnTouchOutside(false).show();
    }

    @Override
    public void showAddNum(String data) {
        if (data.equals("1")) {
            checkMark = true;
            ToastUtil.showToast(AddRoadActivity.this,"标号可用");
        }

    }

    @Override
    public void showObjectKeySpinner(List<FindBaseIdBean.InfosBean> list) {

         mSpinerPopWindow = new SpinnerPopWindow<FindBaseIdBean.InfosBean>(this,"300503", list, new OnItemClickListener<FindBaseIdBean.InfosBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, FindBaseIdBean.InfosBean data, int position) {
                addRoad4.setText(data.getObjectKey1());
                objectKeyId = data.getId();
                mSpinerPopWindow.dismiss();
            }
        }
        );
        mSpinerPopWindow.setNewData(list);
        if (addRoad4!=null){
            addRoad4.setText(list.get(0).getObjectKey1());
            objectKeyId=list.get(0).getId();
        }

//        if (list!=null){
//            SpinnerFindBaseIdAdapter spAdapter = new SpinnerFindBaseIdAdapter(AddRoadActivity.this, list);
//            addRoad4.setAdapter(spAdapter);
//        }
//        addRoad4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                FindBaseIdBean.InfosBean in = (FindBaseIdBean.InfosBean) addRoad4.getSelectedItem();
//                objectKeyId = in.getId();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }

    @Override
    public void showWorkCompanySpinner(List<WorkCompanyBean.InfosBean> list) {
        SpinnerWorkCompanyAdapter spAdapter = new SpinnerWorkCompanyAdapter(AddRoadActivity.this, list);
        if (addRoad16!=null){
            addRoad16.setAdapter(spAdapter);
        addRoad16.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                WorkCompanyBean.InfosBean in = (WorkCompanyBean.InfosBean) addRoad16.getSelectedItem();
                workCompanyId = in.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }

    }

    @Override
    public void showAreaTypeSpinner(List<AddSpinnerBean.InfosBean> list) {
        SpinnersAdapter spAdapter = new SpinnersAdapter(AddRoadActivity.this, list);
        if (addAreaType!=null){
            addAreaType.setAdapter(spAdapter);
        addAreaType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AddSpinnerBean.InfosBean info = (AddSpinnerBean.InfosBean) addAreaType.getSelectedItem();
                areaTypeId = info.getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }
    }

    @Override
    public void showStreetLevelSpinner(List<AddSpinnerBean.InfosBean> list) {
        SpinnersAdapter spAdapter = new SpinnersAdapter(AddRoadActivity.this, list);
        if (addRoad5!=null){
            addRoad5.setAdapter(spAdapter);
        addRoad5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AddSpinnerBean.InfosBean info = (AddSpinnerBean.InfosBean) addRoad5.getSelectedItem();
                streetLevelId = info.getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }

    }

    @Override
    public void showCompanyTypeSpinner(List<AddSpinnerBean.InfosBean> list) {
        SpinnersAdapter spAdapter = new SpinnersAdapter(AddRoadActivity.this, list);
        if (addRoadCompany!=null){
            addRoadCompany.setAdapter(spAdapter);
        addRoadCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AddSpinnerBean.InfosBean info = (AddSpinnerBean.InfosBean) addRoadCompany.getSelectedItem();
                addRoadCompanyId = info.getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }
    }

    @Override
    public void showSaveMessage(String s) {
        if (s.equals("1")) {
            ToastUtil.showToast(AddRoadActivity.this, "保存成功");
            finish();
        }
    }
}
