package com.example.listandviewmodel.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listandviewmodel.databinding.ItemAlbumBinding;
import com.example.listandviewmodel.listener.ToDoOnActions;
import com.example.listandviewmodel.models.Album;
import com.example.listandviewmodel.models.Student;

public class AlbumAdapter extends ListAdapter<Album, AlbumAdapter.AlbumViewHolder> {

    private ToDoOnActions toDoOnActions;

    public AlbumAdapter(ToDoOnActions toDoOnActions) {
        super(new DiffUtil.ItemCallback<Album>() {
            @Override
            public boolean areItemsTheSame(@NonNull Album oldItem, @NonNull Album newItem) {
                return oldItem.getAlbumId().equals(newItem.getAlbumId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Album oldItem, @NonNull Album newItem) {
                if(oldItem.getAlbumTitle() != newItem.getAlbumTitle()) return false;
                return true;
            }
        });
        this.toDoOnActions = toDoOnActions;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAlbumBinding itemStudentBinding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new AlbumViewHolder(itemStudentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        holder.bindData(getItem(position));
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {

        private ItemAlbumBinding dataBinding;

        public AlbumViewHolder(ItemAlbumBinding itemStudentBinding) {
            super(itemStudentBinding.getRoot());
            this.dataBinding = itemStudentBinding;
        }

        public void bindData(Album album) {
            if (album != null) {
                dataBinding.albumName.setText(album.getAlbumTitle());
                dataBinding.getRoot().setOnClickListener(v -> toDoOnActions.onClick(album));
            }
        }
    }
}
