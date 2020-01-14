package momunity.com.platoun.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import momunity.com.platoun.R;
import momunity.com.platoun.activities.MainActivity;
import momunity.com.platoun.adapters.ProductAdapter;
import momunity.com.platoun.models.Category;
import momunity.com.platoun.utils.Utils;


/**
 * A simple {@link Fragment} subclass.
 */
public class MarketplaceFragment extends Fragment {

    public MarketplaceFragment() {
        // Required empty public constructor
    }

    //    ArrayList<SectionDataModel> allSampleData;

    static ArrayList<Category> categories;
    public static Boolean isFiltred = false;
    String TAG = "MarketplaceFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_marketplace, container, false);

        ((MainActivity) getActivity()).initToolBar(null, R.drawable.logo, 0,false);

//        allSampleData = new ArrayList<>();
//        createDummyData();

        Log.d(TAG, "isFiltred: "+isFiltred);
        if (!isFiltred ){
            categories = Utils.createCategoryProductData();
        }else{
            categories = FilterMarketplaceFragment.categoriesChecked;
            isFiltred = false;
        }

        RecyclerView my_recycler_view = v.findViewById(R.id.my_recycler_view);
        my_recycler_view.setHasFixedSize(true);
        ProductAdapter adapter = new ProductAdapter(getContext(), categories);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);

        Log.d(TAG, "onCreateView: "+categories.toString());

        return v;
    }

    //    public void createDummyData() {
//        for (int i = 1; i <= 5; i++) {
//
//            SectionDataModel dm = new SectionDataModel();
//
//            dm.setHeaderTitle("Section " + i);
//
//            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
//            for (int j = 0; j <= 5; j++) {
//                singleItem.add(new SingleItemModel("Dorothy Perkins " + j, "URL " + j));
//            }
//
//            dm.setAllItemsInSection(singleItem);
//
//            allSampleData.add(dm);
//
//        }
//    }




}
