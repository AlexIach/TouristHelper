package com.qoobico.remindme.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;
import com.qoobico.remindme.R;
import com.qoobico.remindme.CountryChoosingActivity;

public class SightsFragment extends Fragment {
    private static final int LAYOUT = R.layout.sights_fragment;

    private View view;

    public static SightsFragment getInstance() {
        Bundle args = new Bundle();
        SightsFragment fragment = new SightsFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        FloatingActionButton findMe = (FloatingActionButton) view.findViewById(R.id.fabSights);

        findMe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Snackbar.make(view, getString(R.string.lounch), Snackbar.LENGTH_LONG)
                        .setAction(R.string.lounch_map_button, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(getActivity(), CountryChoosingActivity.class));
                            }
                        }).show();

            }
        });
        return view;
    }
}
