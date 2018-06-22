package com.reeching.sanitation.app.activity.two;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.activity.AddLeaderActivity;
import com.reeching.sanitation.app.activity.LoginActivity;
import com.reeching.sanitation.app.adapter.HomeImagerAdapter;
import com.reeching.sanitation.app.bean.BannerBean;
import com.reeching.sanitation.app.bean.HomeImageBean;
import com.reeching.sanitation.app.bean.Model;
import com.reeching.sanitation.app.util.ActivityUtil;
import com.reeching.sanitation.app.util.GlideImageLoader;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.reeching.sanitation.app.contant.Contants.GETINDEXPHOTOLIST;
import static com.reeching.sanitation.app.contant.Contants.LEADERCHECKPAGE;
import static com.reeching.sanitation.app.contant.Contants.SERVIECE;
import static com.reeching.sanitation.app.util.ActivityUtil.openAct;

public class HomeActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.nav_view)
    NavigationView navigationView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.gridView)
    GridView gridView;
    @Bind(R.id.home_web)
    WebView home_web;
    @Bind(R.id.home_lin)
    LinearLayout home_lin;
    Integer[] urls = {
            R.drawable.banner3
    };
    private HomeImagerAdapter mGridAdapter;
    private List<HomeImageBean> ImageList;
    private String typename;
    private int icon;
    private HomeImageBean Image;
    private String roleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        String name = SharedPreferencesUtil.getInstance().getString("name");
        roleName = SharedPreferencesUtil.getInstance().getString("roleName");
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        mGridAdapter = new HomeImagerAdapter(this);
        gridView.setAdapter(mGridAdapter);
        GetTypeList();
        navigationView.setNavigationItemSelectedListener(this);

        View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header);
        TextView my_name=headerLayout.findViewById(R.id.my_name);
        TextView my_email=headerLayout.findViewById(R.id.my_email);
        my_name.setText(name);
        my_email.setText(roleName);
        setBanner();
    }

    private void setBanner() {
        OkGo.<BannerBean>post(GETINDEXPHOTOLIST).tag(this)
                .execute(new JsonCallback<BannerBean>(BannerBean.class) {

                    @Override
                    public void onSuccess(Response<BannerBean> response) {
                        BannerBean BannerBean = response.body();
                        if (BannerBean.getResult().equals("1")) {
                            BannerBean.InfosBean info = BannerBean.getInfos();
                            String sourceStr = info.getPhoto();
                            String[] sourceStrArray = sourceStr.split("\\|");
                            List<String> lists = new ArrayList<String>();
                            for (int ii = 1; ii < sourceStrArray.length; ii++) {
                                String str = sourceStrArray[ii];
                                if (!TextUtils.isEmpty(str)){
                                    lists.add(SERVIECE +str);
                                }
                            }
                            //设置图片集合
                            banner.setImages(lists);
                            //设置图片加载器
                            banner.setImageLoader(new GlideImageLoader());
                            //banner.setOnBannerClickListener(this);
                            banner.start();
                        }
                    }

                    @Override
                    public void onCacheSuccess(Response<BannerBean> response) {
                        super.onCacheSuccess(response);
                        onSuccess(response);
                    }

                    @Override
                    public void onError(Response<BannerBean> response) {
                        super.onError(response);
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();

                    }
                });

//        List list = Arrays.asList(urls);
//        ArrayList images = new ArrayList(list);
//        //banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
//        //设置图片集合
//        banner.setImages(images);
//        //设置图片加载器
//        banner.setImageLoader(new GlideImageLoader());
//        //banner.setOnBannerClickListener(this);
//        banner.start();
    }

    private void GetTypeList() {
        ImageList = new ArrayList<HomeImageBean>();
        if ("基层角色".equals(roleName)){//没有审核功能
            for (int i = 0; i < Model.iconList.length-1; i++) {
                typename = Model.toolsList[i];
                icon = Model.iconList[i];
                Image = new HomeImageBean(i, typename, icon);
                ImageList.add(Image);
            }
        }else if ("管理角色".equals(roleName)){
            for (int i = 0; i < Model.iconList.length; i++) {
                typename = Model.toolsList[i];
                icon = Model.iconList[i];
                Image = new HomeImageBean(i, typename, icon);
                ImageList.add(Image);
            }
        }else if ("领导角色".equals(roleName)){
            home_lin.setVisibility(View.GONE);
            home_web.setVisibility(View.VISIBLE);
            home_web.getSettings().setJavaScriptEnabled(true);
            home_web.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    // TODO Auto-generated method stub
                    //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                    view.loadUrl(url);
                    return true;
                }
            });
            home_web.loadUrl(LEADERCHECKPAGE);
        }

        mGridAdapter.setData(ImageList);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    //公厕管理
                    case 0:
                        openAct(HomeActivity.this, WcActivity.class);
                        break;
                    //道路管理
                    case 1:
                        openAct(HomeActivity.this, RoadActivity.class);
                        break;
                    //垃圾管理
                    case 2:
                        openAct(HomeActivity.this, WasteActivity.class);

                        break;
                    //人员管理
                    case 3:
                        openAct(HomeActivity.this, PeopleActivity.class);
                        break;
                    //网格案件
                    case 4:
                        ActivityUtil.openAct(HomeActivity.this, Mova_BasicActivity.class);
                        break;
                    //待审核
                    case 5:
                        ActivityUtil.openAct(HomeActivity.this, AddLeaderActivity.Basics_InspectActivity.class);

                        break;

                }


            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            onBackPressed();
        } else if (id == R.id.nav_gallery) {//设置

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {//注销
            SharedPreferencesUtil.getInstance().removeAll();
            ActivityUtil.openAct(HomeActivity.this,LoginActivity.class);
            finish();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void main(int[] ary){
        int m;
        for (int i=0;i<ary.length;i++ ){
            for (int j=ary.length-1;j>i;j--){
                if (ary[j]<ary[j-1]){
                    m=ary[j];
                    ary[j]=ary[j-1];
                    ary[j-1]=m;
                }
            }
        }


    }
}
