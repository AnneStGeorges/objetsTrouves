package com.anne.ExoAppli.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anne.ExoAppli.R;
import com.anne.ExoAppli.model.Post;
import com.anne.ExoAppli.service.PostService;

import java.util.List;

public class RVPostAdapter extends RecyclerView.Adapter<RVPostAdapter.ViewHolder> {


    private final int recyclerItemRes;
    private final Context context;
    private List<Post> data;


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDescription;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.post_list_item_title);
            tvDescription = itemView.findViewById(R.id.post_list_item_description);
        }

    }
    public RVPostAdapter(Context context, @LayoutRes int recyclerItemRes) {
        this.recyclerItemRes = recyclerItemRes;
        this.data = PostService.getInstance().getAllPosts();
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View createdView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list_item, parent, false);
        return new ViewHolder(createdView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = data.get(position);
        holder.tvName.setText(post.getName());
        holder.tvDescription.setText(post.getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
