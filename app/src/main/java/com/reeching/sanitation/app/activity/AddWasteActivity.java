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
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.jiangyy.easydialog.LoadingDialog;
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
import com.reeching.sanitation.app.contract.AddWasteContract;
import com.reeching.sanitation.app.presenter.IAddWastePresenter;
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
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

import static com.reeching.sanitation.R.id.add_waste1;
import static com.reeching.sanitation.R.id.add_waste18;
import static com.reeching.sanitation.R.id.add_waste6;
import static com.reeching.sanitation.R.id.top_name;
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
import static com.reeching.sanitation.app.util.FileUtil.chageWasteFileName;
import static com.reeching.sanitation.app.util.FileUtil.chageWastesFileName;
import static com.reeching.sanitation.app.util.FileUtil.delFile;
import static com.reeching.sanitation.app.util.FileUtil.getPath;

/**
 * 垃圾楼添加
 */
public class AddWasteActivity extends BaseAddActivity implements AddWasteContract.View {

    @Bind(R.id.top_finish)
    ImageView topFinish;
    @Bind(top_name)
    TextView topName;
    @Bind(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @Bind(add_waste1)
    EditText addWaste1;
    @Bind(R.id.add_waste2)
    EditText addWaste2;
    @Bind(R.id.add_waste3)
    EditText addWaste3;
    @Bind(R.id.add_waste4)
    TextView addWaste4;
    @Bind(R.id.add_waste5)
    EditText addWaste5;
    @Bind(add_waste6)
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
    @Bind(add_waste18)
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
    @Bind(R.id.add_waste_textView1)
    TextView addWasteTextView1;
    @Bind(R.id.add_)
    Button add;

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
    IAddWastePresenter iAddWastePresenter;
    Intent i = new Intent();
    private String workCompanyId;//作业公司
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
    private String toiletPhoto;//照片
    private File toiletPhotoFile;
    private SpinnerPopWindow<FindBaseIdBean.InfosBean> mSpinerPopWindow;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_waste;
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

        userId = SharedPreferencesUtil.getInstance().getString("userId");
        topName.setText(R.string.ins_addwaste);
    }

    @Override
    public void configViews() {
        iAddWastePresenter.attachView(this);
        detection();//检测是否标号/编号可用
        setSpinner();//下拉框
    }

    private void setSpinner() {
        iAddWastePresenter.getObjectKeySpinner();
        iAddWastePresenter.getWorkCompanySpinner();
        iAddWastePresenter.getAreaTypeSpinner();
        iAddWastePresenter.getPropertyRightSpinner();
    }

    @Override
    public void initPicture() {
        FullyGridLayoutManager manager = new FullyGridLayoutManager(AddWasteActivity.this, 4, GridLayoutManager.VERTICAL, false);
        FullyGridLayoutManager manager1 = new FullyGridLayoutManager(AddWasteActivity.this, 4, GridLayoutManager.VERTICAL, false);
        addWasteRecycler.setLayoutManager(manager);
        addWasteRecycler1.setLayoutManager(manager1);

        addOnePic = new AddOnePic(AddWasteActivity.this);//单个图片
        addMuchPic = new AddMuchPic(AddWasteActivity.this);//多张图片
        adapter = new GridImageAdapter(AddWasteActivity.this, addOnePic);
        adapters = new GridImagesAdapter(AddWasteActivity.this, addMuchPic);
        adapter.setList(selectList);
        adapters.setList(selectList1);
        adapter.setSelectMax(1);
        adapters.setSelectMax(maxSelectNum);
        addWasteRecycler.setAdapter(adapter);
        addWasteRecycler1.setAdapter(adapters);
    }

    private void detection() {
        addWaste1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    LogUtils.i("获取焦点");
                } else {
                    String etNum = addWaste1.getText().toString();
                    iAddWastePresenter.checkMarkNoToilet(etNum);
                }
            }
        });
        addWaste3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    LogUtils.i("获取焦点");
                } else {
                    String etNum = addWaste3.getText().toString();
                    iAddWastePresenter.checkNumberToilet(etNum);
                }
            }
        });
    }

    @OnClick({R.id.top_finish, R.id.add_waste4,R.id.add_, add_waste18,R.id.add_waste19,R.id.add_waste7,R.id.add_waste8,R.id.add_waste9,R.id.add_waste10,R.id.add_waste11,R.id.add_waste12,R.id.add_waste13})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case add_waste18://所属街乡
                i.setClass(AddWasteActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_BLOCK);
                startActivityForResult(i, ADD_BLOCK);
                break;
            case R.id.add_waste19://所属社区
                i.setClass(AddWasteActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_COMMUNITY);
                startActivityForResult(i, ADD_COMMUNITY);
                break;
            case R.id.add_waste7://分管领导
                i.setClass(AddWasteActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_LEADER);
                startActivityForResult(i, ADD_LEADER);
                break;
            case R.id.add_waste8://场队
                i.setClass(AddWasteActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_PLACE);
                startActivityForResult(i, ADD_PLACE);
                break;
            case R.id.add_waste9://场队负责人
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddWasteActivity.this, "请先选择场对");
                    return;
                } else
                    i.setClass(AddWasteActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_PRINCIPAL);
                i.putExtra("placeId", placeId);
                startActivityForResult(i, ADD_PRINCIPAL);
                break;
            case R.id.add_waste10://分队
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddWasteActivity.this, "请先选择场对");
                    return;
                } else
                    i.setClass(AddWasteActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_ELEMENT);
                i.putExtra("placeId", placeId);
                startActivityForResult(i, ADD_ELEMENT);
                break;
            case R.id.add_waste11://分队负责人
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddWasteActivity.this, "请先选择场对");
                    return;
                } else
                    i.setClass(AddWasteActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_ELEMENT_PRINCIPAL);
                i.putExtra("placeId", placeId);
                startActivityForResult(i, ADD_ELEMENT_PRINCIPAL);
                break;
            case R.id.add_waste12://班组
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddWasteActivity.this, "请先选择场对");
                    return;
                } else if (TextUtils.isEmpty(elementId)) {
                    ToastUtil.showToast(AddWasteActivity.this, "请先选择分对");
                    return;
                } else
                    i.setClass(AddWasteActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_CLASS);
                i.putExtra("placeId", placeId);
                i.putExtra("elementId", elementId);
                startActivityForResult(i, ADD_CLASS);
                break;
            case R.id.add_waste13://班组负责人
                if (TextUtils.isEmpty(placeId)) {
                    ToastUtil.showToast(AddWasteActivity.this, "请先选择场对");
                    return;
                } else if (TextUtils.isEmpty(elementId)) {
                    ToastUtil.showToast(AddWasteActivity.this, "请先选择分对");
                    return;
                } else if (TextUtils.isEmpty(classId)) {
                    ToastUtil.showToast(AddWasteActivity.this, "请先选择班组");
                    return;
                } else i.setClass(AddWasteActivity.this, AddLeaderActivity.class);
                i.putExtra("type", ADD_CLASS_PRINCIPAL);
                i.putExtra("placeId", placeId);
                i.putExtra("elementId", elementId);
                i.putExtra("classId", classId);
                startActivityForResult(i, ADD_CLASS_PRINCIPAL);
                break;
            case R.id.top_finish:
                finish();
                break;
            case R.id.add_waste4:
//                mSpinerPopWindow.setWidth(addWaste4.getWidth());
                if(mSpinerPopWindow!=null){
                    mSpinerPopWindow.showAsDropDown(addWaste4);
                }
                break;
            
            case R.id.add_:
                String markNo=addWaste1.getText().toString();
                String rubbishName=addWaste2.getText().toString();
                String rubbishNo=addWaste3.getText().toString();
                String remark=addWaste1.getText().toString();
                String selfCheck=addWaste16.getText().toString();
                String belongGrid=addWaste20.getText().toString();
                if (checkMark&&checkNumber){
                    iAddWastePresenter.saveMessage(userId,objectKeyId,markNo,rubbishName,rubbishNo,"","","",propertyRightId,leaderId,
                    placeId,principalId,elementId,elementPrincipalId,classId,classPrincipalId,selfCheck,workCompanyId,blockId,
                    communityId,belongGrid,toiletPhoto,toiletsAroundPhoto,areaTypeId,"","",remark,toiletPhotoFile,toiletsAroundPhotos);
                }else {
                    ToastUtil.showToast(AddWasteActivity.this,"请输入详细");
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
                    addWaste18.setText(blockName);
                    break;
                //所属社区
                case ADD_COMMUNITY:
                    String communityName = data.getStringExtra("name");
                    communityId = data.getStringExtra("id");
                    addWaste19.setText(communityName);
                    break;
                //分管领导
                case ADD_LEADER:
                    String leaderName = data.getStringExtra("name");
                    leaderId = data.getStringExtra("id");
                    addWaste7.setText(leaderName);
                    break;
                //所属场队
                case ADD_PLACE:
                    placeId = data.getStringExtra("id");
                    String name = data.getStringExtra("name");
                    addWaste8.setText(name);
                    break;
                //场队负责人
                case ADD_PRINCIPAL:
                    String name1 = data.getStringExtra("name");
                    principalId = data.getStringExtra("id");
                    addWaste9.setText(name1);
                    break;
                //所属分队
                case ADD_ELEMENT:
                    elementId = data.getStringExtra("id");
                    String elementName = data.getStringExtra("name");
                    addWaste10.setText(elementName);
                    break;
                //分队负责人
                case ADD_ELEMENT_PRINCIPAL:
                    String name2 = data.getStringExtra("name");
                    elementPrincipalId = data.getStringExtra("id");
                    addWaste11.setText(name2);
                    break;
                //所属班组
                case ADD_CLASS:
                    classId = data.getStringExtra("id");
                    String className = data.getStringExtra("name");
                    addWaste12.setText(className);
                    break;
                //班组负责人
                case ADD_CLASS_PRINCIPAL:
                    String name3 = data.getStringExtra("name");
                    classPrincipalId = data.getStringExtra("id");
                    addWaste13.setText(name3);
                    break;


                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    if (addOnePic.getType() == INS_WCAdd_ONEPIC) {
                        //单张图片
                        selectList = PictureSelector.obtainMultipleResult(data);
                        for (LocalMedia media : selectList) {
                            LogUtils.i("图片-----》"+media.getPath());
                            if(media.isCompressed()){
                                toiletPhoto = media.getCompressPath();//压缩之后的图片
                            }
                            LogUtils.i(chageWasteFileName(toiletPhoto).getPath());
                        }
                        toiletPhotoFile=chageWasteFileName(toiletPhoto);
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
                            LogUtils.i("图片-----》"+ media.getPath());
                            if(media.isCompressed()){
                                toiletsAroundPhoto = media.getCompressPath();//压缩之后的图片
                            }
                            File toiletsAroundPhotoFile = chageWastesFileName(toiletsAroundPhoto);
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
            ToastUtil.showToast(AddWasteActivity.this, "标号可用");
        }
    }

    @Override
    public void showAddNumber(String data) {
        if (data.equals("1")) {
            checkNumber = true;
            ToastUtil.showToast(AddWasteActivity.this, "编号可用");
        }
    }

    @Override
    public void showObjectKeySpinner(List<FindBaseIdBean.InfosBean> list) {
        mSpinerPopWindow = new SpinnerPopWindow<FindBaseIdBean.InfosBean>(this,"300507", list, new OnItemClickListener<FindBaseIdBean.InfosBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, FindBaseIdBean.InfosBean data, int position) {
                addWaste4.setText(data.getObjectKey1());
                objectKeyId = data.getId();
                mSpinerPopWindow.dismiss();
            }
        }
        );
        mSpinerPopWindow.setNewData(list);
        if (addWaste4!=null){
            addWaste4.setText(list.get(0).getObjectKey1());
            objectKeyId=list.get(0).getId();
        }


//        SpinnerFindBaseIdAdapter spAdapter = new SpinnerFindBaseIdAdapter(AddWasteActivity.this, list);
//        addWaste4.setAdapter(spAdapter);
//        addWaste4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                FindBaseIdBean.InfosBean in = (FindBaseIdBean.InfosBean) addWaste4.getSelectedItem();
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
        SpinnerWorkCompanyAdapter spAdapter = new SpinnerWorkCompanyAdapter(AddWasteActivity.this, list);
        if (addWaste17!=null){
            addWaste17.setAdapter(spAdapter);

        addWaste17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                WorkCompanyBean.InfosBean in = (WorkCompanyBean.InfosBean) addWaste17.getSelectedItem();
                workCompanyId = in.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }
    }

    @Override
    public void showAreaTypeSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList) {
        SpinnersAdapter spAdapter = new SpinnersAdapter(AddWasteActivity.this, spinnerBeanList);
        if (addWaste14!=null){
            addWaste14.setAdapter(spAdapter);
        addWaste14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AddSpinnerBean.InfosBean info = (AddSpinnerBean.InfosBean) addWaste14.getSelectedItem();
                areaTypeId = info.getValue();
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
        SpinnersAdapter spAdapter = new SpinnersAdapter(AddWasteActivity.this, spinnerBeanList);
        if (addWaste6!=null){
            addWaste6.setAdapter(spAdapter);
        addWaste6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AddSpinnerBean.InfosBean info = (AddSpinnerBean.InfosBean) addWaste6.getSelectedItem();
                propertyRightId = info.getValue();
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
            ToastUtil.showToast(AddWasteActivity.this, "保存成功");
            if (toiletPhoto!=null){
                toiletPhotoFile.delete();
            }if (toiletsAroundPhotos.size()>0){
                for (int i=0;i<toiletsAroundPhotos.size();i++){
                    toiletsAroundPhotos.get(i).delete();
                }
            }
            PictureFileUtils.deleteCacheDirFile(AddWasteActivity.this);
            delFile(new File(getPath()));
            finish();
        }
    }



}
