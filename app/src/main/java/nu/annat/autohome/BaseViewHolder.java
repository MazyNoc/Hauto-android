package nu.annat.autohome;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder<T, VB extends ViewDataBinding> extends RecyclerView.ViewHolder {

    protected final VB binding;
    protected T data;

    public BaseViewHolder(VB binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setData(T data) {
        this.data = data;
    }
}
