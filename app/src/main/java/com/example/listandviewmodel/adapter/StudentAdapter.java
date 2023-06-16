package com.example.listandviewmodel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listandviewmodel.listener.ToDoOnActions;
import com.example.listandviewmodel.models.Student;

public class StudentAdapter extends ListAdapter<Student, StudentAdapter.StudentViewHolder> {

    private ToDoOnActions toDoOnActions;

    public StudentAdapter(ToDoOnActions toDoOnActions) {
        super(new DiffUtil.ItemCallback<Student>() {
            @Override
            public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                return oldItem.getStudentMatricule().equals(newItem.getStudentMatricule());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                if(oldItem.getStudentImage() != newItem.getStudentImage()) return false;
                if(oldItem.getStudentName().equals(newItem.getStudentName())) return false;
                if(oldItem.getStudentEmailAddress().equals(newItem.getStudentEmailAddress())) return false;
                return true;
            }
        });
        this.toDoOnActions = toDoOnActions;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        com.example.listandviewmodel.databinding.ItemStudentBinding itemStudentBinding = com.example.listandviewmodel.databinding.ItemStudentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new StudentViewHolder(itemStudentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.bindData(getItem(position));
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        private com.example.listandviewmodel.databinding.ItemStudentBinding itemStudentBinding;

        public StudentViewHolder(com.example.listandviewmodel.databinding.ItemStudentBinding itemStudentBinding) {
            super(itemStudentBinding.getRoot());
            this.itemStudentBinding = itemStudentBinding;
        }

        public void bindData(Student student) {
            if (student != null) {
                itemStudentBinding.setStudent(student);
                itemStudentBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        return toDoOnActions.onLongClick(student);
                    }
                });
            }
        }
    }
}
