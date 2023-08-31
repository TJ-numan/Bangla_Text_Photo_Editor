package com.example.banglatextphotoeditor.adapter.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.banglatextphotoeditor.R;
import com.example.banglatextphotoeditor.model.Sample;
import com.example.banglatextphotoeditor.interfaces.ItemClickListener;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BackgroundColorAdapter extends RecyclerView.Adapter<BackgroundColorAdapter.ViewHolderColor> {
    Context context;
    ItemClickListener itemClickListener;
    List<Sample> sampleArrayList;

    public BackgroundColorAdapter(List<Sample> list, Context context2, ItemClickListener itemClickListener2) {
        this.sampleArrayList = list;
        this.context = context2;
        this.itemClickListener = itemClickListener2;
    }

    public ViewHolderColor onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_color_background, viewGroup, false);
        ViewHolderColor viewHolderColor = new ViewHolderColor(inflate);
        inflate.setOnClickListener(new View.OnClickListener(viewHolderColor) {
            public final /* synthetic */ ViewHolderColor f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BackgroundColorAdapter.this.lambda$onCreateViewHolder$0$BackgroundColorAdapter(this.f$1, view);
            }
        });
        return viewHolderColor;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$BackgroundColorAdapter(ViewHolderColor viewHolderColor, View view) {
        this.itemClickListener.onItemClick(view, viewHolderColor.getLayoutPosition());
    }

    public void onBindViewHolder(ViewHolderColor viewHolderColor, int i) {
        Glide.with(this.context).load(Integer.valueOf(this.sampleArrayList.get(i).getImgSample())).thumbnail(0.1f).into((ImageView) viewHolderColor.circleImageView);
    }

    public int getItemCount() {
        return this.sampleArrayList.size();
    }

    public static class ViewHolderColor extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;

        public ViewHolderColor(View view) {
            super(view);
            this.circleImageView = (CircleImageView) view.findViewById(R.id.img_background_circle);
        }
    }
}
