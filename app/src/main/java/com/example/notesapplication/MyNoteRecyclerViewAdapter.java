package com.example.notesapplication;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyNoteRecyclerViewAdapter extends RecyclerView.Adapter<MyNoteRecyclerViewAdapter.ViewHolder> {

    private List<NoteEntity> mValues;
    private Context ctx;

    public MyNoteRecyclerViewAdapter(List<NoteEntity> items, Context ctx) {
        mValues = items;
        this.ctx = ctx;
    }

    public void setNoteList(List<NoteEntity> list) {
        this.mValues = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTextViewTitle.setText(holder.mItem.getTitle());
        holder.mTextViewContent.setText(holder.mItem.getContent());

        if(holder.mItem.isFavorite()) {
            holder.mImageViewFavorite.setImageResource(R.drawable.ic_star_black_24dp);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTextViewTitle;
        public final TextView mTextViewContent;
        public final ImageView mImageViewFavorite;
        public NoteEntity mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTextViewTitle = view.findViewById(R.id.textViewNoteTitle);
            mTextViewContent = view.findViewById(R.id.textViewNoteContent);
            mImageViewFavorite = view.findViewById(R.id.imageViewNoteFavorite);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextViewTitle.getText() + "'";
        }
    }
}
