package com.example.banglatextphotoeditor.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.banglatextphotoeditor.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class PhotoFragment extends Fragment {
    public PhotoListener mPhotoListener;
    RecyclerView recyclerView;

    public interface PhotoListener {
        void onPhotoClick(String str);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_image_photo, viewGroup, false);
        RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(R.id.recycler_photo);
        this.recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        this.recyclerView.setAdapter(new PhotoAdapter());
        return inflate;
    }

    public void setPhotoListener(PhotoListener photoListener) {
        this.mPhotoListener = photoListener;
    }

    public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
        List<String> stringArrayList;

        public PhotoAdapter() {
            this.stringArrayList = PhotoFragment.this.getAllShownImagesPath(PhotoFragment.this.getActivity());
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo_small, viewGroup, false));
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            Glide.with((FragmentActivity) PhotoFragment.this.getActivity()).load(this.stringArrayList.get(i)).thumbnail(0.001f).into((ImageView) viewHolder.squareImageView);
        }

        public int getItemCount() {
            return this.stringArrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView squareImageView;


            public ViewHolder(View view) {
                super(view);
                this.squareImageView = (ImageView) view.findViewById(R.id.imgPhoto);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }) ;throw new UnsupportedOperationException("Method not decompiled: com.jblabs.lipiyon.fragments.imagetools.PhotoFragment.PhotoAdapter.ViewHolder.<init>(com.jblabs.lipiyon.fragments.imagetools.PhotoFragment$PhotoAdapter, android.view.View):void");
            }

            public /* synthetic */ void lambda$new$0$PhotoFragment$PhotoAdapter$ViewHolder(View view) {
                if (PhotoFragment.this.mPhotoListener != null) {
                    PhotoFragment.this.mPhotoListener.onPhotoClick(PhotoAdapter.this.stringArrayList.get(getLayoutPosition()));
                }
            }
        }
    }

    public List<String> getAllShownImagesPath(Activity activity) {
        ArrayList arrayList = new ArrayList();
        if (activity == null) {
            return arrayList;
        }
        Cursor query = activity.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "bucket_display_name"}, (String) null, (String[]) null, (String) null);
        int columnIndexOrThrow = ((Cursor) Objects.requireNonNull(query)).getColumnIndexOrThrow("_data");
        query.getColumnIndexOrThrow("bucket_display_name");
        while (query.moveToNext()) {
            arrayList.add(query.getString(columnIndexOrThrow));
        }
        return arrayList;
    }
}
