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

public class QuestionPaperAdapter extends RecyclerView.Adapter<QuestionPaperAdapter.QuestionPaperViewHolder> {

    private List<QuestionPaper> questionPapers = new ArrayList<>();

    public void setQuestionPapers(List<QuestionPaper> questionPapers) {
        this.questionPapers = questionPapers != null ? questionPapers : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QuestionPaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_question_paper, parent, false);
        return new QuestionPaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionPaperViewHolder holder, int position) {
        QuestionPaper paper = questionPapers.get(position);
        holder.titleText.setText(paper.getTitle());
        holder.subjectText.setText(paper.getSubject());
        holder.dateText.setText(paper.getCreatedDate());
    }

    @Override
    public int getItemCount() {
        return questionPapers.size();
    }

    static class QuestionPaperViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        TextView subjectText;
        TextView dateText;

        QuestionPaperViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.text_title);
            subjectText = itemView.findViewById(R.id.text_subject);
            dateText = itemView.findViewById(R.id.text_date);
        }
    }
}
