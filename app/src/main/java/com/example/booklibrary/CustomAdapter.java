package com.example.booklibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList bookid, bookname, bookauthor;
    private View view;

    CustomAdapter(Context context,ArrayList bookid,ArrayList bookname, ArrayList bookauthor){
        this.context = context;
        this.bookid = bookid;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.myview, parent , false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
            holder.bookTid.setText(String.valueOf(bookid.get(position)));
            holder.bookTname.setText(String.valueOf(bookname.get(position)));
             holder.bookTauthor.setText(String.valueOf(bookauthor.get(position)));
    }

    @Override
    public int getItemCount() {
        return bookid.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView bookTid,bookTname, bookTauthor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bookTid = itemView.findViewById(R.id.bookid);
            bookTname = itemView.findViewById(R.id.bookname);
            bookTauthor = itemView.findViewById(R.id.bookauthor);

        }
    }
}
