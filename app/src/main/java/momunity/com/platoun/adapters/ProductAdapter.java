package momunity.com.platoun.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import momunity.com.platoun.R;
import momunity.com.platoun.models.Category;

/**
 * Created by Mohamed Achref on 2020-01-09.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ItemRowHolder> {

    private ArrayList<Category> dataList;
    private Context mContext;

    public ProductAdapter(Context context, ArrayList<Category> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_category, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        if (dataList.get(i).getProducts() != null) {
            final String categoryName = dataList.get(i).getName();


            ArrayList singleSectionItems = dataList.get(i).getProducts();


            int imageResource = mContext.getResources().getIdentifier(dataList.get(i).getImage(), "drawable", mContext.getPackageName());

            itemRowHolder.itemTitle.setText(categoryName);

//        itemRowHolder.itemTitle.setTypeface(null, Typeface.BOLD);

            itemRowHolder.ivCategory.setImageResource(imageResource);

            MarketplaceAdapter itemListDataAdapter = new MarketplaceAdapter(mContext, singleSectionItems);

            itemRowHolder.recycler_view_list.setHasFixedSize(true);
            itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);

            itemRowHolder.btnMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "click event on more, " + categoryName, Toast.LENGTH_SHORT).show();
//                Utils.showFragment(new MarketplaceByCategoryFragment() ,R.id.activity_main_frame_layout ,  ((FragmentActivity)mContext).getSupportFragmentManager());

                }
            });

        }else {
            itemRowHolder.rlCategory.setVisibility(View.GONE);
            itemRowHolder.recycler_view_list.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected RelativeLayout rlCategory;
        protected TextView itemTitle;
        protected ImageView ivCategory;
        protected RecyclerView recycler_view_list;

        protected Button btnMore;


        public ItemRowHolder(View view) {
            super(view);

            this.rlCategory = view.findViewById(R.id.rlCategory);
            this.itemTitle = view.findViewById(R.id.itemTitle);
            this.ivCategory = view.findViewById(R.id.ivCategory);
            this.recycler_view_list = view.findViewById(R.id.recycler_view_list);
            this.btnMore = view.findViewById(R.id.btnMore);


        }

    }
}
