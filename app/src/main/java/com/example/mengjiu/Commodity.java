package com.example.mengjiu;

import org.w3c.dom.Comment;

import java.io.Serializable;
import java.util.List;

public class Commodity implements Serializable {
    private String id;   //商品id
    private String commodityname;  //商品名称
    private String category; //商品类别
    private String production;  //商品产地
    private List<Comment> comments;  //下单信息
    private String cover; //商品封面图片
    private String score; //评分
    private String abv; //酒精度
    private String describe; //描述
    private String price;  //商品价格

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id='" + id + '\'' +
                ", commodityname='" + commodityname + '\'' +
                ", category='" + category + '\'' +
                ", production='" + production + '\'' +
                ", comments=" + comments +
                ", cover='" + cover + '\'' +
                ", score='" + score + '\'' +
                ", abv='" + abv + '\'' +
                ", describe='" + describe + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
