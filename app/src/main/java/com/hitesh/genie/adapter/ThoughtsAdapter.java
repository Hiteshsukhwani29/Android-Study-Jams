package com.hitesh.genie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.hitesh.genie.R;
import com.hitesh.genie.thoughtsModel;

public class ThoughtsAdapter extends ListAdapter<thoughtsModel, ThoughtsAdapter.ViewHolder> {

    private OnItemClickListener listener;

    ThoughtsAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<thoughtsModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<thoughtsModel>() {
        @Override
        public boolean areItemsTheSame(thoughtsModel oldItem, thoughtsModel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(thoughtsModel oldItem, thoughtsModel newItem) {
            return oldItem.getTitle().equals(newItem.getTitle()) &&
                    oldItem.getDate().equals(newItem.getDate()) &&
                    oldItem.getDate().equals(newItem.getDesc());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_thought, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        thoughtsModel model = getItem(position);
        holder.thought_title.setText(model.getTitle());
        holder.thought_date.setText(model.getDate());
        holder.thought_desc.setText(model.getDesc());
    }

    public thoughtsModel getCourseAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView thought_title,thought_date,thought_desc;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            thought_title = itemView.findViewById(R.id.title);
            thought_date = itemView.findViewById(R.id.date);
            thought_desc = itemView.findViewById(R.id.desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(thoughtsModel model);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}