package com.example.banglatextphotoeditor.Fragments;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.jblabs.lipiyon.C1068R;
import com.jblabs.lipiyon.views.SquareImageView;
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
        View inflate = layoutInflater.inflate(C1068R.layout.fragment_image_photo, viewGroup, false);
        RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(C1068R.C1070id.recycler_photo);
        this.recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.recyclerView.setAdapter(new PhotoAdapter());
        return inflate;
    }

    public void setPhotoListener(PhotoListener photoListener) {
        this.mPhotoListener = photoListener;
    }

    public class PhotoAdapter extends RecyclerView.Adapter<ViewHolder> {
        List<String> stringArrayList;

        public PhotoAdapter() {
            this.stringArrayList = PhotoFragment.this.getAllShownImagesPath(PhotoFragment.this.getActivity());
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1068R.layout.item_photo_small, viewGroup, false));
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            Glide.with((FragmentActivity) Objects.requireNonNull(PhotoFragment.this.getActivity())).load(this.stringArrayList.get(i)).thumbnail(0.001f).into((ImageView) viewHolder.squareImageView);
        }

        public int getItemCount() {
            return this.stringArrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            SquareImageView squareImageView;

            public ViewHolder(View view) {
                super(view);
                this.squareImageView = (SquareImageView) view.findViewById(C1068R.C1070id.imgPhoto);
                view.setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                      (r2v0 'view' android.view.View)
                      (wrap: com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$PhotoFragment$PhotoAdapter$ViewHolder$smubLFUVdInfEBFMxoyNusbcSN4 : 0x0012: CONSTRUCTOR  (r1v4 com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$PhotoFragment$PhotoAdapter$ViewHolder$smubLFUVdInfEBFMxoyNusbcSN4) = 
                      (r0v0 'this' com.jblabs.lipiyon.fragments.imagetools.PhotoFragment$PhotoAdapter$ViewHolder A[THIS])
                     call: com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$PhotoFragment$PhotoAdapter$ViewHolder$smubLFUVdInfEBFMxoyNusbcSN4.<init>(com.jblabs.lipiyon.fragments.imagetools.PhotoFragment$PhotoAdapter$ViewHolder):void type: CONSTRUCTOR)
                     android.view.View.setOnClickListener(android.view.View$OnClickListener):void type: VIRTUAL in method: com.jblabs.lipiyon.fragments.imagetools.PhotoFragment.PhotoAdapter.ViewHolder.<init>(com.jblabs.lipiyon.fragments.imagetools.PhotoFragment$PhotoAdapter, android.view.View):void, dex: classes2.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r1v4 com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$PhotoFragment$PhotoAdapter$ViewHolder$smubLFUVdInfEBFMxoyNusbcSN4) = 
                      (r0v0 'this' com.jblabs.lipiyon.fragments.imagetools.PhotoFragment$PhotoAdapter$ViewHolder A[THIS])
                     call: com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$PhotoFragment$PhotoAdapter$ViewHolder$smubLFUVdInfEBFMxoyNusbcSN4.<init>(com.jblabs.lipiyon.fragments.imagetools.PhotoFragment$PhotoAdapter$ViewHolder):void type: CONSTRUCTOR in method: com.jblabs.lipiyon.fragments.imagetools.PhotoFragment.PhotoAdapter.ViewHolder.<init>(com.jblabs.lipiyon.fragments.imagetools.PhotoFragment$PhotoAdapter, android.view.View):void, dex: classes2.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 59 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$PhotoFragment$PhotoAdapter$ViewHolder$smubLFUVdInfEBFMxoyNusbcSN4, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	... 65 more
                    */
                /*
                    this = this;
                    com.jblabs.lipiyon.fragments.imagetools.PhotoFragment.PhotoAdapter.this = r1
                    r0.<init>(r2)
                    r1 = 2131362118(0x7f0a0146, float:1.8344008E38)
                    android.view.View r1 = r2.findViewById(r1)
                    com.jblabs.lipiyon.views.SquareImageView r1 = (com.jblabs.lipiyon.views.SquareImageView) r1
                    r0.squareImageView = r1
                    com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$PhotoFragment$PhotoAdapter$ViewHolder$smubLFUVdInfEBFMxoyNusbcSN4 r1 = new com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$PhotoFragment$PhotoAdapter$ViewHolder$smubLFUVdInfEBFMxoyNusbcSN4
                    r1.<init>(r0)
                    r2.setOnClickListener(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.jblabs.lipiyon.fragments.imagetools.PhotoFragment.PhotoAdapter.ViewHolder.<init>(com.jblabs.lipiyon.fragments.imagetools.PhotoFragment$PhotoAdapter, android.view.View):void");
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
