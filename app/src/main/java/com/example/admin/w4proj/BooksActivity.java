package com.example.admin.w4proj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.w4proj.model.Book;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class BooksActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        recyclerView = (RecyclerView) findViewById(R.id.rvBooks);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);

        Call<ArrayList<Book>> bookCall = RetrofitHelper.getBook();

        bookCall.enqueue(new retrofit2.Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
                ArrayList<Book> bookArrayList = response.body();
                BooksAdapter booksAdapter = new BooksAdapter(bookArrayList);
                recyclerView.setAdapter(booksAdapter);
                booksAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Book>> call, Throwable t) {

            }
        });

    }
}