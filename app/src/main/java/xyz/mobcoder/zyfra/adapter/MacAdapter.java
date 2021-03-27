package xyz.mobcoder.zyfra.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.mobcoder.zyfra.adapter.holder.ItemViewHolder;
import xyz.mobcoder.zyfra.databinding.ItemMacBinding;

public class MacAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    List<String> list;

    public MacAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemMacBinding itemMacBinding = ItemMacBinding.inflate(layoutInflater, parent, false);
        return new ItemViewHolder(itemMacBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
