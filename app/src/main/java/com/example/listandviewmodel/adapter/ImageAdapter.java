package com.example.listandviewmodel.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listandviewmodel.databinding.ItemAlbumBinding;
import com.example.listandviewmodel.databinding.ItemImageBinding;
import com.example.listandviewmodel.listener.ToDoOnActions;
import com.example.listandviewmodel.models.Album;
import com.example.listandviewmodel.models.Image;

public class ImageAdapter extends ListAdapter<Image, ImageAdapter.ImageViewHolder> {

    private ToDoOnActions toDoOnActions;

    public ImageAdapter(ToDoOnActions toDoOnActions) {
        super(new DiffUtil.ItemCallback<Image>() {
            @Override
            public boolean areItemsTheSame(@NonNull Image oldItem, @NonNull Image newItem) {
                return oldItem.getImageId().equals(newItem.getImageId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Image oldItem, @NonNull Image newItem) {
                if(oldItem.getImageLabel() != newItem.getImageLabel()) return false;
                if(oldItem.getImageUrl() != newItem.getImageUrl()) return false;
                return true;
            }
        });

        this.toDoOnActions = toDoOnActions;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemImageBinding itemStudentBinding = ItemImageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ImageViewHolder(itemStudentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.bindData(getItem(position));
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        private ItemImageBinding dataBinding;

        public ImageViewHolder(ItemImageBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }

        public void bindData(Image image) {
            if (image != null) {
                dataBinding.imageLabel.setText(image.getImageLabel());
                Glide.with(dataBinding.image).load(image.getImageUrl()).into(dataBinding.image);
            }
        }
    }
}
