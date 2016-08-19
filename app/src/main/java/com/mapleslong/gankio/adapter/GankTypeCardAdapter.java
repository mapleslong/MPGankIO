package com.mapleslong.gankio.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mapleslong.gankio.R;
import com.mapleslong.gankio.entity.GankDataEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mapleslong on 16/8/18.
 */
public class GankTypeCardAdapter extends RecyclerView.Adapter<GankTypeCardAdapter.CardViewHolder> {

    private List<GankDataEntity> mDatas = new ArrayList<>();

    public GankTypeCardAdapter(List<GankDataEntity> datas) {
        mDatas = datas;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_card, parent,
                false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        GankDataEntity data = mDatas.get(position);
        holder.setCard(data.getDesc(), data.getWho(), data.getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvName, tvPublishTime;

        public CardViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvPublishTime = (TextView) itemView.findViewById(R.id.tv_publishtime);
        }

        public void setCard(String title, String name, String publishtime) {
            tvTitle.setText(title);
            tvName.setText(name);
            tvPublishTime.setText(publishtime);

        }

    }
}
