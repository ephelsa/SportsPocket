package com.condorlabstest.ephelsa.sportinformation.View.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.condorlabstest.ephelsa.sportinformation.Controller.Adapter.LeagueAdapter;
import com.condorlabstest.ephelsa.sportinformation.Model.Data.LeagueModel;
import com.condorlabstest.ephelsa.sportinformation.R;

import java.util.ArrayList;
import java.util.List;

public class LeagueActivity extends AppCompatActivity {

    // Class TAG
    private static final String TAG = LeagueActivity.class.getSimpleName();


    // Recycler elements.
    private List<LeagueModel> leagueModels;
    private LeagueAdapter leagueAdapter;
    private RecyclerView recyclerView;

    // View.
    private TextView path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_container);

        // Changes the name of path.
        path = findViewById(R.id.path);
        path.setText(R.string.leagues);

        // Recycler def and settings.
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        leagueModels = new ArrayList<>();

        init();
    }

    // Doesn't exist an endpoint whit badge for this... I think
    private void init() {
        leagueModels
                .add(new LeagueModel(
                        "4335",
                        "https://a2.espncdn.com/combiner/i?img=%2Fi%2Fleaguelogos%2Fsoccer%2F500%2F15.png",
                        "Spanish La Liga"));

        leagueModels
                .add(new LeagueModel(
                        "4331",
                        "https://upload.wikimedia.org/wikipedia/en/thumb/d/df/Bundesliga_logo_%282017%29.svg/1200px-Bundesliga_logo_%282017%29.svg.png",
                        "German Bundesliga"));

        leagueModels
                .add(new LeagueModel(
                        "4330",
                        "https://a.espncdn.com/combiner/i?img=%2Fi%2Fleaguelogos%2Fsoccer%2F500%2F45.png",
                        "Scottish Premier League"));

        leagueAdapter = new LeagueAdapter(leagueModels);
        recyclerView.setAdapter(leagueAdapter);
    }
}
