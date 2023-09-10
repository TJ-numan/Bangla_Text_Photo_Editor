package com.example.banglatextphotoeditor.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banglatextphotoeditor.PhotoEditor;
import com.example.banglatextphotoeditor.R;

import java.util.List;

public class EmojiFragment extends Fragment {
    public EmojiListener mEmojiListener;
    RecyclerView recyclerView;

    public interface EmojiListener {
        void onEmojiClick(String str);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_image_emoji, viewGroup, false);
        RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(R.id.recyclerEmoji);
        this.recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 7));
        this.recyclerView.setAdapter(new EmojiAdapter());
        return inflate;
    }

    public void setEmojiListener(EmojiListener emojiListener) {
        this.mEmojiListener = emojiListener;
    }

    public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.ViewHolder> {
        List<String> emojis = PhotoEditor.getEmojis((Context) EmojiFragment.this.requireActivity());

        public EmojiAdapter() {
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
           ViewHolder view = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_emoji, viewGroup, false));

           return view;
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.textView.setText(this.emojis.get(i));
        }

        public int getItemCount() {
            return this.emojis.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public ViewHolder(View view) {
                super(view);
                this.textView = (TextView) view.findViewById(R.id.txtEmoji);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                      (r2v0 'view' android.view.View)
                      (wrap: com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$EmojiFragment$EmojiAdapter$ViewHolder$jMfstn7_q7d1pzaP1jiWXYhLmCI : 0x0012: CONSTRUCTOR  (r1v4 com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$EmojiFragment$EmojiAdapter$ViewHolder$jMfstn7_q7d1pzaP1jiWXYhLmCI) = 
                      (r0v0 'this' com.jblabs.lipiyon.fragments.imagetools.EmojiFragment$EmojiAdapter$ViewHolder A[THIS])
                     call: com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$EmojiFragment$EmojiAdapter$ViewHolder$jMfstn7_q7d1pzaP1jiWXYhLmCI.<init>(com.jblabs.lipiyon.fragments.imagetools.EmojiFragment$EmojiAdapter$ViewHolder):void type: CONSTRUCTOR)
                     android.view.View.setOnClickListener(android.view.View$OnClickListener):void type: VIRTUAL in method: com.jblabs.lipiyon.fragments.imagetools.EmojiFragment.EmojiAdapter.ViewHolder.<init>(com.jblabs.lipiyon.fragments.imagetools.EmojiFragment$EmojiAdapter, android.view.View):void, dex: classes2.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r1v4 com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$EmojiFragment$EmojiAdapter$ViewHolder$jMfstn7_q7d1pzaP1jiWXYhLmCI) = 
                      (r0v0 'this' com.jblabs.lipiyon.fragments.imagetools.EmojiFragment$EmojiAdapter$ViewHolder A[THIS])
                     call: com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$EmojiFragment$EmojiAdapter$ViewHolder$jMfstn7_q7d1pzaP1jiWXYhLmCI.<init>(com.jblabs.lipiyon.fragments.imagetools.EmojiFragment$EmojiAdapter$ViewHolder):void type: CONSTRUCTOR in method: com.jblabs.lipiyon.fragments.imagetools.EmojiFragment.EmojiAdapter.ViewHolder.<init>(com.jblabs.lipiyon.fragments.imagetools.EmojiFragment$EmojiAdapter, android.view.View):void, dex: classes2.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 59 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$EmojiFragment$EmojiAdapter$ViewHolder$jMfstn7_q7d1pzaP1jiWXYhLmCI, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	... 65 more
                    */
                /*
                    this = this;
                    com.jblabs.lipiyon.fragments.imagetools.EmojiFragment.EmojiAdapter.this = r1
                    r0.<init>(r2)
                    r1 = 2131362475(0x7f0a02ab, float:1.8344732E38)
                    android.view.View r1 = r2.findViewById(r1)
                    android.widget.TextView r1 = (android.widget.TextView) r1
                    r0.textView = r1
                    com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$EmojiFragment$EmojiAdapter$ViewHolder$jMfstn7_q7d1pzaP1jiWXYhLmCI r1 = new com.jblabs.lipiyon.fragments.imagetools.-$$Lambda$EmojiFragment$EmojiAdapter$ViewHolder$jMfstn7_q7d1pzaP1jiWXYhLmCI
                    r1.<init>(r0)
                    r2.setOnClickListener(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.jblabs.lipiyon.fragments.imagetools.EmojiFragment.EmojiAdapter.ViewHolder.<init>(com.jblabs.lipiyon.fragments.imagetools.EmojiFragment$EmojiAdapter, android.view.View):void");
            }

            public /* synthetic */ void lambda$new$0$EmojiFragment$EmojiAdapter$ViewHolder(View view) {
                if (EmojiFragment.this.mEmojiListener != null) {
                    EmojiFragment.this.mEmojiListener.onEmojiClick(EmojiAdapter.this.emojis.get(getLayoutPosition()));
                }
            }
        }
    }
}
