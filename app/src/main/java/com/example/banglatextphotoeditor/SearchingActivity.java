package com.example.banglatextphotoeditor;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;
import com.mancj.materialsearchbar.MaterialSearchBar;
import java.util.List;

public class SearchingActivity extends AppCompatActivity implements PhotoRecyclerAdapter.OnPhotoClickedListener {
    public PhotoRecyclerAdapter adapter;
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private GridLayoutManager layoutManager;
    public int page = 1;
    private RecyclerView recyclerUnsplash;
   // private MaterialSearchBar searchBar;

    public SwipeRefreshLayout swipeContainer;
    private Unsplash unsplash;
    private void showAd() {
    }

    static int getPage(SearchingActivity searchingActivity) {
        int i = searchingActivity.page;
        searchingActivity.page = i + 1;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_searching);
        showAd();
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        this.swipeContainer = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public final void onRefresh() {
                SearchingActivity.this.lambda$onCreate$0$SearchingActivity();
            }
        });

        MaterialSearchBar materialSearchBar = (MaterialSearchBar) findViewById(R.id.searchBar);
        this.searchBar = materialSearchBar;
        materialSearchBar.hideSuggestionsList();
        this.recyclerUnsplash = (RecyclerView) findViewById(R.id.recyclerUnsplash);
        //this.unsplash = new Unsplash("1d8b669a82fd44ee699880cdcfdb7e3bfc9a5c01aaa3e422dbb79b0faf0220f0");
        getData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        this.layoutManager = gridLayoutManager;
        this.recyclerUnsplash.setLayoutManager(gridLayoutManager);
        if (!isNetworkConnected(this)) {
            Toast.makeText(this, "No Internet", 1).show();
        } else {
            isNetworkConnected(this);
        }
        setupPhotoGrid();
        setupSearch();
    }

    public /* synthetic */ void lambda$onCreate$0$SearchingActivity() {
        this.page = 1;
        this.swipeContainer.setRefreshing(false);
    }

    private void getData() {
        String stringExtra = getIntent().getStringExtra("SUGGEST");
        if (stringExtra != null) {
            searchText(stringExtra);
            this.searchBar.setText(stringExtra);
        }
    }

    private void setupSearch() {
        this.searchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            public void onButtonClicked(int i) {
            }

            public void onSearchStateChanged(boolean z) {
            }

            public void onSearchConfirmed(CharSequence charSequence) {
                SearchingActivity.this.searchText(String.valueOf(charSequence));
            }
        });
    }

    public void searchText(String str) {
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        SearchingUnsplashFragment searchingUnsplashFragment = new SearchingUnsplashFragment();
        beginTransaction.addToBackStack("ttt");
        beginTransaction.add(R.id.frameSearching, searchingUnsplashFragment, "fragment");
        Bundle bundle = new Bundle();
        bundle.putString("sendq", str);
        searchingUnsplashFragment.setArguments(bundle);
        beginTransaction.commit();
        this.searchBar.clearFocus();
        ((InputMethodManager) getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(this.searchBar.getWindowToken(), 0);
    }

    public void loadPhotos() {
        this.unsplash.getPhotos(Integer.valueOf(this.page), 10, Order.LATEST, new Unsplash.OnPhotosLoadedListener() {
            public void onError(String str) {
            }

            public void onComplete(List<Photo> list) {
                SearchingActivity.getPage(SearchingActivity.this);
                SearchingActivity.this.adapter.addPhotos(list);
            }
        });
    }

    private void setupPhotoGrid() {
        PhotoRecyclerAdapter photoRecyclerAdapter = new PhotoRecyclerAdapter(new ArrayList(), this, this);
        this.adapter = photoRecyclerAdapter;
        this.recyclerUnsplash.setAdapter(photoRecyclerAdapter);
        this.recyclerUnsplash.addOnScrollListener(new EndlessRecyclerViewScrollListener(this.layoutManager) {
            public void onLoadMore(int i, int i2, RecyclerView recyclerView) {
                SearchingActivity.this.loadPhotos();
            }
        });
        loadPhotos();
    }

    public void photoClicked(Photo photo, ImageView imageView) {
        startEditPhoto(photo);
    }

    private void startEditPhoto(Photo photo) {
        Intent intent = new Intent(this, EditPhotoActivity.class);
        intent.putExtra(SplashPicker.KEY_IMAGE, photo);
        startActivity(intent);
    }

    public void onStop() {
        super.onStop();
    }

    public void onBackPressed() {
        if (this.fragmentManager.getBackStackEntryCount() > 0) {
            this.fragmentManager.popBackStack((String) null, 1);
        } else {
            super.onBackPressed();
        }
    }

    public boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Network[] allNetworks = connectivityManager.getAllNetworks();
        if (allNetworks.length <= 0) {
            return false;
        }
        boolean z = false;
        for (Network networkCapabilities : allNetworks) {
            NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(networkCapabilities);
            if (networkCapabilities2 != null && networkCapabilities2.hasCapability(12)) {
                z = true;
            }
        }
        return z;
    }
}
