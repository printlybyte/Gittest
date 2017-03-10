package com.example.anew.gittest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 */
/**
 * 继承recyclerview的适配器   后面尖叫号里面的参数是自定类里面应外一个类的name
 *
 * 自定义类的里面的类需要继承reclclerview.viewhodle
 * */
public class Adapter_recy extends RecyclerView.Adapter<Adapter_recy.AAA> {
    private Context context;
    private List<Costom_person> mList;

    //初始化集合
    public Adapter_recy(List<Costom_person> mList) {
        this.mList = mList;
    }

    @Override
    public AAA onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        //记载自定义的布局
        final View view = LayoutInflater.from(context).inflate(R.layout.adapter_item, parent, false);
        final AAA aaa = new AAA(view);
        //布局的点击事件
        aaa.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int posion = aaa.getAdapterPosition();//得到adpter的每一条数据，
                Costom_person a = mList.get(posion);//与每个对象相适应气起来
                Toast.makeText(context, "" + a.name + posion, Toast.LENGTH_SHORT).show();
            }
        });
        return aaa;
    }
//在此方法里初始化view  的values
    @Override
    public void onBindViewHolder(AAA holder, int position) {
        Costom_person cc = mList.get(position);
        holder.textView.setText(cc.name);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class AAA extends RecyclerView.ViewHolder {
        TextView textView;//没有值得叫声明变量，有值得叫初始化数据
        TextView textView2;
        LinearLayout relativeLayout;

        public AAA(View itemView) {
            super(itemView);
            relativeLayout= (LinearLayout) itemView;//自定义item是什么这个就是什么
            textView = (TextView) itemView.findViewById(R.id.text_item_one);//自定义item里面的布局文件
            textView2 = (TextView) itemView.findViewById(R.id.text_item_two);
        }
    }
}