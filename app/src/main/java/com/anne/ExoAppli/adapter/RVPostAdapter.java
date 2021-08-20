package com.anne.ExoAppli.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anne.ExoAppli.R;
import com.anne.ExoAppli.model.Post;
import com.anne.ExoAppli.service.PostService;

import java.lang.ref.WeakReference;
import java.util.List;

public class RVPostAdapter extends RecyclerView.Adapter<RVPostAdapter.ViewHolder> {

    private List<Post> data;
    private WeakReference<OnItemClickListener> listener;


    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvName;
        TextView tvDescription;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.post_list_item_title);
            tvDescription = itemView.findViewById(R.id.post_list_item_description);
            imageView = itemView.findViewById(R.id.imageView);
        }

    }
    public RVPostAdapter(List<Post> postList, OnItemClickListener listener) {
        this.data = postList;
        this.listener = new WeakReference<>(listener);
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
        if (post.getPicture()!= null){
            holder.imageView.setImageBitmap((post.getPicture()));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(listener.get() != null){
                    listener.get().onClick(post);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener{
        void onClick(Post postClicked);

    }
}


