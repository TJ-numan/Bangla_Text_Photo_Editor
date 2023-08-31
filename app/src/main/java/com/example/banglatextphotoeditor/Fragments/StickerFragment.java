package com.example.banglatextphotoeditor.Fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.jblabs.lipiyon.C1068R;
import com.jblabs.lipiyon.fragments.imagetools.sticker.StickerViewPagerAdapter;
import java.util.Objects;

public class StickerFragment extends Fragment {
    StickerFragmentListener stickerFragmentListener;
    TabLayout tabLayout;
    ViewPager viewPager;

    public interface StickerFragmentListener {
        void onStickerFragmentClick(Bitmap bitmap);
    }

    public void setStickerFragmentListener(StickerFragmentListener stickerFragmentListener2) {
        this.stickerFragmentListener = stickerFragmentListener2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1068R.layout.fragment_image_sticker, viewGroup, false);
        this.tabLayout = (TabLayout) inflate.findViewById(C1068R.C1070id.tablayoutSticker);
        ViewPager viewPager2 = (ViewPager) inflate.findViewById(C1068R.C1070id.viewpagerSticker);
        this.viewPager = viewPager2;
        viewPager2.setAdapter(new StickerViewPagerAdapter(getChildFragmentManager(), new StickerViewPagerAdapter.StickerViewPagerAdapterListener() {
            public final void onSticker(int i) {
                StickerFragment.this.lambda$onCreateView$0$StickerFragment(i);
            }
        }));
        this.tabLayout.setupWithViewPager(this.viewPager);
        changeTabsFont();
        return inflate;
    }

    public /* synthetic */ void lambda$onCreateView$0$StickerFragment(int i) {
        StickerFragmentListener stickerFragmentListener2 = this.stickerFragmentListener;
        if (stickerFragmentListener2 != null) {
            stickerFragmentListener2.onStickerFragmentClick(BitmapFactory.decodeResource(getResources(), i));
        }
    }

    private void changeTabsFont() {
        ViewGroup viewGroup = (ViewGroup) this.tabLayout.getChildAt(0);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(i);
            int childCount2 = viewGroup2.getChildCount();
            for (int i2 = 0; i2 < childCount2; i2++) {
                View childAt = viewGroup2.getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTypeface(Typeface.createFromAsset(((FragmentActivity) Objects.requireNonNull(getActivity())).getAssets(), "roboto_regular.ttf"));
                }
            }
        }
    }
}
