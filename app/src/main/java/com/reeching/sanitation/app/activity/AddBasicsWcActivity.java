package com.reeching.sanitation.app.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
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

import com.bigkoo.pickerview.TimePickerView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.adapter.GridImageAdapter;
import com.reeching.sanitation.app.adapter.GridImagesAdapter;
import com.reeching.sanitation.app.adapter.SpinnerWorkCompanyAdapter;
import com.reeching.sanitation.app.adapter.SpinnersAdapter;
import com.reeching.sanitation.app.base.BaseAddActivity;
import com.reeching.sanitation.app.bean.AddSpinnerBean;
import com.reeching.sanitation.app.bean.FindBaseIdBean;
import com.reeching.sanitation.app.bean.WorkCompanyBean;
import com.reeching.sanitation.app.component.AppComponent;
import com.reeching.sanitation.app.component.DaggerActivityComponent;
import com.reeching.sanitation.app.contract.AddBasicsViewContract;
import com.reeching.sanitation.app.presenter.IAddWcPresenter;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.interfaces.OnItemClickListener;
import com.reeching.sanitation.app.util.LogUtils;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;
import com.reeching.sanitation.app.util.ToastUtil;
import com.reeching.sanitation.app.util.pic.AddMuchPic;
import com.reeching.sanitation.app.util.pic.AddOnePic;
import com.reeching.sanitation.app.view.FullyGridLayoutManager;
import com.reeching.sanitation.app.view.SpinnerPopWindow;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

import static com.reeching.sanitation.R.id.add_10;
import static com.reeching.sanitation.R.id.add_7;
import static com.reeching.sanitation.R.id.add_9;
import static com.reeching.sanitation.R.id.add_okey;
import static com.reeching.sanitation.app.contant.Contants.ADD_BLOCK;
import static com.reeching.sanitation.app.contant.Contants.ADD_CLASS;
import static com.reeching.sanitation.app.contant.Contants.ADD_CLASS_PRINCIPAL;
import static com.reeching.sanitation.app.contant.Contants.ADD_COMMUNITY;
import static com.reeching.sanitation.app.contant.Contants.ADD_ELEMENT;
import static com.reeching.sanitation.app.contant.Contants.ADD_ELEMENT_PRINCIPAL;
import static com.reeching.sanitation.app.contant.Contants.ADD_LEADER;
import static com.reeching.sanitation.app.contant.Contants.ADD_PLACE;
import static com.reeching.sanitation.app.contant.Contants.ADD_PRINCIPAL;
import static com.reeching.sanitation.app.contant.Contants.INS_WCAdd_MUCHPIC;
import static com.reeching.sanitation.app.contant.Contants.INS_WCAdd_ONEPIC;
import static com.reeching.sanitation.app.util.FileUtil.chageToiletFileName;
import static com.reeching.sanitation.app.util.FileUtil.chageToiletsFileName;
import static com.reeching.sanitation.app.util.FileUtil.delFile;
import static com.reeching.sanitation.app.util.FileUtil.getPath;
import static com.reeching.sanitation.app.util.FileUtil.setTime;


/**
 * 基础数据平台-公厕-添加数据页面
 */
public class AddBasicsWcActivity extends BaseAddActivity implements AddBasicsViewContract.View {

    @Bind(R.id.top_finish)
    ImageView topFinish;
    @Bind(R.id.top_name)
    TextView top_name;
    @Bind(R.id.recycler)
    RecyclerView recycler;
    @Bind(R.id.recycler1)
    RecyclerView recycler1;
    @Bind(R.id.add_)
    Button add;
    @Bind(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @Bind(R.id.add_num)
    EditText addNum;
    @Bind(R.id.add_name)
    EditText addName;
    @Bind(add_okey)
    TextView addOkey;
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
    @Bind(R.id.add_1)
    Spinner add1;
    @Bind(R.id.add_wcClassify)
    Spinner addWcClassify;
    @Bind(R.id.add_way)
    Spinner addWay;
    @Bind(R.id.add_2)
    Spinner add2;
    @Bind(R.id.add_3)
    Spinner add3;
    @Bind(R.id.add_4)
    Spinner add4;
    @Bind(R.id.add_6)
    EditText add6;
    @Bind(R.id.add_8)
    EditText add8;
    @Bind(R.id.add_11)
    EditText add11;
    @Bind(R.id.add_12)
    TextView add12;
    @Bind(R.id.add_13)
    TextView add13;
    @Bind(R.id.add_14)
    EditText add14;
    @Bind(R.id.textView9)
    TextView textView9;
    @Bind(R.id.textView1)
    TextView textView1;
    @Bind(R.id.add_wcClass)
    Spinner addWcClass;
    @Bind(R.id.add_area)
    Spinner addArea;
    @Bind(R.id.add_operation)
    Spinner addOperation;
    @Bind(R.id.add_7)
    TextView add7;
    @Bind(R.id.add_9)
    TextView add9;
    @Bind(R.id.add_10)
    TextView add10;
    @Bind(R.id.add_grade)
    EditText addGrade;
    @Bind(R.id.add_name1)
    EditText addName1;
    @Bind(R.id.add_kind)
    Spinner addKind;
    @Bind(R.id.add_mancount)
    EditText addMancount;
    @Bind(R.id.add_womancount)
    EditText addWomancount;
    @Bind(R.id.add_count)
    EditText addCount;
    @Bind(R.id.add_counts)
    EditText addCounts;
    @Bind(R.id.add_5)
    EditText add5;
    @Bind(R.id.add_note)
    EditText addNote;
    private TimePickerView pvTime;//时间选择器
    AddOnePic addOnePic;
    AddMuchPic addMuchPic;
    private GridImageAdapter adapter;
    private GridImagesAdapter adapters;
    private List<LocalMedia> selectList = new ArrayList<>();//铭牌照片单选
    private List<LocalMedia> selectList1 = new ArrayList<>();//周围照片多选
    private int maxSelectNum = 15;
    //标号
    boolean checkMark = false;
    //编号
    boolean checkNumber = false;
    @Inject
    IAddWcPresenter iAddWcPresenter;
    Intent i = new Intent();
    private String workCompanyId;//作业公司
    private String tioletTypeId;//公厕类别
    private String manageTypeId;// 管理形式
    private String tioletClassId;//种类
    private String tioletLevelId;//公厕等级
    private String barrierFacilitiesId;//有无障碍设施
    private String operationId; //审核操作
    private String placeId;//	场队id
    private String elementId;//	分队id
    private String classId;//	班组id
    private String objectKeyId;//基础objectKey
    private String propertyRightId;//产权权属
    private String areaTypeId;// 区域
    private String blockId;//所属街乡
    private String communityId;//所属社区
    private String classPrincipalId;//班组负责人
    private String elementPrincipalId;//分队负责人
    private String principalId;//场队负责人
    private String leaderId; //分管领导
    private String userId;//用户ID
    private String toiletsAroundPhoto;//周边图片路径
    private ArrayList<File> toiletsAroundPhotos = new ArrayList<>();//周边图片文件集合
    private String toiletPhoto;//公厕照片
    private File toiletPhotoFile;
    private SpinnerPopWindow<FindBaseIdBean.InfosBean> mSpinerPopWindow;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_basic_wc;
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
        int type = getIntent().getIntExtra("type", -1);
        userId = SharedPreferencesUtil.getInstance().getString("userId");
        top_name.setText(R.string.ins_addwc);
        toiletPhotoFile = null;
    }

    @Override
    public void configViews() {
        iAddWcPresenter.attachView(this);
        detection();//检测是否标号/编号可用
        setSpinner();//下拉框
    }

    @Override
    public void initPicture() {
        FullyGridLayoutManager manager = new FullyGridLayoutManager(AddBasicsWcActivity.this, 4, GridLayoutManager.VERTICAL, false);
        FullyGridLayoutManager manager1 = new FullyGridLayoutManager(AddBasicsWcActivity.this, 4, GridLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
        recycler1.setLayoutManager(manager1);

        addOnePic = new AddOnePic(AddBasicsWcActivity.this);//单个图片
        addMuchPic = new AddMuchPic(AddBasicsWcActivity.this);//多张图片
        adapter = new GridImageAdapter(AddBasicsWcActivity.this, addOnePic);
        adapters = new GridImagesAdapter(AddBasicsWcActivity.this, addMuchPic);
        adapter.setList(selectList);
        adapters.setList(selectList1);
        adapter.setSelectMax(1);
        adapters.setSelectMax(maxSelectNum);
        recycler.setAdapter(adapter);
        recycler1.setAdapter(adapters);
    }

    private void setSpinner() {
        iAddWcPresenter.getObjectKeySpinner();
        iAddWcPresenter.getWorkCompanySpinner();
        iAddWcPresenter.getTioletClassSpinner();

        iAddWcPresenter.getPropertyRightSpinner();

        iAddWcPresenter.getTioletLevelSpinner();

        iAddWcPresenter.getTioletTypeSpinner();

        iAddWcPresenter.getBarrierFacilitiesSpinner();

        iAddWcPresenter.getManageTypeSpinner();

        iAddWcPresenter.getAreaTypeSpinner();

        iAddWcPresenter.getOperationSpinner();
    }

    private void detection() {
        addNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    LogUtils.i("获取焦点");
                } else {
                    String etNum = addNum.getText().toString();
                    iAddWcPresenter.checkMarkNoToilet(etNum);
                }
            }
        });
        addGrade.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    LogUtils.i("获取焦点");
                } else {
                    String etNum = addGrade.getText().toString();
                    iAddWcPresenter.checkNumberToilet(etNum);
                }
            }
        });
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
                    add12.setText(blockName);
                    break;
                //所属社区
                case ADD_COMMUNITY:
                    String communityName = data.getStringExtra("name");
                    communityId = data.getStringExtra("id");
                    add13.setText(communityName);
                    break;
                //分管领导
                case ADD_LEADER:
                    String leaderName = data.getStringExtra("name");
                    leaderId = data.getStringExtra("id");
                    a.setText(leaderName);
                    break;
                //所属场队
                case ADD_PLACE:
                    placeId = data.getStringExtra("id");
                    String name = data.getStringExtra("name");
                    addPlace.setText(name);
                    break;
                //场队负责人
                case ADD_PRINCIPAL:
                    String name1 = data.getStringExtra("name");
                    principalId = data.getStringExtra("id");
                    addPrincipal.setText(name1);
                    break;
                //所属分队
                case ADD_ELEMENT:
                    elementId = data.getStringExtra("id");
                    String elementName = data.getStringExtra("name");
                    addElement.setText(elementName);
                    break;
                //分队负责人
                case ADD_ELEMENT_PRINCIPAL:
                    String name2 = data.getStringExtra("name");
                    elementPrincipalId = data.getStringExtra("id");
                    addElementPrincipal.setText(name2);
                    break;
                //所属班组
                case ADD_CLASS:
                    classId = data.getStringExtra("id");
                    String className = data.getStringExtra("name");
                    addClass.setText(className);
                    break;
                //班组负责人
                case ADD_CLASS_PRINCIPAL:
                    String name3 = data.getStringExtra("name");
                    classPrincipalId = data.getStringExtra("id");
                    addClassPrincipal.setText(name3);
                    break;


                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    if (addOnePic.getType() == INS_WCAdd_ONEPIC) {
                        //单张图片
                        selectList = PictureSelector.obtainMultipleResult(data);
                        for (LocalMedia media : selectList) {
                            LogUtils.i("图片-----》" + media.getPath());
                            if (media.isCompressed()) {
                                toiletPhoto = media.getCompressPath();//压缩之后的图片
                            }

                        }
                        toiletPhotoFile = chageToiletFileName(toiletPhoto);
                        LogUtils.i(toiletPhotoFile.getPath());
                        adapter.setList(selectList);
                        adapter.notifyDataSetChanged();
                        addOnePic.setType(0);
                    }
                    if (addMuchPic.getType() == INS_WCAdd_MUCHPIC) {
                        //多张图片
                        selectList1 = PictureSelector.obtainMultipleResult(data);
                        // 例如 LocalMedia 里面返回三种path
                        // 1.media.getPath(); 为原图path
                        // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                        // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                        // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                        for (LocalMedia media : selectList1) {
                            LogUtils.i("图片-----》" + media.getPath());
                            if (media.isCompressed()) {
                                toiletsAroundPhoto = media.getCompressPath();//压缩之后的图片
                            }
                            File toiletsAroundPhotoFile = chageToiletsFileName(toiletsAroundPhoto);
                            toiletsAroundPhotos.add(toiletsAroundPhotoFile);
                        }
                        adapters.setList(selectList1);
                        adapters.notifyDataSetChanged();
                        addMuchPic.setType(0);
                    }
                    break;
            }
        }
    }


    public void getDate(final int a) {
        pvTime = getTime();
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date) {
                switch (a) {
                    case add_7:
                        add7.setText(setTime(date));
                        break;
                    case add_9:
                        add9.setText(setTime(date));
                        break;
                    case add_10:
                        add10.setText(setTime(date));
                        break;

                }
            }
        });
        //显示
        showTime();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissTime();

    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    //判断编号是否可用
    @Override
    public void showAddNum(String data) {
        if (data.equals("1")) {
            checkMark = true;
            ToastUtil.showToast(AddBasicsWcActivity.this, "编号可用");
        }
    }

    //判断标号是否可用
    @Override
    public void showAddNumber(String data) {
        if (data.equals("1")) {
            checkNumber = true;
            ToastUtil.showToast(AddBasicsWcActivity.this, "标号可用");
        }
    }


    //基础objectKey
    @Override
    public void showObjectKeySpinner(final List<FindBaseIdBean.InfosBean> list) {
        mSpinerPopWindow = new SpinnerPopWindow<FindBaseIdBean.InfosBean>(this, "200505", list, new OnItemClickListener<FindBaseIdBean.InfosBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, FindBaseIdBean.InfosBean data, int position) {
                addOkey.setText(data.getObjectKey1());
                objectKeyId = data.getId();
                mSpinerPopWindow.dismiss();
            }
        }
        );
        mSpinerPopWindow.setNewData(list);
        if (addOkey != null) {
            addOkey.setText(list.get(0).getObjectKey1());
            objectKeyId = list.get(0).getId();
        }
//        mSpinerPopWindow.setOnDismissListener(dismissListener);

//        SpinnerFindBaseIdAdapter spAdapter = new SpinnerFindBaseIdAdapter(AddBasicsWcActivity.this, list);
//        addOkey.setAdapter(spAdapter);
//        addOkey.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                FindBaseIdBean.InfosBean in = (FindBaseIdBean.InfosBean) addOkey.getSelectedItem();
//                objectKeyId = in.getId();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }

    //作业公司
    @Override
    public void showWorkCompanySpinner(List<WorkCompanyBean.InfosBean> list) {
        SpinnerWorkCompanyAdapter spAdapter = new SpinnerWorkCompanyAdapter(AddBasicsWcActivity.this, list);
        if (addCompany != null) {
            addCompany.setAdapter(spAdapter);
        addCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                WorkCompanyBean.InfosBean in = (WorkCompanyBean.InfosBean) addCompany.getSelectedItem();
                workCompanyId = in.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }
    }

    //种类
    @Override
    public void showTioletClassSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList) {
        SpinnersAdapter spAdapter = new SpinnersAdapter(AddBasicsWcActivity.this, spinnerBeanList);
        if (addKind != null) {
            addKind.setAdapter(spAdapter);
        addKind.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AddSpinnerBean.InfosBean info = (AddSpinnerBean.InfosBean) addKind.getSelectedItem();
                tioletClassId = info.getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }

    }

    //产权权属
    @Override
    public void showPropertyRightSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList) {
        SpinnersAdapter spAdapter = new SpinnersAdapter(AddBasicsWcActivity.this, spinnerBeanList);
        if (add1 != null) {
            add1.setAdapter(spAdapter);
        add1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AddSpinnerBean.InfosBean info = (AddSpinnerBean.InfosBean) add1.getSelectedItem();
                propertyRightId = info.getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }
    }

    //公厕类别
    @Override
    public void showTioletTypeSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList) {
        SpinnersAdapter spAdapter = new SpinnersAdapter(AddBasicsWcActivity.this, spinnerBeanList);
        if (addWcClassify != null) {
            addWcClassify.setAdapter(spAdapter);
        addWcClassify.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AddSpinnerBean.InfosBean info = (AddSpinnerBean.InfosBean) addWcClassify.getSelectedItem();
                tioletTypeId = info.getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }
    }

    //公厕等级
    @Override
    public void showTioletLevelSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList) {
        SpinnersAdapter spAdapter = new SpinnersAdapter(AddBasicsWcActivity.this, spinnerBeanList);
        if (addWcClass != null) {
            addWcClass.setAdapter(spAdapter);
        addWcClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AddSpinnerBean.InfosBean info = (AddSpinnerBean.InfosBean) addWcClass.getSelectedItem();
                tioletLevelId = info.getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }
    }

    //有无障碍设施
    @Override
    public void showBarrierFacilitiesSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList) {
        SpinnersAdapter spAdapter = new SpinnersAdapter(AddBasicsWcActivity.this, spinnerBeanList);
        if (add2 != null) {
            add2.setAdapter(spAdapter);

            add2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AddSpinnerBean.InfosBean info = (AddSpinnerBean.InfosBean) add2.getSelectedItem();
                    barrierFacilitiesId = info.getValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    // 管理形式
    @Override
    public void showManageTypeSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList) {
        SpinnersAdapter spAdapter = new SpinnersAdapter(AddBasicsWcActivity.this, spinnerBeanList);
        if (add4 != null) {
            add4.setAdapter(spAdapter);

        add4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AddSpinnerBean.InfosBean info = (AddSpinnerBean.InfosBean) add4.getSelectedItem();
                manageTypeId = info.getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }
    }

    // 区域
    @Override
    public void showAreaTypeSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList) {
        SpinnersAdapter spAdapter = new SpinnersAdapter(AddBasicsWcActivity.this, spinnerBeanList);
        if (addArea != null) {
            addArea.setAdapter(spAdapter);
        addArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AddSpinnerBean.InfosBean info = (AddSpinnerBean.InfosBean) addArea.getSelectedItem();
                areaTypeId = info.getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }
    }

    //审核操作
    @Override
    public void showOperationSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList) {
        SpinnersAdapter spAdapter = new SpinnersAdapter(AddBasicsWcActivity.this, spinnerBeanList);
        if (addOperation != null) {
            addOperation.setAdapter(spAdapter);
        addOperation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AddSpinnerBean.InfosBean info = (AddSpinnerBean.InfosBean) addOperation.getSelectedItem();
                operationId = info.getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    }


    @OnClick({R.id.top_finish, R.id.a, R.id.add_place, R.id.add_principal, R.id.add_okey,
            R.id.add_element, R.id.add_element_principal, R.id.add_class, R.id.add_class_principal,
            R.id.add_7, R.id.add_9, R.id.add_10, R.id.add_12, R.id.add_13, R.id.add_})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_7:
                getDate(add_7);
                break;
            case R.id.add_9:
                getDate(add_9);
                break;
            case R.id.add_10:
                getDate(add_10);
                break;
            case R.id.add_okey:
//                mSpinerPopWindow.setWidth(addOkey.getWidth());
                if(mSpinerPopWindow!=null){
                    mSpinerPopWindow.showAsDropDown(addOkey);
                }
                break;
            case R.id.add_12://所属街乡
                i.setClass(AddBasicsWcActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_BLOCK);
                startActivityForResult(i, ADD_BLOCK);
                break;
            case R.id.add_13://所属社区
                i.setClass(AddBasicsWcActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_COMMUNITY);
                startActivityForResult(i, ADD_COMMUNITY);
                break;
            case R.id.a://分管领导
                i.setClass(AddBasicsWcActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_LEADER);
                startActivityForResult(i, ADD_LEADER);
                break;
            case R.id.add_place://场队
                i.setClass(AddBasicsWcActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_PLACE);
                startActivityForResult(i, ADD_PLACE);
                break;
            case R.id.add_principal://场队负责人
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddBasicsWcActivity.this, "请先选择场对");
                    return;
                } else
                    i.setClass(AddBasicsWcActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_PRINCIPAL);
                i.putExtra("placeId", placeId);
                startActivityForResult(i, ADD_PRINCIPAL);
                break;
            case R.id.add_element://分队
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddBasicsWcActivity.this, "请先选择场对");
                    return;
                } else
                    i.setClass(AddBasicsWcActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_ELEMENT);
                i.putExtra("placeId", placeId);
                startActivityForResult(i, ADD_ELEMENT);
                break;
            case R.id.add_element_principal://分队负责人
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddBasicsWcActivity.this, "请先选择场对");
                    return;
                } else
                    i.setClass(AddBasicsWcActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_ELEMENT_PRINCIPAL);
                i.putExtra("placeId", placeId);
                startActivityForResult(i, ADD_ELEMENT_PRINCIPAL);
                break;
            case R.id.add_class://班组
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddBasicsWcActivity.this, "请先选择场对");
                    return;
                } else if (TextUtils.isEmpty(elementId)) {
                    ToastUtil.showToast(AddBasicsWcActivity.this, "请先选择分对");
                    return;
                } else
                    i.setClass(AddBasicsWcActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_CLASS);
                i.putExtra("placeId", placeId);
                i.putExtra("elementId", elementId);
                startActivityForResult(i, ADD_CLASS);
                break;
            case R.id.add_class_principal://班组负责人
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddBasicsWcActivity.this, "请先选择场对");
                    return;
                } else if (TextUtils.isEmpty(elementId)) {
                    ToastUtil.showToast(AddBasicsWcActivity.this, "请先选择分对");
                    return;
                } else if (TextUtils.isEmpty(classId)) {
                    ToastUtil.showToast(AddBasicsWcActivity.this, "请先选择班组");
                    return;
                } else
                    i.setClass(AddBasicsWcActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_CLASS_PRINCIPAL);
                i.putExtra("placeId", placeId);
                i.putExtra("elementId", elementId);
                i.putExtra("classId", classId);
                startActivityForResult(i, ADD_CLASS_PRINCIPAL);
                break;

            case R.id.top_finish:
                finish();
                break;
            case R.id.add_:
                String number = addNum.getText().toString();//编号
                String markNo = addGrade.getText().toString();//标号
                String name = addName.getText().toString();//名称
                String checkName = addName1.getText().toString();//公厕名
                String belongArea = addSite.getText().toString();//所属区域
                String manageUnit = addUnit.getText().toString();//管理单位
                String checkArea = addInspectionSite.getText().toString();//检查区域
                String leader = addMancount.getText().toString();//男
                String fieldTeam = addWomancount.getText().toString();//女
                String fieldTeamManager = addCount.getText().toString();//残疾人
                String fieldUnit = addCounts.getText().toString();//站位合计
                String fieldUnitManager = add5.getText().toString();//管理员人数
                String workTeam = add6.getText().toString();//建筑面积
                String accessUseTime = add7.getText().toString();//接入使用时间
                String operationSituation = add8.getText().toString();//运行情况
                String openCloseTime = add9.getText().toString();//开关门时间
                String submitAuditTime = add10.getText().toString();//提交审核时间
                String selfCheck = add11.getText().toString();//自查
                String dataSource = add14.getText().toString();//数据来源
                String remark = addNote.getText().toString();//备注信息
                if (checkMark && checkNumber) {
                    LogUtils.i(toiletPhoto);
                    LogUtils.i(toiletsAroundPhotos.toString());
                    iAddWcPresenter.saveMessage(userId, number, markNo, name, checkName, belongArea, manageUnit, workCompanyId, "", checkArea,
                            tioletTypeId, tioletLevelId, leader, fieldTeam, fieldTeamManager, fieldUnit, barrierFacilitiesId, manageTypeId,
                            fieldUnitManager, workTeam, operationSituation, openCloseTime, toiletPhoto, toiletPhotoFile, toiletsAroundPhoto,
                            toiletsAroundPhotos, accessUseTime, submitAuditTime, tioletClassId, propertyRightId, leaderId, placeId, principalId,
                            elementId, elementPrincipalId, classId, classPrincipalId, areaTypeId, selfCheck, blockId, communityId, remark, "", "",
                            dataSource, "", objectKeyId, "", "", operationId, "", "", "", "", ""
                    );
                } else {
                    ToastUtil.showToast(AddBasicsWcActivity.this, "请输入详细");
                }
                break;
        }
    }


    //提交保存
    @Override
    public void showSaveMessage(String s) {
        if (s.equals("1")) {
            ToastUtil.showToast(AddBasicsWcActivity.this, "保存成功");
            if (toiletPhoto != null) {
                toiletPhotoFile.delete();
            }
            if (toiletsAroundPhotos.size() > 0) {
                for (int i = 0; i < toiletsAroundPhotos.size(); i++) {
                    toiletsAroundPhotos.get(i).delete();
                }
            }
            PictureFileUtils.deleteCacheDirFile(AddBasicsWcActivity.this);
            delFile(new File(getPath()));
            finish();
        }

    }

}
