package momunity.com.platoun.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import momunity.com.platoun.R;
import momunity.com.platoun.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarketplaceByCategoryFragment extends Fragment {


    public MarketplaceByCategoryFragment() {
        // Required empty public constructor
    }

//    ArrayList<SectionDataModel> allSampleData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_platoun_by_category, container, false);

        ((MainActivity) getActivity()).initToolBar("Stroller",0,R.drawable.category_stroller,true);

//        allSampleData = new ArrayList<>();

//        createDummyData();
//        ArrayList singleSectionItems = allSampleData.get(0).getAllItemsInSection();

        RecyclerView my_recycler_view = v.findViewById(R.id.recycler_view);

        my_recycler_view.setHasFixedSize(true);
//        SectionListDataAdapter adapter = new SectionListDataAdapter(getContext(), singleSectionItems);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
//        my_recycler_view.setLayoutManager(mLayoutManager);
//        my_recycler_view.setAdapter(adapter);

        return v;
    }

//    public void createDummyData() {
//            SectionDataModel dm = new SectionDataModel();
//
//            dm.setHeaderTitle("Section " + 1);
//
//            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
//            for (int j = 0; j <= 5; j++) {
//                singleItem.add(new SingleItemModel("Dorothy Perkins " + j, "URL " + j));
//            }
//
//            dm.setAllItemsInSection(singleItem);
//
//            allSampleData.add(dm);
//        }

}
