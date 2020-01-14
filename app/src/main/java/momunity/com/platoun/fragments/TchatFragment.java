package momunity.com.platoun.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import momunity.com.platoun.R;
import momunity.com.platoun.activities.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class TchatFragment extends Fragment {


    public TchatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((MainActivity) getActivity()).initToolBar("Tchat", 0, 0,false);
        // Inflate the layout for this fragment

        setHasOptionsMenu(false);

        return inflater.inflate(R.layout.fragment_tchat, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }
}
