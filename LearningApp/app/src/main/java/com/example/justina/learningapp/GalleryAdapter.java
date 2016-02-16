package com.example.justina.learningapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.CustViewHolder> {

    private Photo[] images;

    public GalleryAdapter(Photo[] photos) {
        this.images = photos;
    }

    @Override
    public GalleryAdapter.CustViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prize_info, null);

        CustViewHolder viewHolder = new CustViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustViewHolder viewHolder, int position) {
        viewHolder.captionText.setText(images[position].getCaptionText());
        viewHolder.prizeImage.setImageResource(images[position].getResourceID());
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
        return images.length;
    }

}