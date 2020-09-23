package com.example.finalfyp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolderCategory> {
    //private int[] images;
    //private List<String> list;
    List<CategoryDb> categories;
    private Context context;

    public RecyclerAdapter(List<CategoryDb> categories, Context context) {
        //this.images = images;
        //this.list = list;
        this.categories =categories;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category, parent, false);
        ViewHolderCategory viewHolderCategory = new ViewHolderCategory(view, context, categories);
        return viewHolderCategory;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCategory holder, int position) {

        holder.CategoryImage.setImageResource(categories.get(position).categoryImage);
        /*GlideApp
                .with(this)
                .load(MyViewUtils.getImage(R.drawable.wallpaper)
                        .into(panel_IMG_back);*/
        holder.CategoryName.setText(categories.get(position).categoryName);

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolderCategory extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView CategoryImage;
        TextView CategoryName;
        Context context;
        List <CategoryDb> list ;
        public ViewHolderCategory(@NonNull View itemView, Context context, List<CategoryDb> categories) {
            super(itemView);
            CategoryImage = itemView.findViewById(R.id.categoryImage);
            CategoryName = itemView.findViewById(R.id.categoryText);
            itemView.setOnClickListener(this);
            this.context = context;
            this.list = categories;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context,Places.class);
            intent.putExtra("categoryName", list.get(getAdapterPosition()).categoryName);
            context.startActivity(intent);

        }
    }
}
