package com.example.mengjiu;

import java.util.Date;

/**
 * 商品的订单对象
 */
public class Comment {
    private String author; //下单人
    private String content; //配送地址
    private Date dt; //下单时间
    private int star;  //下单数量

    @Override
    public String toString() {
        return "Comment{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", dt=" + dt +
                ", star=" + star +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
