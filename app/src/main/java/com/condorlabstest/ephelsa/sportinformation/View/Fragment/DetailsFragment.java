package com.condorlabstest.ephelsa.sportinformation.View.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.condorlabstest.ephelsa.sportinformation.Model.Data.TeamModel;
import com.condorlabstest.ephelsa.sportinformation.R;
import com.condorlabstest.ephelsa.sportinformation.View.Dialog.EventsDialog;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    // TAG
    private final static String TAG = DetailsFragment.class.getSimpleName();


    // View elements
    private View rootView;

    private TextView name, description, year, nextEvents, website, facebook, twitter, instagram;
    private ImageView badge, jersey;

    // Bundle
    private Bundle bundle;
    private TeamModel teamModel;


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout and view.
        rootView = inflater.inflate(R.layout.fragment_details, container, false);

        name = rootView.findViewById(R.id.name);
        description = rootView.findViewById(R.id.description);
        year = rootView.findViewById(R.id.year);
        nextEvents = rootView.findViewById(R.id.next_events);
        website = rootView.findViewById(R.id.website);
        facebook = rootView.findViewById(R.id.facebook);
        twitter = rootView.findViewById(R.id.twitter);
        instagram = rootView.findViewById(R.id.instagram);
        badge = rootView.findViewById(R.id.badge);
        jersey = rootView.findViewById(R.id.jersey);

        // Data team.
        bundle = getArguments();
        teamModel = (TeamModel) bundle.get(TeamModel.ID_TEAM);

        // Setting view
        name.setText(teamModel.getName());
        description.setText(teamModel.getDescription());
        year.setText(getResources().getString(R.string.founded) + " " + teamModel.getYear());
        website.setText(teamModel.getWebsite());
        facebook.setText(teamModel.getFacebook());
        twitter.setText(teamModel.getTwitter());
        instagram.setText(teamModel.getInstagram());

        Picasso.get()
                .load(teamModel.getBadge())
                .into(badge);

        Picasso.get()
                .load(teamModel.getJersey())
                .into(jersey);

        // Onclick
        nextEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EventsDialog(getContext(), teamModel.getName(), teamModel.getId()).show();
            }
        });


        return rootView;
    }

}
