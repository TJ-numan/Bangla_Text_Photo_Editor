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

public class BackgroundImageAdapter2 extends RecyclerView.Adapter<BackgroundImageAdapter2.ViewHolderImage2> {
    Context context;
    ItemClickListener itemClickListener;
    List<Sample> sampleArrayList;

    public BackgroundImageAdapter2(List<Sample> list, Context context2, ItemClickListener itemClickListener2) {
        this.sampleArrayList = list;
        this.context = context2;
        this.itemClickListener = itemClickListener2;
    }

    public ViewHolderImage2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image_background2, viewGroup, false);
        ViewHolderImage2 viewHolderImage2 = new ViewHolderImage2(inflate);
        inflate.setOnClickListener(new View.OnClickListener(viewHolderImage2) {
            public final /* synthetic */ ViewHolderImage2 f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BackgroundImageAdapter2.this.lambda$onCreateViewHolder$0$BackgroundImageAdapter2(this.f$1, view);
            }
        });
        return viewHolderImage2;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$BackgroundImageAdapter2(ViewHolderImage2 viewHolderImage2, View view) {
        this.itemClickListener.onItemClick(view, viewHolderImage2.getLayoutPosition());
    }

    public void onBindViewHolder(ViewHolderImage2 viewHolderImage2, int i) {
        Glide.with(this.context).load(Integer.valueOf(this.sampleArrayList.get(i).getImgSample())).thumbnail(0.1f).into((ImageView) viewHolderImage2.roundedImageView);
    }

    public int getItemCount() {
        return this.sampleArrayList.size();
    }

    public static class ViewHolderImage2 extends RecyclerView.ViewHolder {
        CircleImageView roundedImageView;

        public ViewHolderImage2(View view) {
            super(view);
            this.roundedImageView = (CircleImageView) view.findViewById(R.id.img_background_2);
        }
    }
}
