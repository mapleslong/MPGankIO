package com.mapleslong.gankio.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mapleslong.gankio.R;
import com.mapleslong.gankio.entity.GankDataEntity;
import com.mapleslong.gankio.module.html5.Html5Activity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Mapleslong on 16/8/18.
 */
public class GankTypeCardAdapter extends RecyclerView.Adapter<GankTypeCardAdapter.CardViewHolder> {
    private Context mContext;
    private List<GankDataEntity> mDatas = new ArrayList<>();
    private static final int TYPE_PIC = 10000;
    private static final int TYPE_ITEM = 10001;

    public GankTypeCardAdapter(Context context, List<GankDataEntity> datas) {
        this.mContext = context;
        mDatas = datas;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == TYPE_PIC) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_cardpic, parent,
                    false);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_card, parent,
                    false);
        }
        final CardViewHolder viewHolder = new CardViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition() - 1;
                Intent intent = new Intent(mContext, Html5Activity.class);
                intent.putExtra("url", mDatas.get(position).getUrl());
                intent.putExtra("title", mDatas.get(position).getDesc());
                mContext.startActivity(intent);
            }
        });

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        GankDataEntity data = mDatas.get(position);
        switch (getItemViewType(position)) {
            case TYPE_PIC:
                holder.setImgPic(mDatas.get(position).getUrl());
                break;
            case TYPE_ITEM:
                holder.setCard(data.getDesc(), data.getWho(), data.getPublishedAt());
                break;
        }
    }


    @Override
    public int getItemViewType(int position) {
        GankDataEntity data = mDatas.get(position);
        return (data.getUrl().endsWith(".png") || data.getUrl().endsWith(".jpg")) ? TYPE_PIC :
                TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvName, tvPublishTime;
        ImageView imgPic;

        public CardViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvPublishTime = (TextView) itemView.findViewById(R.id.tv_publishtime);
            imgPic = (ImageView) itemView.findViewById(R.id.img_pic);
        }

        public void setImgPic(String url) {
            Glide.with(mContext).load(url).into(imgPic);
        }

        public void setCard(String title, String name, String publishtime) {
            tvTitle.setText(title);

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
                        Locale.CHINA);
                Date date = new Date(sdf.parse(publishtime).getTime());
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
                tvPublishTime.setText(format.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            tvName.setText(name);
        }

    }
}
