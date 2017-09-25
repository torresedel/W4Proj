package com.example.admin.w4proj;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.w4proj.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 9/25/2017.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private List<Book> bookList = new ArrayList<>();
    private Context context;
    Book book;

    public BooksAdapter(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .books_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.tvTitle.setText(bookList.get(position).getTitle());
        holder.tvAuthor.setText(bookList.get(position).getAuthor());
        Glide.with(holder.itemView.getContext()).load(bookList.get(position).getImageURL()).into(holder.ivBook);

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvAuthor;
        private final TextView tvTitle;
        private final ImageView ivBook;

        public ViewHolder(View itemView) {
            super(itemView);

            ivBook = itemView.findViewById(R.id.ivBook);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);

        }
    }
}