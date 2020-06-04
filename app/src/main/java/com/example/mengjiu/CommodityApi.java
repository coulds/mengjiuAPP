package com.example.mengjiu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CommodityApi {
        /**
         * 获取收有频道
         * @return
         */
        @GET("/commodity")
        Call<Result<List<Commodity>>> getAllCommoditys();

        /**
         * 获取热门评论
         * @param commodityId 频道编号
         * @return 热门评论的列表
         */
        @GET("/commodity/{commodityId}/hotcomments")
        Call<Result<List<Comment>>>getHotComments(@Path("commodityId") String commodityId);

        /**
         * 新增评论
         * @param CommodityId 频道编号
         * @param comment 评论对象
         * @return 频道对象
         */
        @POST("/commodity/{commodityId}/comment")
        Call<Commodity> addComment(@Path("commodityId") String commodityId, @Body Comment comment);

}
