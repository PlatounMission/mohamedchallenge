package momunity.com.platoun.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import momunity.com.platoun.R;
import momunity.com.platoun.activities.MainActivity;
import momunity.com.platoun.adapters.FilterAdapter;
import momunity.com.platoun.models.Category;
import momunity.com.platoun.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilterMarketplaceFragment extends Fragment {

    ArrayList<Category> categories;
    ArrayList<Category> typeDeals;


    public static ArrayList<Category> categoriesChecked = new ArrayList<>();
    String TAG = "FilterMarketplaceFragment";

//    ArrayList<TypeDeal> typeDeals;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_filter_marketplace, container, false);

        ((MainActivity) getActivity()).initToolBar("Filters", 0, 0,true);
        setHasOptionsMenu(false);

        Button btnShowOffer = v.findViewById(R.id.btnShowOffer);

        categories = Utils.createCategoryFilterData();
        typeDeals = Utils.createTypeDealData();

        RecyclerView rvTypeDeals = v.findViewById(R.id.rvTypeDeals);
        rvTypeDeals.setHasFixedSize(true);
        FilterAdapter adapterTypeDeal = new FilterAdapter(getContext(), typeDeals);
        rvTypeDeals.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvTypeDeals.setAdapter(adapterTypeDeal);

        RecyclerView rvCategories = v.findViewById(R.id.rvCategories);

        rvCategories.setHasFixedSize(true);
        final FilterAdapter adapterCategory = new FilterAdapter(getContext(), categories);
        rvCategories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rvCategories.setAdapter(adapterCategory);

        btnShowOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: " + adapterCategory.getItemChecked());

                Utils utils = new Utils();
                ((MainActivity) getActivity()).showNavigationBar();
                categoriesChecked.addAll(adapterCategory.getItemChecked());
                utils.showFragment(new MarketplaceFragment(), R.id.activity_main_frame_layout, getActivity().getSupportFragmentManager());


            }
        });

        // Inflate the layout for this fragment
        return v;
    }


//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        menu.clear();
//        inflater.inflate(R.menu.settingdoctor, menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        switch (id) {
//            case R.id.map:
//                System.out.println("clicked ");
//                startActivity(new Intent(this.getContext(), ListDoctorsAProxMapsActivity.class));
//                return true;
//
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

}
