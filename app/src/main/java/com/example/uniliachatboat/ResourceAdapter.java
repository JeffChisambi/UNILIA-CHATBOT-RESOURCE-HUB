package com.example.uniliachatboat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResourceAdapter extends RecyclerView.Adapter<ResourceAdapter.ViewHolder> {

    private List<Resource> resourceList;

    public ResourceAdapter(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resource, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Resource resource = resourceList.get(position);
        holder.titleText.setText(resource.getTitle());
        holder.descriptionText.setText(resource.getDescription());
    }

    @Override
    public int getItemCount() {
        return resourceList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        TextView descriptionText;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.resource_title);
            descriptionText = itemView.findViewById(R.id.resource_description);
        }
    }
}