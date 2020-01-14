package momunity.com.platoun.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import momunity.com.platoun.R;
import momunity.com.platoun.models.Product;

/**
 * Created by Mohamed Achref on 2020-01-09.
 */
public class MarketplaceAdapter extends RecyclerView.Adapter<MarketplaceAdapter.SingleItemRowHolder> {

    private ArrayList<Product> itemsList;
    private Context mContext;

    public MarketplaceAdapter(Context context, ArrayList<Product> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product_list, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        final Product product = itemsList.get(i);

        int imageResource = mContext.getResources().getIdentifier(product.getImage(), "drawable", mContext.getPackageName());

        holder.tvTitle.setText(product.getUser());
        holder.tvTitle2.setText(product.getName());
        holder.btnSoloPrice.setText(product.getSoloPrice());
        holder.btnGroupPrice.setText(product.getGroupPrice());

        holder.itemImage.setImageResource(imageResource);
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(product.isLike()){
                    product.setLike(false);
                    view.setBackgroundResource(R.drawable.icon_liked);
                }else {
                    product.setLike(true);
                    view.setBackgroundResource(R.drawable.background_button_like);
                }
            }
        });


       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected ImageView itemImage;
        protected Button btnLike;
        protected TextView tvTitle;
        protected TextView tvTitle2;
        protected Button btnSoloPrice;
        protected Button btnGroupPrice;

        public SingleItemRowHolder(View view) {
            super(view);

            this.itemImage = view.findViewById(R.id.itemImage);
            this.btnLike = view.findViewById(R.id.btnLike);
            this.tvTitle = view.findViewById(R.id.tvTitle);
            this.tvTitle2 = view.findViewById(R.id.tvTitle2);
            this.btnSoloPrice = view.findViewById(R.id.btnSoloPrice);
            this.btnGroupPrice = view.findViewById(R.id.btnGroupPrice);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });


        }

    }

}