package com.reeching.sanitation.app.activity.two;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.adapter.PaymentdetailsGridAdapter;
import com.reeching.sanitation.app.adapter.PaymentdetailsListRecycleAdapter;
import com.reeching.sanitation.app.adapter.PaymentdetailsPRecycleAdapter;
import com.reeching.sanitation.app.bean.CaseDetailBean;
import com.reeching.sanitation.app.bean.CaseProcessListBean;
import com.reeching.sanitation.app.bean.CaseReplyListBean;
import com.reeching.sanitation.app.bean.JsonBean;
import com.reeching.sanitation.app.bean.LeaderBean;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.LogUtils;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;
import com.reeching.sanitation.app.util.ToastUtil;
import com.reeching.sanitation.app.view.FullyLinearLayoutManager;
import com.reeching.sanitation.app.view.MyGridView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.baidu.mapapi.BMapManager.getContext;
import static com.reeching.sanitation.app.contant.Contants.ADDCASEREPLY;
import static com.reeching.sanitation.app.contant.Contants.CASEBILLSELECTS;
import static com.reeching.sanitation.app.contant.Contants.CASEDETAIL;
import static com.reeching.sanitation.app.contant.Contants.CASEPROCESSLIST;
import static com.reeching.sanitation.app.contant.Contants.CASEREPLYLIST;
import static com.reeching.sanitation.app.contant.Contants.DELSELECTS;
import static com.reeching.sanitation.app.contant.Contants.FINDLISTNOMEBELONG;
import static com.reeching.sanitation.app.contant.Contants.GAIPAIUNITOPERATE;
import static com.reeching.sanitation.app.contant.Contants.NOMEAREA;
import static com.reeching.sanitation.app.contant.Contants.NOMEBELONGUNIT;
import static com.reeching.sanitation.app.contant.Contants.REVOKECASE;
import static com.reeching.sanitation.app.contant.Contants.SERVIECE;
import static com.reeching.sanitation.app.contant.Contants.TREEDATALEADER;

/**
 * 挂账详情
 */
public class PaymentdetailsActivity extends AppCompatActivity {

    @Bind(R.id.top_finish)
    ImageView topFinish;
    @Bind(R.id.top_name)
    TextView topName;
    @Bind(R.id.recycler)
    RecyclerView recycler;
    @Bind(R.id.txtedit)
    EditText txtedit;
    @Bind(R.id.recycler_flow_tv)
    TextView recyclerFlowTv;
    @Bind(R.id.photo_tv)
    ImageView photoTv;
    @Bind(R.id.recycler_tv)
    TextView recyclerTv;
    @Bind(R.id.btnpinglun)
    TextView btnpinglun;
    @Bind(R.id.txtbottomshare)
    RelativeLayout txtbottomshare;
    @Bind(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @Bind(R.id.lin1)
    LinearLayout lin1;
    @Bind(R.id.fileNumber)
    TextView fileNumber;
    @Bind(R.id.caseType)
    TextView caseType;
    @Bind(R.id.pointName)
    TextView pointName;
    @Bind(R.id.blameUnit)
    TextView blameUnit;
    @Bind(R.id.accountNo)
    TextView accountNo;
    @Bind(R.id.companyName)
    TextView companyName;
    @Bind(R.id.workType)
    TextView workType;
    @Bind(R.id.belongStreet)
    TextView belongStreet;
    @Bind(R.id.caseDesc)
    TextView caseDesc;
    @Bind(R.id.belongNoMe)
    TextView belongNoMe;
    @Bind(R.id.isBill)
    TextView isBill;
    @Bind(R.id.caseState)
    TextView caseState;
    @Bind(R.id.remark)
    TextView remark;
    @Bind(R.id.grid_photo)
    MyGridView gridPhoto;
    @Bind(R.id.recycler_flow)
    RecyclerView recyclerFlow;
    @Bind(R.id.gaiPai)
    Button gaiPai;
    @Bind(R.id.nomeArea)
    Button nomeArea;
    @Bind(R.id.nomeBelongUnit)
    Button nomeBelongUnit;
    @Bind(R.id.caseBillSelects)
    Button caseBillSelects;
    @Bind(R.id.revokeCase)
    Button revokeCase;
    @Bind(R.id.delSelects)
    Button delSelects;
    private PaymentdetailsListRecycleAdapter mAdapter;
    private PaymentdetailsPRecycleAdapter mProcessAdapter;
    private PaymentdetailsGridAdapter mGridAdapter;
    private String caseGridId;
    List<LeaderBean.InfosBean> dialogList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentdetails);
        ButterKnife.bind(this);
        caseGridId = getIntent().getStringExtra("caseGridId");
        LogUtils.i(caseGridId);
        topName.setText("挂账详情");
        //历史回复布局管理器
        FullyLinearLayoutManager layoutManager = new FullyLinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        //案件流程布局管理器
        FullyLinearLayoutManager layoutManager1 = new FullyLinearLayoutManager(this);
        recyclerFlow.setLayoutManager(layoutManager1);
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerFlow.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new PaymentdetailsListRecycleAdapter(this, null, true);
        mProcessAdapter = new PaymentdetailsPRecycleAdapter(this, null, true);
        mGridAdapter = new PaymentdetailsGridAdapter(PaymentdetailsActivity.this);
        setData();

    }

    private void setData() {
        txtedit.setText("");
        //详情
        OkGo.<CaseDetailBean>post(CASEDETAIL).tag(this)
                .params("id", caseGridId)
                .execute(new JsonCallback<CaseDetailBean>(CaseDetailBean.class) {
                    @Override
                    public void onSuccess(Response<CaseDetailBean> response) {
                        CaseDetailBean caseListBean = response.body();
                        if ("1".equals(caseListBean.getResult())) {
                            CaseDetailBean.InfosBean data = caseListBean.getInfos();
                            String photoUrl = data.getQuestionPhoto();
                            List<String> lists = new ArrayList<String>();
                            if (!TextUtils.isEmpty(photoUrl)) {
                                String sourceStr = photoUrl;
                                String s = String.valueOf(sourceStr.charAt(0));
                                LogUtils.i(s);
                                if (s.equals("|")) {
                                    String[] sourceStrArray = sourceStr.split("\\|");
                                    for (int ii = 1; ii < sourceStrArray.length; ii++) {
                                        String str = sourceStrArray[ii];
                                        if (!TextUtils.isEmpty(str)){
                                            lists.add(SERVIECE +str);
                                        }
                                    }
                                }else {
                                    lists.add(SERVIECE + sourceStr);
                                }
                                LogUtils.i(lists.toString());
                                mGridAdapter.setData(lists);
                                gridPhoto.setAdapter(mGridAdapter);
                            } else {
                                gridPhoto.setVisibility(View.GONE);
                                photoTv.setVisibility(View.VISIBLE);
                            }
                            fileNumber.setText(data.getFileNumber());
                            caseType.setText(data.getWorkType());
                            pointName.setText(data.getPointName());
                            blameUnit.setText(data.getBlameUnit1());
                            accountNo.setText(data.getAccountNo());
                            companyName.setText(data.getCompanyName1());
                            workType.setText(data.getWorkType());
                            belongStreet.setText(data.getBelongStreetName());
                            caseDesc.setText(data.getCaseDesc());
                            belongNoMe.setText(data.getBelongNoMe());
                            isBill.setText(data.getIsBill());
                            caseState.setText(data.getCaseState());
                            remark.setText(data.getRemark());
                        }

                    }

                    @Override
                    public void onError(Response<CaseDetailBean> response) {
                        super.onError(response);
                        ToastUtil.showToast(getContext(), "网络错误");
                    }
                });
        //案件回复历史
        OkGo.<CaseReplyListBean>post(CASEREPLYLIST).tag(this)
                .params("caseGridId", caseGridId)
                .execute(new JsonCallback<CaseReplyListBean>(CaseReplyListBean.class) {
                    @Override
                    public void onSuccess(Response<CaseReplyListBean> response) {
                        CaseReplyListBean caseReplyListBean = response.body();
                        if ("1".equals(caseReplyListBean.getResult())) {
                            List<CaseReplyListBean.InfosBean> data = caseReplyListBean.getInfos();
                            LogUtils.i(data.toString());
                            recycler.setAdapter(mAdapter);
                            mAdapter.setNewData(data);
                        } else {
                            recycler.setVisibility(View.GONE);
                            recyclerTv.setVisibility(View.VISIBLE);
                        }

                    }

                    @Override
                    public void onError(Response<CaseReplyListBean> response) {
                        super.onError(response);
                        ToastUtil.showToast(getContext(), "网络错误");
                    }
                });
        //案件流程列表
        OkGo.<CaseProcessListBean>post(CASEPROCESSLIST).tag(this)
                .params("caseGridId", caseGridId)
                .execute(new JsonCallback<CaseProcessListBean>(CaseProcessListBean.class) {
                    @Override
                    public void onSuccess(Response<CaseProcessListBean> response) {
                        CaseProcessListBean caseProcessListBean = response.body();
                        if ("1".equals(caseProcessListBean.getResult())) {
                            List<CaseProcessListBean.InfosBean> data = caseProcessListBean.getInfos();
                            LogUtils.i(data.toString());
                            recyclerFlow.setAdapter(mProcessAdapter);
                            mProcessAdapter.setNewData(data);
                        } else {
                            mProcessAdapter.loadEnd();//加载完成
                            recyclerFlow.setVisibility(View.GONE);
                            recyclerFlowTv.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onError(Response<CaseProcessListBean> response) {
                        super.onError(response);
                        ToastUtil.showToast(getContext(), "网络错误");
                    }
                });

    }


    private void addReply() {
        String text = txtedit.getText().toString();
        String userId = SharedPreferencesUtil.getInstance().getString("userId");
        if (TextUtils.isEmpty(text)) {
            ToastUtil.showToast(getContext(), "不能为空");
        } else

            OkGo.<String>post(ADDCASEREPLY).tag(this)
                    .params("userId", userId)
                    .params("caseGridId", caseGridId)
                    .params("replyContent", text)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String res = response.body();
                            try {
                                JSONObject jsonObject = new JSONObject(res);
                                if (jsonObject.getString("result").equals("1")) {
                                    setData();
                                }
                                ToastUtil.showToast(getContext(), jsonObject.getString("msg"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                        @Override
                        public void onError(Response<String> response) {
                            super.onError(response);

                        }
                    });


    }

    @OnClick({R.id.txtedit, R.id.btnpinglun, R.id.top_finish, R.id.gaiPai, R.id.nomeArea, R.id.nomeBelongUnit, R.id.caseBillSelects, R.id.revokeCase, R.id.delSelects})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_finish:
                finish();
                break;
            case R.id.btnpinglun:
                //添加回复
                addReply();
                break;
            case R.id.gaiPai:
                //选择场对
                dialog(1);
                break;
            case R.id.nomeArea://非我辖区
                dialog(2);
                break;
            case R.id.nomeBelongUnit://非我权属
                dialog(3);
                break;
            case R.id.caseBillSelects://挂账
                operation(1);
                break;
            case R.id.revokeCase://撤销
                operation(2);
                break;
            case R.id.delSelects://删除
                operation(3);
                break;
        }
    }

    private void operation(int i) {
        switch (i) {
            case 1:
                OkGo.<JsonBean>post(CASEBILLSELECTS).params("ids", caseGridId + ",")
                        .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                            @Override
                            public void onSuccess(Response<JsonBean> response) {
                                JsonBean jsonBean = response.body();
                                if ("1".equals(jsonBean.getResult())) {
                                }
                                ToastUtil.showToast(PaymentdetailsActivity.this, jsonBean.getMsg());
                            }
                        });
                break;
            case 2:
                OkGo.<JsonBean>post(REVOKECASE).params("ids", caseGridId + ",")
                        .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                            @Override
                            public void onSuccess(Response<JsonBean> response) {
                                JsonBean jsonBean = response.body();
                                if ("1".equals(jsonBean.getResult())) {
                                }
                                ToastUtil.showToast(PaymentdetailsActivity.this, jsonBean.getMsg());
                            }
                        });
                break;
            case 3:
                OkGo.<JsonBean>post(DELSELECTS).params("ids", caseGridId + ",")
                        .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                            @Override
                            public void onSuccess(Response<JsonBean> response) {
                                JsonBean jsonBean = response.body();
                                if ("1".equals(jsonBean.getResult())) {
                                }
                                ToastUtil.showToast(PaymentdetailsActivity.this, jsonBean.getMsg());
                            }
                        });
                break;

        }


    }

    //获取场对信息
    private void dialog(final int i) {
        if (i == 3) {
            OkGo.<LeaderBean>post(FINDLISTNOMEBELONG)
                    .tag(this)
                    .params("type", 2)
                    .params("parentIds", "0,1,")
                    .execute(new JsonCallback<LeaderBean>(LeaderBean.class) {
                        @Override
                        public void onSuccess(Response<LeaderBean> response) {
                            LeaderBean lead = response.body();
                            dialogList = lead.getInfos();
                            if ("1".equals(lead.getResult())) {
                                fieldof(i);
                            }
                        }

                        @Override
                        public void onError(Response<LeaderBean> response) {
                            super.onError(response);
                            LogUtils.i(response.code());

                        }
                    });


        } else
            OkGo.<LeaderBean>post(TREEDATALEADER)
                    .tag(this)
                    .params("type", 2)
                    .params("parentIds", "0,1,")
                    .params("pId", 0)
                    .execute(new JsonCallback<LeaderBean>(LeaderBean.class) {
                        @Override
                        public void onSuccess(Response<LeaderBean> response) {
                            LeaderBean lead = response.body();
                            dialogList = lead.getInfos();
                            if ("1".equals(lead.getResult())) {
                                fieldof(i);
                            }
                        }

                        @Override
                        public void onError(Response<LeaderBean> response) {
                            super.onError(response);
                            LogUtils.i(response.code());

                        }
                    });


    }

    private AlertDialog.Builder builder;
    private Dialog dialog;

    private void fieldof(final int i) {
        builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(PaymentdetailsActivity.this).inflate(
                R.layout.dialog_list, null);
        ListView lv_list = (ListView) view.findViewById(R.id.lv_dialog_list);
        builder.setView(view);
//        builder.setCancelable(false);

        // 设置适配器，适配器参数分别为：当前环境、listview中的item、item中的textview、textview所需的数据数据
        lv_list.setAdapter(new ItemDialogAdapter());
        // 为listview中的item设置点击事件
        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ToastUtil.showToast(PaymentdetailsActivity.this, dialogList.get(position).getId() + dialogList.get(position).getName());
                gaipaiUnitOperate(dialogList.get(position).getId(), i);
            }
        });

        // 显示
        dialog = builder.show();
    }

    private void gaipaiUnitOperate(String id, int i) {
        switch (i) {
            case 1:
                OkGo.<JsonBean>post(GAIPAIUNITOPERATE).params("ids", caseGridId + ",")
                        .params("gaipaiUnit", id)
                        .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                            @Override
                            public void onSuccess(Response<JsonBean> response) {
                                JsonBean jsonBean = response.body();
                                if ("1".equals(jsonBean.getResult())) {
                                    dialog.dismiss();
                                    setData();
                                }
                                ToastUtil.showToast(PaymentdetailsActivity.this, jsonBean.getMsg());
                            }
                        });
                break;
            case 2:
                OkGo.<JsonBean>post(NOMEAREA).params("ids", caseGridId + ",")
                        .params("blameUnit", id)
                        .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                            @Override
                            public void onSuccess(Response<JsonBean> response) {
                                JsonBean jsonBean = response.body();
                                if ("1".equals(jsonBean.getResult())) {
                                    dialog.dismiss();
                                    setData();
                                }
                                ToastUtil.showToast(PaymentdetailsActivity.this, jsonBean.getMsg());
                            }
                        });
                break;
            case 3:

                OkGo.<JsonBean>post(NOMEBELONGUNIT).params("ids", caseGridId + ",")
                        .params("belongNoMeId ", id)

                        .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                            @Override
                            public void onSuccess(Response<JsonBean> response) {
                                JsonBean jsonBean = response.body();
                                if ("1".equals(jsonBean.getResult())) {
                                    dialog.dismiss();
                                    setData();
                                }
                                ToastUtil.showToast(PaymentdetailsActivity.this, jsonBean.getMsg());
                            }
                        });
                break;
        }


    }

    class ItemDialogAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return dialogList.size();
        }

        @Override
        public Object getItem(int position) {
            return dialogList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder view;
            if (convertView == null) {
                convertView = View.inflate(PaymentdetailsActivity.this, R.layout.item_dialog_layout, null);
                view = new ViewHolder();
                view.tv = convertView.findViewById(R.id.tv_listview_item);
                convertView.setTag(view);
            } else {
                view = (ViewHolder) convertView.getTag();
            }
            String name = dialogList.get(position).getName();
            view.tv.setText(name);
            return convertView;
        }

        class ViewHolder {
            TextView tv;

//            private ViewHolder(View itemView) {
//                tv = (TextView) itemView.findViewById(R.id.tv_listview_item);
//            }
        }
    }

}
