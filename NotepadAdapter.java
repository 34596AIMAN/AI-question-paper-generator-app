package com.myapp.aiqpg.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.aiqpg.R;
import com.myapp.aiqpg.database.entity.NotepadItem;

import java.util.ArrayList;
import java.util.List;

public class NotepadAdapter extends RecyclerView.Adapter<NotepadAdapter.NotepadViewHolder> {

    private List<NotepadItem> notepadItems = new ArrayList<>();

    public void setNotepadItems(List<NotepadItem> notepadItems) {
        this.notepadItems = notepadItems != null ? notepadItems : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotepadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notepad, parent, false);
        return new NotepadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotepadViewHolder holder, int position) {
        NotepadItem item = notepadItems.get(position);
        holder.titleText.setText(item.getTitle());
        holder.contentText.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return notepadItems.size();
    }

    static class NotepadViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        TextView contentText;

        NotepadViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.text_title);
            contentText = itemView.findViewById(R.id.text_content);
        }
    }
}

