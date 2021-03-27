package xyz.mobcoder.zyfra.adapter.holder;

import androidx.recyclerview.widget.RecyclerView;

import xyz.mobcoder.zyfra.databinding.ItemMacBinding;
import xyz.mobcoder.zyfra.utils.Extensions;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private final ItemMacBinding binding;

    public ItemViewHolder(ItemMacBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String model) {
        binding.setItem(model);
        binding.textView3.setText(Extensions.getMAC(model));
        binding.executePendingBindings();
    }
}
