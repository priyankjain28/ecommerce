package com.peeru.task.heady.ecom.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.peeru.task.heady.ecom.R;
import com.peeru.task.heady.ecom.data.db.entity.Categories;
import com.peeru.task.heady.ecom.data.db.entity.ProductFetch;
import com.peeru.task.heady.ecom.data.db.entity.Variants;
import com.peeru.task.heady.ecom.databinding.ItemAdapterBinding;
import com.peeru.task.heady.ecom.ui.item.ListItemsFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Priyank Jain on 08-10-2018.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MessageViewHolder> {
    //region Vairable Declaration
    private List<ProductFetch> listOfProduct;
    private ListItemsFragment listItemsFragment;

    public ItemAdapter(ListItemsFragment listItemsFragment) {
        this.listItemsFragment = listItemsFragment;
    }
    //endregion

    //region Set User List Data
    public void setTaskList(final List<ProductFetch> productFetchList) {
        listOfProduct = productFetchList;
        notifyDataSetChanged();
    }
    //endregion

    //region Create View Holder
    @Override
    public ItemAdapter.MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemAdapterBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_adapter,
                        parent,
                        false);

        return new MessageViewHolder(binding);
    }
    //endregion

    //region Bind View Holder
    @Override
    public void onBindViewHolder(ItemAdapter.MessageViewHolder holder, int position) {
        ProductFetch p = listOfProduct.get(position);
        HashSet<String> colorSet = new HashSet<String>();
        TreeSet<Double> sizeSet = new TreeSet<Double>();
        ArrayList<Integer> priceList = new ArrayList<Integer>();
        HashSet<String> categoriesSet = new HashSet<String>();
        if(p.getVariantList() != null && !p.getVariantList().isEmpty()){
            for (Variants v : listOfProduct.get(position).getVariantList()) {
                colorSet.add(v.getColor());
                if(v.getSize() != null)
                sizeSet.add(Double.valueOf(v.getSize().trim()));
                priceList.add(Integer.valueOf(v.getPrice().trim()));
            }
            holder.binding.productColor.setText(TextUtils.join(",", colorSet));
            holder.binding.productSize.setText(TextUtils.join(",", sizeSet));
            if(Collections.min(priceList) ==  Collections.max(priceList)){
                holder.binding.price.setText("Rs. "+Collections.min(priceList).toString());
            }else {
                holder.binding.price.setText("Rs. "+Collections.min(priceList) + "-" + Collections.max(priceList));
            }
        }
        holder.binding.productName.setText(p.getProduct().getName());
        for(Categories c : p.getCategories())
            categoriesSet.add(c.getName());
            holder.binding.productCategory.setText(TextUtils.join(",", categoriesSet));
        holder.binding.taxText.setText(p.getProduct().getTaxName());
        holder.binding.tax.setText(p.getProduct().getTaxValue());

        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return listOfProduct == null ? 0 : listOfProduct.size();
    }
    //endregion

    //region Message View Holder Class
    class MessageViewHolder extends RecyclerView.ViewHolder {

        private final ItemAdapterBinding binding;

        public MessageViewHolder(ItemAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    //endregion
}
