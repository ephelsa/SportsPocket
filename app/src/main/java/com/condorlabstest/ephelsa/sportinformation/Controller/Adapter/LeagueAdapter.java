package com.condorlabstest.ephelsa.sportinformation.Controller.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.condorlabstest.ephelsa.sportinformation.Model.Data.LeagueModel;
import com.condorlabstest.ephelsa.sportinformation.R;
import com.condorlabstest.ephelsa.sportinformation.View.Activity.TeamActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.ViewHolder> {

    // Models list to inflate the recycler with data.
    private List<LeagueModel> leagueModels;

    private Context context = null;


    public LeagueAdapter(List<LeagueModel> leagueModels) {
        this.leagueModels = leagueModels;
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

        // Set the image with Picasso.
        Picasso.get()
                .load(leagueModels.get(i).getBadge())
                .into(viewHolder.badge);

        // League Name.
        viewHolder.name
                .setText(leagueModels.get(i).getName());

        // Start TeamActivity sending the 'league_id' via putextra.
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, TeamActivity.class);
                intent.putExtra(LeagueModel.ID_LEAGUE, leagueModels.get(i).getId());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return leagueModels.size();
    }


    // Holder Class
    public class ViewHolder extends RecyclerView.ViewHolder {

        // CardView elements
        private CardView cardView;
        private ImageView badge;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            badge = itemView.findViewById(R.id.badge);
            name = itemView.findViewById(R.id.name);
        }
    }
}
