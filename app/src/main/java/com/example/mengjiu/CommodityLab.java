package com.example.mengjiu;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * 商品数据源
 * 使用了单例模式保证此类仅有一个对象
 */
public class CommodityLab {
    //单例第1步
    private static CommodityLab INSTANCE=null;


    private  List<Commodity>data;

    private final static String TAG="Mengjiu";
    public final static int MSG_CHANNELS=1;
    public final static int MSG_HOT_COMMENTS=2;
    public final static int MSG_ADD_COMMENT=3;
    public final static int MSG_FAILURE=4;


    //单例第2步
    private CommodityLab(){
        //把下面的代码换成从网络获取数据
        data = new ArrayList<>();
//       getData();//调用方法

    }




    //单例第3步
    public static CommodityLab getInstance(){
        if (INSTANCE==null){
            INSTANCE=new CommodityLab();
        }
        return INSTANCE;
    }
    /**
     * 返回数据总数量
     * @return
     */
    public int getSize(){
        return data.size();
    }

    /**
     * 返回指定位置的商品信息
     * @param position 数据编号，从0开始
     * @return position 对应的商品数量
     */
    public Commodity getCommodity(int position){
        return this.data.get(position);
    }

    /**
     * 访问网络数据得到真实数据,代替以前的test（）方法
     * @param handler
     */

    public void getData(Handler handler){
        //调用单例
        Retrofit retrofit=RetrofitClient.getInstance();
        CommodityApi api = retrofit.create(CommodityApi.class);
        Call<Result<List<Commodity>>> call=api.getAllCommoditys();
        //enqueue会自己生成子线程，去执行后续代码
        call.enqueue(new Callback<Result<List<Commodity>>>() {
            @Override
            public void onResponse(Call<Result<List<Commodity>>> call, Response<Result<List<Commodity>>> response) {
                if (response.code()==403){
                    Log.w(TAG,"被禁止访问服务器");
                    Message msg=new Message();
                    msg.what=MSG_FAILURE;
                    handler.sendMessage(msg);
                }else if (null != response && null != response.body()) {
                    Log.d(TAG, "从阿里云得到数据是：");
                    Log.d(TAG, response.body().toString());
                    Result<List<Commodity>> result=response.body();
                    data=result.getData();
                    //发出通知
                    Message msg=new Message();
                    msg.what=MSG_CHANNELS;
                    handler.sendMessage(msg);
                } else {
                    Log.w(TAG, "response没有数据!");
                }
            }
            @Override
            public void onFailure(Call<Result<List<Commodity>>> call, Throwable t) {
                    Log.e(TAG,"访问网络失败",t);

            }
        });

    }

    public void getHotComments(String commodityId, Handler handler){
        //调用单例
        Retrofit retrofit=RetrofitClient.getInstance();
        CommodityApi api = retrofit.create(CommodityApi.class);
        Call<Result<List<Comment>>> call = api.getHotComments(commodityId);
        call.enqueue(new Callback<Result<List<Comment>>> () {
            @Override
            public void onResponse(Call<Result<List<Comment>>>  call, Response<Result<List<Comment>>>  response) {
                if (response.code()==403) {
                    Log.w(TAG, "禁止访问！");
                    Message msg = new Message();
                    msg.what = MSG_FAILURE;
                    handler.sendMessage(msg);
                }else if(null!=response&&null!=response.body()){
                    Log.d(TAG, "从阿里云得到订单数据是：");
                    Log.d(TAG, response.body().toString());
                    Result<List<Comment>> result=response.body();
                    List<Comment> comments =result.getData();
                    //发出通知
                    Message msg=new Message();
                    msg.what=MSG_HOT_COMMENTS; //自己规定1代表从阿里云获取数据完毕
                    msg.obj=comments;
                    handler.sendMessage(msg);
                } else {
                    Log.w(TAG, "responew没有订单数据!");
                }
            }
            @Override
            public void onFailure(Call<Result<List<Comment>>>  call, Throwable t) {
                Log.e(TAG,"访问网络失败",t);
            }
        });
    }

    /**
     * 添加新订单
     * @param commodityId 商品编号
     * @param comment 订单对象
     * @param handler 主线程需要提供一个通讯录hansler
     */
    public void addComment(String commodityId,Comment comment,Handler handler){
        Retrofit retrofit =RetrofitClient.getInstance();
        CommodityApi api=retrofit.create(CommodityApi.class);
        Call<Commodity> call=api.addComment(commodityId,comment);
        call.enqueue(new Callback<Commodity>() {
            @Override
            public void onResponse(Call<Commodity> call, Response<Commodity> response) {
                Log.d(TAG,"新增订单后服务器返回数据：");
                Log.d(TAG,response.body().toString());
                Message msg=new Message();
                msg.what=MSG_ADD_COMMENT;
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(Call<Commodity> call, Throwable t) {
                Log.e(TAG,"访问网络失败！",t);
                Message msg=new Message();
                msg.what=MSG_FAILURE;
                handler.sendMessage(msg);
            }
        });
    }

}


