package com.example.mengjiu;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserLab {
    private static UserLab INSTANCE=null;
    private UserLab(){}
    public final static int USER_LOGIN_SUCCESS=1;
    public final static int USER_LOGIN_PASSWORD_ERROR=-1;
    public final static int USER_LOGIN_NET_ERROR=-2;
    public final static int USER_REGISTER_SUCCESS=1;
    public final static int USER_REGISTER_NET_ERROR=-2;
    private final static String TAG="Diandian";
    public final static String USER_CURRENT="USER_CURRENT";
    public final static String USER_TOKEN="USER_TOKEN";
    public static UserLab getInstance(){
        if (null==INSTANCE){
            INSTANCE=new UserLab();
        }
        return INSTANCE;
    }

    public void login(String username, String password, Handler handler){
        Retrofit retrofit=RetrofitClient.getInstance();
        UserApi api=retrofit.create(UserApi.class);
        Log.d(TAG,"准备登录的用户信息用户名:"+username+" ,密码:"+password);
        Call<Result<String>> call=api.login(username,password);
        call.enqueue(new Callback<Result<String>>() {
            @Override
            public void onResponse(Call<Result<String>> call, Response<Result<String>> response) {
                boolean loginSuccess=false;
                String token=null;
                if (response.body()!=null) {
                    Log.d(TAG,"服务器返回结果:"+response.body());
                    Result<String> result =response.body();
                    if (result.getStatus()==Result.OK) {
                        Log.d(TAG,"登录成功返回数据:"+response.body());
                        //登录成功
                        loginSuccess = true;
                        token=result.getData();
                    }
                }
                if (loginSuccess){
                    Message msg=new Message();
                    msg.what=USER_LOGIN_SUCCESS;
                    msg.obj=token;
                    handler.sendMessage(msg);
                }else {
                    Message msg=new Message();
                    msg.what=USER_LOGIN_PASSWORD_ERROR;
                    handler.sendMessage(msg);
                    Log.d(TAG,"密码错误，重新登录");
                }
            }

            @Override
            public void onFailure(Call<Result<String>> call, Throwable t) {
                Log.e(TAG,"登录失败！服务器错误");
                Message msg=new Message();
                msg.what=USER_LOGIN_NET_ERROR;
                handler.sendMessage(msg);
            }
        });
    }

    public void register(User user, Handler handler){
        Retrofit retrofit=RetrofitClient.getInstance();
        UserApi api=retrofit.create(UserApi.class);
        Log.d(TAG,"准备注册的用户信息："+user);
        Call<User> call=api.register(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "注册成功返回数据:" + response.body());
                Message msg = new Message();
                msg.what = USER_REGISTER_SUCCESS;
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG,"注册失败！",t);
                Message msg=new Message();
                msg.what=USER_REGISTER_NET_ERROR;
                handler.sendMessage(msg);
            }
        });
    }
}
