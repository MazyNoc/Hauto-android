package nu.annat.autohome;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

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
