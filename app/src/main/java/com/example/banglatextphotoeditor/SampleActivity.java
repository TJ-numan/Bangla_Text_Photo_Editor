package com.example.banglatextphotoeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.banglatextphotoeditor.adapter.SuggestAdapter;
import com.example.banglatextphotoeditor.adapter.sample.BackgroundColorAdapter;
import com.example.banglatextphotoeditor.adapter.sample.BackgroundImageAdapter;
import com.example.banglatextphotoeditor.adapter.sample.BackgroundImageAdapter2;
import com.example.banglatextphotoeditor.interfaces.ItemClickListener;
import com.example.banglatextphotoeditor.model.Sample;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import java.util.Objects;
//import com.facebook.ads.AdView;
//import com.jblabs.lipiyon.C1068R;
//import com.jblabs.lipiyon.adapter.sample.BackgroundImageAdapter;
//import com.jblabs.lipiyon.adapter.sample.BackgroundImageAdapter2;
//import com.jblabs.lipiyon.interfaces.ItemClickListener;
//import com.jblabs.lipiyon.model.Sample;

public class SampleActivity extends AppCompatActivity {
    private LinearLayout adView;
    private AdView adViewFb;
    private com.google.android.gms.ads.AdView mAdView;
    private RecyclerView recyclerColors;
    private RecyclerView recyclerFlower;
    private RecyclerView recyclerNature;
    private RecyclerView recyclerNightSky;
    private RecyclerView recyclerSuggest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_sample));
        ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        this.recyclerColors = (RecyclerView) findViewById(R.id.recyclerColor);
        setRecyclerColors();
        this.recyclerNature = (RecyclerView) findViewById(R.id.recyclerNature);
        setRecyclerNature();
        this.recyclerFlower = (RecyclerView) findViewById(R.id.recyclerFlowers);
        setRecyclerFlowers();
        this.recyclerNightSky = (RecyclerView) findViewById(R.id.recyclerNight);
        setRecyclerNightSky();
        this.recyclerSuggest = (RecyclerView) findViewById(R.id.recyclerSuggest);
        setRecyclerSuggest();
        this.mAdView = (com.google.android.gms.ads.AdView) findViewById(R.id.adView);
        this.mAdView.loadAd(new AdRequest.Builder().build());


    }

    private void setRecyclerSuggest() {
        this.recyclerSuggest.setHasFixedSize(true);
        this.recyclerSuggest.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        this.recyclerSuggest.setAdapter(new SuggestAdapter(GenDataBackGround.suggest(), this, new ItemClickListener() {
            public final void onItemClick(View view, int i) {
                SampleActivity.this.lambda$setRecyclerSuggest$0$SampleActivity(view,i);
            }
        }));
    }

    public /* synthetic */ void lambda$setRecyclerSuggest$0$SampleActivity(View view, int i) {
        sendSuggest(GenDataBackGround.suggest().get(i));
    }

    private void setRecyclerNightSky() {
        this.recyclerNightSky.setHasFixedSize(true);
        this.recyclerNightSky.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        this.recyclerNightSky.setAdapter(new BackgroundImageAdapter(GenDataBackGround.nightList(), this, new ItemClickListener() {
            public final void onItemClick(View view, int i) {
                SampleActivity.this.lambda$setRecyclerNightSky$1$SampleActivity(view, i);
            }
        }));
    }

    public /* synthetic */ void lambda$setRecyclerNightSky$1$SampleActivity(View view, int i) {
        sendData(GenDataBackGround.nightList().get(i));
    }

    private void setRecyclerFlowers() {
        this.recyclerFlower.setHasFixedSize(true);
        this.recyclerFlower.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        this.recyclerFlower.setAdapter(new BackgroundImageAdapter2(GenDataBackGround.flowersList(), this, new ItemClickListener() {
            public final void onItemClick(View view, int i) {
                SampleActivity.this.lambda$setRecyclerFlowers$2$SampleActivity(view, i);
            }
        }));
    }

    public /* synthetic */ void lambda$setRecyclerFlowers$2$SampleActivity(View view, int i) {
        sendData(GenDataBackGround.flowersList().get(i));
    }

    private void setRecyclerNature() {
        this.recyclerNature.setHasFixedSize(true);
        this.recyclerNature.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        this.recyclerNature.setAdapter(new BackgroundImageAdapter(GenDataBackGround.nativeList(), this, new ItemClickListener() {
            public final void onItemClick(View view, int i) {
                SampleActivity.this.lambda$setRecyclerNature$3$SampleActivity(view, i);
            }
        }));
    }

    public /* synthetic */ void lambda$setRecyclerNature$3$SampleActivity(View view, int i) {
        sendData(GenDataBackGround.nativeList().get(i));
    }

    private void setRecyclerColors() {
        this.recyclerColors.setHasFixedSize(true);
        this.recyclerColors.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        this.recyclerColors.setAdapter(new BackgroundColorAdapter(GenDataBackGround.colorList(), this, new ItemClickListener() {
            public final void onItemClick(View view, int i) {
                SampleActivity.this.lambda$setRecyclerColors$4$SampleActivity(view, i);
            }
        }));
    }

    public /* synthetic */ void lambda$setRecyclerColors$4$SampleActivity(View view, int i) {
        sendData(GenDataBackGround.colorList().get(i));
    }

    public void sendData(Sample sample) {
        Intent intent = new Intent(this, EditPhotoActivity.class);
        intent.putExtra("SampleBackground", sample.getImgSample());
        startActivity(intent);
    }

    public void onStop() {
        super.onStop();
    }

    public void sendSuggest(String str) {
        Intent intent = new Intent(this, SearchingActivity.class);
        intent.putExtra("SUGGEST", str);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_search) {
            startActivity(new Intent(this, SearchingActivity.class));
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        super.onBackPressed();
        return true;
    }
}
