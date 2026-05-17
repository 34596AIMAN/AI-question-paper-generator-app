package com.myapp.aiqpg.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.aiqpg.R;
import com.myapp.aiqpg.database.entity.QuestionPaper;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<QuestionPaper> historyItems = new ArrayList<>();

    public void setHistoryItems(List<QuestionPaper> historyItems) {
        this.historyItems = historyItems != null ? historyItems : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        QuestionPaper paper = historyItems.get(position);
        holder.titleText.setText(paper.getTitle());
        holder.subjectText.setText(paper.getSubject());
    }

    @Override
    public int getItemCount() {
        return historyItems.size();
    }

    static class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        TextView subjectText;

        HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.text_title);
            subjectText = itemView.findViewById(R.id.text_subject);
        }
    }
}
