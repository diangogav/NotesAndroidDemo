package com.example.notesapplication;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.notesapplication.NoteFragment.OnListFragmentInteractionListener;

import java.util.List;

public class MyNoteRecyclerViewAdapter extends RecyclerView.Adapter<MyNoteRecyclerViewAdapter.ViewHolder> {

    private final List<Note> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyNoteRecyclerViewAdapter(List<Note> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
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

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
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
        public Note mItem;

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
