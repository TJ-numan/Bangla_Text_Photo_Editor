package com.example.banglatextphotoeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
//import com.facebook.ads.AdView;
//import com.facebook.ads.InterstitialAd;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.FullScreenContentCallback;
//import com.google.android.gms.ads.LoadAdError;
//import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
//import com.jblabs.lipiyon.BaseActivity;
//import com.jblabs.lipiyon.activities.EditPhotoActivity;
//import com.jblabs.lipiyon.activities.SampleActivity;
//import com.jblabs.lipiyon.dialog.SettingDialog;
//import com.karumi.dexter.Dexter;
//import com.karumi.dexter.MultiplePermissionsReport;
//import com.karumi.dexter.PermissionToken;
//import com.karumi.dexter.listener.DexterError;
//import com.karumi.dexter.listener.PermissionRequest;
//import com.karumi.dexter.listener.PermissionRequestErrorListener;
//import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
//import com.yalantis.ucrop.UCrop;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;

import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "MainAcitivty";
    private static final int TAKE_PICTURE = 111;
//    private InterstitialAd FinterstitialAd;
//    private AdView adViewFb;
    LinearLayout camera;
    LinearLayout fbgroup;
    LinearLayout gallery;
    LinearLayout insta;
//    private com.google.android.gms.ads.AdView mAdView;
    public String mCurrentPhotoPath;
    /* access modifiers changed from: private */
//    public com.google.android.gms.ads.interstitial.InterstitialAd mInterstitialad;
    LinearLayout online;
    LinearLayout rate;
    public int requestMode = 1;
    LinearLayout share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        this.gallery = (LinearLayout) findViewById(R.id.gallery);
        this.online = (LinearLayout) findViewById(R.id.online);
        this.fbgroup = (LinearLayout) findViewById(R.id.fbgroup);
        this.camera = (LinearLayout) findViewById(R.id.camera);
        this.insta = (LinearLayout) findViewById(R.id.instapage);
        this.rate = (LinearLayout) findViewById(R.id.rate);
        this.share = (LinearLayout) findViewById(R.id.share);


//        AdRequest build = new AdRequest.Builder().build();
//        com.google.android.gms.ads.interstitial.InterstitialAd.load(this, getString(C1068R.string.ginter), build, new InterstitialAdLoadCallback() {
//            public void onAdLoaded(com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
//                com.google.android.gms.ads.interstitial.InterstitialAd unused = BaseActivity.this.mInterstitialad = interstitialAd;
//                interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
//                    public void onAdShowedFullScreenContent() {
//                    }
//
//                    public void onAdDismissedFullScreenContent() {
//                        com.google.android.gms.ads.interstitial.InterstitialAd unused = BaseActivity.this.mInterstitialad = null;
//                    }
//                });
//            }
//
//            public void onAdFailedToLoad(LoadAdError loadAdError) {
//                com.google.android.gms.ads.interstitial.InterstitialAd unused = BaseActivity.this.mInterstitialad = null;
//            }
//        });
//        com.google.android.gms.ads.AdView adView = (com.google.android.gms.ads.AdView) findViewById(C1068R.C1070id.adView);
//        this.mAdView = adView;
//        adView.loadAd(build);



        this.gallery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseActivity.this.pickFromGalery();
//                if (BaseActivity.this.mInterstitialad != null) {
//                    BaseActivity.this.mInterstitialad.show(BaseActivity.this);
//                }
            }
        });
        this.online.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Dexter.withContext(BaseActivity.this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() {
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        if (multiplePermissionsReport.areAllPermissionsGranted()) {
                            BaseActivity.this.startActivity(new Intent(BaseActivity.this, SampleActivity.class));
//                            if (BaseActivity.this.mInterstitialad != null) {
//                                BaseActivity.this.mInterstitialad.show(BaseActivity.this);
//                            }
                        }
                        if (multiplePermissionsReport.isAnyPermissionPermanentlyDenied()) {
                            SettingDialog.showSettingDialog(BaseActivity.this);
                        }
                    }

                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).withErrorListener(new PermissionRequestErrorListener() {
                    public final void onError(DexterError dexterError) {
                        BaseActivity.this.lambda$dispatchTakePictureIntent$0$BaseActivity(DexterError.NO_PERMISSIONS_REQUESTED);
                    }
                }).onSameThread().check();
            }

            @SuppressLint("WrongConstant")
            public /* synthetic */ void lambda$onClick$0$BaseActivity$3(DexterError dexterError) {
                Toast.makeText(BaseActivity.this, "Error occurred! ", 0).show();
            }
        });
        this.fbgroup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseActivity.this.gotUrl("https://www.facebook.com/groups/856483208935819");
            }
        });
        this.camera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseActivity.this.dispatchTakePictureIntent();
            }
        });
        this.insta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseActivity.this.gotUrl("https://www.instagram.com/lipionapp/");
            }
        });
        this.rate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseActivity baseActivity = BaseActivity.this;
                baseActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + BaseActivity.this.getPackageName())));
            }
        });
        this.share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseActivity.this.shareApp();
            }
        });
    }

    /* access modifiers changed from: private */
    public void gotUrl(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    /* access modifiers changed from: private */
    public void dispatchTakePictureIntent() {
        Dexter.withContext(this).withPermissions("android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() {
            public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                if (multiplePermissionsReport.areAllPermissionsGranted()) {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    if (intent.resolveActivity(BaseActivity.this.getPackageManager()) != null) {
                        File file = null;
                        try {
                            file = BaseActivity.this.createImageFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (!(file == null || BaseActivity.this.mCurrentPhotoPath == null)) {
                            intent.putExtra("output", FileProvider.getUriForFile(BaseActivity.this, "com.jblabs.lipiyon.fileprovider", file));
                            BaseActivity.this.startActivityForResult(intent, 111);
                        }
                    }
                }
                if (multiplePermissionsReport.isAnyPermissionPermanentlyDenied()) {
                    SettingDialog.showSettingDialog(BaseActivity.this);
                }
            }

            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).withErrorListener(new PermissionRequestErrorListener() {
            public final void onError(DexterError dexterError) {
                BaseActivity.this.lambda$dispatchTakePictureIntent$0$BaseActivity(dexterError);
            }
        }).onSameThread().check();
    }

    public /* synthetic */ void lambda$dispatchTakePictureIntent$0$BaseActivity(DexterError dexterError) {
        Toast.makeText(getApplicationContext(), "Error occurred! ", Toast.LENGTH_SHORT).show();
    }

    /* access modifiers changed from: private */
    public void shareApp() {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", "My application name");
            intent.putExtra("android.intent.extra.TEXT", "\nLet me recommend you this application\n\nhttps://play.google.com/store/apps/details?id=" + getPackageName());
            startActivity(Intent.createChooser(intent, "Choose one"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pickFromGalery() {
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() {
            public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                if (multiplePermissionsReport.areAllPermissionsGranted()) {
                    Intent addCategory = new Intent("android.intent.action.GET_CONTENT").setType("image/*").addCategory("android.intent.category.OPENABLE");
                    addCategory.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/jpeg", "image/png"});
                    BaseActivity.this.startActivityForResult(Intent.createChooser(addCategory, "Select Picture"), BaseActivity.this.requestMode);
                }
                if (multiplePermissionsReport.isAnyPermissionPermanentlyDenied()) {
                    SettingDialog.showSettingDialog(BaseActivity.this);
                }
            }

            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).withErrorListener(new PermissionRequestErrorListener() {
            public final void onError(DexterError dexterError) {
                BaseActivity.this.lambda$pickFromGalery$1$BaseActivity(dexterError);
            }
        }).onSameThread().check();
    }

    public /* synthetic */ void lambda$pickFromGalery$1$BaseActivity(DexterError dexterError) {
        Toast.makeText(getApplicationContext(), "Error Occurred", Toast.LENGTH_SHORT).show();
    }

    public File createImageFile() throws IOException {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File createTempFile = File.createTempFile("JPEG_" + format + "_", ".png", getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        this.mCurrentPhotoPath = createTempFile.getAbsolutePath();
        return createTempFile;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResult ");
        sb.append(i2);
        sb.append(" ");
        sb.append(i);
        sb.append(" ");
        sb.append(intent != null);
        Log.d("XXXXXX", sb.toString());
        if (i2 == -1) {
            if (i == this.requestMode) {
                Uri uri = null;
                if (intent != null) {
                    uri = intent.getData();
                }
                if (uri != null) {
                    startCrop(uri);
                } else {
                    Toast.makeText(this, "Cannot retrieve selected image", Toast.LENGTH_SHORT).show();
                }
            } else if (i == 111) {
                Uri fromFile = Uri.fromFile(new File(this.mCurrentPhotoPath));
                if (fromFile != null) {
                    startCrop(fromFile);
                } else {
                    Toast.makeText(this, "Cannot capture picture", Toast.LENGTH_SHORT).show();
                }
            } else if (i == 69) {
                if (intent != null) {
                    handleCropResult(intent);
                } else {
                    return;
                }
            }
        }
        if (i2 == 96 && intent != null) {
            handleCropError(intent);
        }
    }

    private void handleCropError(Intent intent) {
        Throwable error = UCrop.getError(intent);
        if (error != null) {
            Log.e(TAG, "handleCropError: ", error);
            Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(this, "Unexpected error", Toast.LENGTH_SHORT).show();
    }

    private void handleCropResult(Intent intent) {
        Uri output = UCrop.getOutput(intent);
        if (output != null) {
            Intent intent2 = new Intent(this, EditPhotoActivity.class);
            intent2.setData(output);
            startActivity(intent2);
            return;
        }
        Toast.makeText(this, "Cannot retrieve cropped image", 0).show();
    }

    private void startCrop(Uri uri) {
        UCrop of = UCrop.of(uri, Uri.fromFile(new File(getCacheDir(), "SampleCropImage")));
        of.useSourceImageAspectRatio();
        of.useSourceImageAspectRatio();
        UCrop.Options options = new UCrop.Options();
        options.setCompressionFormat(Bitmap.CompressFormat.PNG);
        options.setFreeStyleCropEnabled(true);
        of.withOptions(options);
        of.start(this);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
