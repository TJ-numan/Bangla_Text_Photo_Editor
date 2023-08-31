package com.example.banglatextphotoeditor.adapter.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.banglatextphotoeditor.R;
import com.example.banglatextphotoeditor.interfaces.ItemClickListener;
import com.example.banglatextphotoeditor.model.Sample;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BackgroundImageAdapter extends RecyclerView.Adapter<BackgroundImageAdapter.ViewHolderImage> {
    Context context;
    ItemClickListener itemClickListener;
    List<Sample> sampleArrayList;

    public BackgroundImageAdapter(List<Sample> list, Context context2, ItemClickListener itemClickListener2) {
        this.sampleArrayList = list;
        this.context = context2;
        this.itemClickListener = itemClickListener2;
    }

    public ViewHolderImage onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image_background, viewGroup, false);
        ViewHolderImage viewHolderImage = new ViewHolderImage(inflate);
        inflate.setOnClickListener(new View.OnClickListener(viewHolderImage) {
            public final /* synthetic */ ViewHolderImage f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BackgroundImageAdapter.this.lambda$onCreateViewHolder$0$BackgroundImageAdapter(this.f$1, view);
            }
        });
        return viewHolderImage;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$BackgroundImageAdapter(ViewHolderImage viewHolderImage, View view) {
        this.itemClickListener.onItemClick(view, viewHolderImage.getLayoutPosition());
    }

    public void onBindViewHolder(ViewHolderImage viewHolderImage, int i) {
        Glide.with(this.context).load(Integer.valueOf(this.sampleArrayList.get(i).getImgSample())).thumbnail(0.1f).into((ImageView) viewHolderImage.roundedImageView);
    }

    public int getItemCount() {
        return this.sampleArrayList.size();
    }

    public static class ViewHolderImage extends RecyclerView.ViewHolder {
        CircleImageView roundedImageView;

        public ViewHolderImage(View view) {
            super(view);
            this.roundedImageView = (CircleImageView) view.findViewById(R.id.img_background_rectange);
        }
    }
}
