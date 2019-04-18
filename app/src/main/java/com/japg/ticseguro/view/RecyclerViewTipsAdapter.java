package com.japg.ticseguro.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.japg.ticseguro.R;

import java.util.ArrayList;


public class RecyclerViewTipsAdapter extends RecyclerView.Adapter<RecyclerViewTipsAdapter.ViewHolder> {

    private ArrayList<String> tipsNames = new ArrayList<>();
    private ArrayList<String> tipsCategories = new ArrayList<>();
    private ArrayList<String> tipsContent = new ArrayList<>();
    private Context mContext;

    public RecyclerViewTipsAdapter(Context mContext, ArrayList<String> tipsNames, ArrayList<String> tipsCategories, ArrayList<String> tipsContent) {
        this.tipsNames = tipsNames;
        this.tipsCategories = tipsCategories;
        this.tipsContent = tipsContent;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item_tips, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        System.out.println("Clicked " + tipsNames.get(position));

    }

    @Override
    public int getItemCount() {
        return tipsNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tipName;
        TextView tipCategory;
        TextView tipContent;

        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tipName = itemView.findViewById(R.id.tipName);
            tipCategory = itemView.findViewById(R.id.tipCategory);
            tipContent = itemView.findViewById(R.id.tipContent);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
