package com.reeching.sanitation.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.fragment.Basics_InvFragment;
import com.reeching.sanitation.app.bean.LeaderBean;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.LogUtils;

import java.util.List;

import static com.reeching.sanitation.app.contant.Contants.ADD_BLOCK;
import static com.reeching.sanitation.app.contant.Contants.ADD_CLASS;
import static com.reeching.sanitation.app.contant.Contants.ADD_CLASS_PRINCIPAL;
import static com.reeching.sanitation.app.contant.Contants.ADD_COMMUNITY;
import static com.reeching.sanitation.app.contant.Contants.ADD_ELEMENT;
import static com.reeching.sanitation.app.contant.Contants.ADD_ELEMENT_PRINCIPAL;
import static com.reeching.sanitation.app.contant.Contants.ADD_LEADER;
import static com.reeching.sanitation.app.contant.Contants.ADD_PLACE;
import static com.reeching.sanitation.app.contant.Contants.ADD_PRINCIPAL;
import static com.reeching.sanitation.app.contant.Contants.BASICS_INV;
import static com.reeching.sanitation.app.contant.Contants.GETAREAS;
import static com.reeching.sanitation.app.contant.Contants.TREEDATALEADER;

/**
 * 添加页面-分管领导、所属场队、场队负责人、所属分队、分队负责人、分组、分组负责人
 */
public class AddLeaderActivity extends Activity {
    private ListView listView;
    List<LeaderBean.InfosBean> info;
    private MyAdapter adapter;
    private String placeId;//	场队id
    private String elementId;//	分队id
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        listView = findViewById(R.id.listView);
        type = getIntent().getIntExtra("type", -100);
        adapter = new MyAdapter();
        switch (type) {
            case ADD_BLOCK:
                getData(2);//所属街乡
                break;
            case ADD_COMMUNITY:
                getData(3);//所属社区
                break;
            case ADD_LEADER:
                getData(3, "0,",null);//分管领导
                break;
            case ADD_PLACE:
                getData(2, "0,1,",null);//所属场队
                break;
            case ADD_PRINCIPAL:
                placeId=getIntent().getStringExtra("placeId");
                LogUtils.i(placeId);
                if (!placeId.equals("")){
                    getData(3, "0,1,",placeId);//场队负责人
                }
                break;
            case ADD_ELEMENT:
                placeId=getIntent().getStringExtra("placeId");
                if (!placeId.equals("")){
                    getData(2, "0,1,"+placeId+",",null);//所属分队
                }
                break;
            case ADD_ELEMENT_PRINCIPAL:
                placeId=getIntent().getStringExtra("placeId");
                elementId=getIntent().getStringExtra("elementId");
                if (!placeId.equals("")){
                    getData(3, "0,1,"+placeId+ ",",elementId);//分队负责人
                }
                break;
            case ADD_CLASS:
                placeId=getIntent().getStringExtra("placeId");
                elementId=getIntent().getStringExtra("elementId");
                if (!placeId.equals("")){
                    getData(2, "0,1,"+placeId+","+elementId+ ",",null);//所属班组
                }
                break;
            case ADD_CLASS_PRINCIPAL:
                placeId=getIntent().getStringExtra("placeId");
                elementId=getIntent().getStringExtra("elementId");
                String classId = getIntent().getStringExtra("classId");
                if (!placeId.equals("")){
                    getData(3, "0,1,"+placeId+","+elementId+",",classId);//班组负责人
                }
                break;

        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                i.putExtra("id", info.get(position).getId());
                i.putExtra("name", info.get(position).getName());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
    //获取所属街乡/社区
    private void getData(int type) {
        OkGo.<LeaderBean>post(GETAREAS)
                .tag(this)
                .params("type", type)
                .execute(new JsonCallback<LeaderBean>(LeaderBean.class) {
                    @Override
                    public void onSuccess(Response<LeaderBean> response) {
                        LeaderBean lead = response.body();
                        setAdapter(lead);
                    }
                    @Override
                    public void onError(Response<LeaderBean> response) {
                        super.onError(response);
                        LogUtils.i(response.code());

                    }
                });

    }

    /**
     *
     * @param type 类型
     * @param parentIds
     * @param pId
     */
    public void getData(int type, String parentIds,String pId) {
        LogUtils.i(parentIds);
        OkGo.<LeaderBean>post(TREEDATALEADER)
                .tag(this)
                .params("type", type)
                .params("parentIds", parentIds)
                .params("pId", pId )
                .execute(new JsonCallback<LeaderBean>(LeaderBean.class) {
                    @Override
                    public void onSuccess(Response<LeaderBean> response) {
                        LeaderBean lead = response.body();
                        setAdapter(lead);

                    }

                    @Override
                    public void onError(Response<LeaderBean> response) {
                        super.onError(response);
                        LogUtils.i(response.code());

                    }
                });

    }

    private void setAdapter(LeaderBean lead) {
        if (lead.getResult().equals("1")){
            info = lead.getInfos();
            LogUtils.i(info.size());
            adapter = new MyAdapter();
            listView.setAdapter(adapter);
        }
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return info.size();
        }

        @Override
        public Object getItem(int position) {
            return info.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder view = null;
            if (convertView == null) {
                LayoutInflater inflater = AddLeaderActivity.this.getLayoutInflater();
                convertView = inflater
                        .inflate(R.layout.item_list, null);
                view = new Holder();
                view.tv_title = (TextView) convertView
                        .findViewById(R.id.tv);
                convertView.setTag(view);
            }
            view = (Holder) convertView.getTag();
            view.tv_title.setText(info.get(position).getName());
            return convertView;
        }
    }

    class Holder {
        private TextView tv_title;
    }

    /**
     * 基础数据平台--业务监察科页面
     */
    public static class Basics_InspectActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{
        private RadioGroup radioGroup;
        private Fragment fragment;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_basics__inspect);
            //暂时隐藏
            radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
            radioGroup.setOnCheckedChangeListener(this);
            radioGroup.setVisibility(View.GONE);
            fragment = getSupportFragmentManager().findFragmentById(R.id.fragment);

            if (fragment == null) {
                fragment = Basics_InvFragment.newInstance(BASICS_INV);//待审核数据
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment, Basics_InvFragment.newInstance(BASICS_INV)).commit();
            }

        }

        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
    //        switch (checkedId) {
    //            case R.id.tab_one: {
    //                fragment = Basics_InsFragment.newInstance(BASICS_INS);//基础数据
    //            }
    //            break;
    //            case R.id.tab_two: {
    //                fragment = Basics_InvFragment.newInstance(BASICS_INV);//待审查数据
    //            }
    //            break;
    //        }
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
            }
        }


    }
}
