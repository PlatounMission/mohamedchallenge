package momunity.com.platoun.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import momunity.com.platoun.R;
import momunity.com.platoun.models.Category;

/**
 * Created by Mohamed Achref on 2020-01-09.
 */
public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.SingleItemRowHolder> {

    private ArrayList<Category> itemsList;
    private ArrayList<Category> itemChecked = new ArrayList<>();
    private Context mContext;

    public FilterAdapter(Context context, ArrayList<Category> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_filter, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, final int i) {

        Category category = itemsList.get(i);

        holder.switch_filter.setText(category.getName());

        if (holder.switch_filter != null) {
            holder.switch_filter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b)
                        itemChecked.add(itemsList.get(i));
                    else
                        itemChecked.remove(itemsList.get(i));
                }
            });
        }


    }

    public ArrayList<Category> getItemChecked() {
        return itemChecked;
    }


    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected Switch switch_filter;

        public SingleItemRowHolder(final View view) {
            super(view);

            this.switch_filter = view.findViewById(R.id.switch_filter);


        }

    }

}