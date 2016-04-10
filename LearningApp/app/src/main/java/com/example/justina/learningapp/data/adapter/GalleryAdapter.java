package com.example.justina.learningapp.data.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.justina.learningapp.R;
import com.example.justina.learningapp.data.entity.Prize;

import java.util.List;
import io.realm.RealmResults;


public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.CustViewHolder> {

    private List<Prize> prizes;

    public GalleryAdapter(RealmResults<Prize> allPrizes) {
        this.prizes = allPrizes;
    }

    @Override
    public GalleryAdapter.CustViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prize_info, null);

        CustViewHolder viewHolder = new CustViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustViewHolder viewHolder, int position) {
        String info = prizes.get(position).getCaptionText() + " (" +
                prizes.get(position).getReleased() + ")";
        viewHolder.captionText.setText(info);

        // Regular image loading using resources
        //viewHolder.prizeImage.setImageResource(prizes[position].getResourceID());

        // Image loading using Glide
        Glide
                .with(viewHolder.itemView.getContext())
                .load(prizes.get(position).getImgSource())
                .placeholder(R.drawable.tf_logo_main)
                   .crossFade()
                .into(viewHolder.prizeImage);
    }

    public static class CustViewHolder extends RecyclerView.ViewHolder {
        public TextView captionText;
        public ImageView prizeImage;

        public CustViewHolder(View itemView) {
            super(itemView);
            captionText = (TextView) itemView.findViewById(R.id.prizeCaption);
            prizeImage = (ImageView) itemView.findViewById(R.id.prizeImage);
        }
    }

    @Override
    public int getItemCount() {
        return prizes.size();
    }

}