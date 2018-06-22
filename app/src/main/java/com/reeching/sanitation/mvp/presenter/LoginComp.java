package com.reeching.sanitation.mvp.presenter;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.app.bean.LoginBean;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;
import com.reeching.sanitation.mvp.model.UserMode;
import com.reeching.sanitation.mvp.view.ILoginView;

import static com.reeching.sanitation.app.contant.Contants.LOGIN;

/**
 * Created by 绍轩 on 2017/12/11.
 */

public class LoginComp implements ILoginPresenter{
    ILoginView loginView;
    private UserMode user;
    Boolean isLoginSuccess = true;
    public LoginComp(ILoginView loginView){
        this.loginView=loginView;
        initView();
    }

    private void initView() {
        user=new UserMode("","");
    }

    @Override
    public void clear() {
        loginView.onClearText();
    }

    @Override
    public void Login(String name, String paw) {

        final int code = user.checkUserValidity(name,paw);
        if (code!=0) isLoginSuccess = false;
        OkGo.<LoginBean>post(LOGIN).tag(this)
                .params("loginName",name)
                .params("password",paw)
                .execute(new JsonCallback<LoginBean>(LoginBean.class) {
                    @Override
                    public void onSuccess(Response<LoginBean> response) {
                        LoginBean loginBean=response.body();
                        if (loginBean.getResult().equals("1")){
                            SharedPreferencesUtil.getInstance().putString("roleName",loginBean.getRoleName());
                            SharedPreferencesUtil.getInstance().putString("userId",loginBean.getUserId());
                            SharedPreferencesUtil.getInstance().putString("name",loginBean.getName());
                            isLoginSuccess = true;
                            loginView.onLoginResult(isLoginSuccess, "登录成功");
                        }else {
                            isLoginSuccess = false;
                            loginView.onLoginResult(isLoginSuccess, "登录失败");
                        }
                    }
                    @Override
                    public void onError(Response<LoginBean> response) {
                        super.onError(response);
                        isLoginSuccess = false;
                        loginView.onLoginResult(isLoginSuccess, "网络错误");
                    }
                });


    }
}
