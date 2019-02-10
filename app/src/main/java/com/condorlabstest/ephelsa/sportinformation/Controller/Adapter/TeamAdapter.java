package com.condorlabstest.ephelsa.sportinformation.Controller.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.condorlabstest.ephelsa.sportinformation.Model.Data.TeamModel;
import com.condorlabstest.ephelsa.sportinformation.R;
import com.condorlabstest.ephelsa.sportinformation.View.Fragment.DetailsFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    // Models list to inflate the recycler with data.
    private List<TeamModel> teamModels;

    private Context context = null;


    public TeamAdapter(List<TeamModel> teamModels) {
        this.teamModels = teamModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.cardview_league_team, viewGroup, false);

        ViewHolder holder = new ViewHolder(itemView);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        // Setting data
        Picasso.get()
                .load(teamModels.get(i).getBadge())
                .into(viewHolder.badge);

        viewHolder.name
                .setText(teamModels.get(i).getName());
        viewHolder.stadium
                .setText(teamModels.get(i).getStadium());


        // Onclick
        viewHolder.cardView
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Passing data between activity and fragment.
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(TeamModel.ID_TEAM, teamModels.get(i));

                        // Fragment Instance.
                        Fragment detailsFragment = new DetailsFragment();
                        detailsFragment.setArguments(bundle);

                        // This replace the fragment in the container.
                        AppCompatActivity activity = (AppCompatActivity) context;
                        activity
                                .getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container, detailsFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null)
                                .commit();
                    }
                });
    }

    @Override
    public int getItemCount() {
        return teamModels.size();
    }


    // Holder class
    public class ViewHolder extends RecyclerView.ViewHolder {

        // CardView elements
        private CardView cardView;
        private ImageView badge;
        private TextView name;
        private TextView stadium;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            badge = itemView.findViewById(R.id.badge);
            name = itemView.findViewById(R.id.name);
            stadium = itemView.findViewById(R.id.stadium);
        }
    }
}
