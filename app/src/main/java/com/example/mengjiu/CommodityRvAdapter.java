package com.example.mengjiu;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class CommodityRvAdapter extends RecyclerView.Adapter< CommodityRvAdapter.CommodityRowHolder> {

    private CommodityLab lab=CommodityLab.getInstance();
    private CommodityClickListener listener;
    private Context context;

    public CommodityRvAdapter(Context context, CommodityClickListener listener){
        this.context=context;
        this.listener=listener;
    }
    /**
     * 当需要新的一行，此方法负责创建一行对应的对象，既CommodityRowHolder对象
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public CommodityRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView= LayoutInflater.from(parent.getContext()).inflate(R.layout.commodity_rom,parent,false);
        CommodityRowHolder holder =new CommodityRowHolder(rowView);
        return holder;
    }

    /**
     * 用于确定列表有几行（既多少CommodityRowHolder对象）
     * @return
     */
    @Override
    public int getItemCount() {
        return lab.getSize();
    }

    /**
     * 用于确定每一行的内容是什么，及填充行中各个视图内容
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull CommodityRowHolder holder, int position) {
        Commodity c=lab.getCommodity(position);
        holder.bind(c);
    }

    //自定义新接口
    public interface CommodityClickListener{
        public void onCommodityClick(int position);
    }

    /**
     * 单行布局对应的java控制类
     */
    public class CommodityRowHolder extends RecyclerView.ViewHolder{
        private TextView commodityname; //商品标题 实例对象
        private TextView describe;//描述
        private ImageView cover; //图片
        private TextView price;//价格

        public CommodityRowHolder(@NonNull View row) {
            super(row);
            this.commodityname=row.findViewById(R.id.product_title9);
            this.describe=row.findViewById(R.id.product_desribe9);
            this.cover=row.findViewById(R.id.product_img9);
            this.price=row.findViewById(R.id.product_price9);
            row.setOnClickListener((v)->{
                int position= getLayoutPosition();
                Log.d("Mengjiu", position+"行被点击啦！");
                    listener.onCommodityClick(position);
            });
        }

        /**
         * 自定义方法，用于向内部的 commodityname提供数据
         * @param //  commodityname
         */
        public void bind(Commodity c){
            this.commodityname.setText(c.getCommodityname());
            this.describe.setText(c.getDescribe());
            this.price.setText(c.getPrice()+"");
            //从网络获取图片
            //this.cover.setImageResource(c.getCover());
            Log.d("Mengjiu","商品"+c.getCommodityname()+"准备从网络加载图片"+c.getCover());
            Glide.with(context)
                    .load(c.getCover())
                    .into(this.cover);
        }
    }

}
