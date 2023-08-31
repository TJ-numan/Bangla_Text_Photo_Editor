package com.example.banglatextphotoeditor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banglatextphotoeditor.R;
import com.example.banglatextphotoeditor.SampleActivity;
import com.example.banglatextphotoeditor.interfaces.ItemClickListener;

import java.util.List;

public class SuggestAdapter extends RecyclerView.Adapter<SuggestAdapter.ViewHolderSuggest> {
    Context context;
    ItemClickListener itemClickListener;
    List<String> suggestList;

    public SuggestAdapter(List<String> list, Context context2, ItemClickListener itemClickListener2) {
        this.suggestList = list;
        this.context = context2;
        this.itemClickListener = itemClickListener2;
    }

    public SuggestAdapter(List<String> suggest, SampleActivity context2, ItemClickListener itemClickListener) {

    }

    public ViewHolderSuggest onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_suggest, viewGroup, false);
        ViewHolderSuggest viewHolderSuggest = new ViewHolderSuggest(inflate);
        inflate.setOnClickListener(new View.OnClickListener(viewHolderSuggest) {
            public final /* synthetic */ ViewHolderSuggest f$1;

            {

                this.f$1 = r2;

            }

            public final void onClick(View view) {
                SuggestAdapter.this.lambda$onCreateViewHolder$0$SuggestAdapter(this.f$1, view);
            }
        });
        return viewHolderSuggest;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$SuggestAdapter(ViewHolderSuggest viewHolderSuggest, View view) {
        this.itemClickListener.onItemClick(view, viewHolderSuggest.getLayoutPosition());
    }

    public void onBindViewHolder(ViewHolderSuggest viewHolderSuggest, int i) {
        viewHolderSuggest.tvSuggest.setText(this.suggestList.get(i));
    }

    public int getItemCount() {
        return this.suggestList.size();
    }

    public static class ViewHolderSuggest extends RecyclerView.ViewHolder {
        TextView tvSuggest;

        public ViewHolderSuggest(View view) {
            super(view);
            this.tvSuggest = (TextView) view.findViewById(R.id.tvSuggest);
        }
    }
}
