package com.example.banglatextphotoeditor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banglatextphotoeditor.R;
import com.example.banglatextphotoeditor.interfaces.ItemClickListener;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder> {
    Context context;
    ItemClickListener itemClickListener;
    List<Integer> list;

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return i;
    }

    public QuotesAdapter(List<Integer> list2, Context context2, ItemClickListener itemClickListener2) {
        this.list = list2;
        this.context = context2;
        this.itemClickListener = itemClickListener2;
    }

    public QuotesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_quotes, viewGroup, false);
        QuotesViewHolder quotesViewHolder = new QuotesViewHolder(inflate);
        inflate.setOnClickListener(new View.OnClickListener() {
            public /* synthetic */ int fs = 0;

            {
                this.fs = 2;
            }

            public final void onClick(View view) {
                QuotesAdapter.this.lambda$onCreateViewHolder$0$QuotesAdapter(this.fs, view);
            }
        });
        return quotesViewHolder;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$QuotesAdapter(int quotesViewHolder, View view) {
        this.itemClickListener.onItemClick(view, (quotesViewHolder));
    }

    public void onBindViewHolder(QuotesViewHolder quotesViewHolder, int i) {
        quotesViewHolder.tvQuote.setText(this.list.get(i).intValue());
    }

    public int getItemCount() {
        return this.list.size();
    }

    public static class QuotesViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuote;

        public QuotesViewHolder(View view) {
            super(view);
            this.tvQuote = (TextView) view.findViewById(R.id.tvQuote);
        }
    }
}
