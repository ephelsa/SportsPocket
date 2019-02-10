package com.condorlabstest.ephelsa.sportinformation.View.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.condorlabstest.ephelsa.sportinformation.Controller.Adapter.TeamAdapter;
import com.condorlabstest.ephelsa.sportinformation.Model.Data.LeagueModel;
import com.condorlabstest.ephelsa.sportinformation.Controller.Singleton.Singleton;
import com.condorlabstest.ephelsa.sportinformation.Model.Data.TeamModel;
import com.condorlabstest.ephelsa.sportinformation.Model.Interface.VolleyErrorHandler;
import com.condorlabstest.ephelsa.sportinformation.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TeamActivity extends AppCompatActivity implements VolleyErrorHandler {

    // Class TAG
    private static final String TAG = TeamActivity.class.getSimpleName();

    // Recycler elements.
    private List<TeamModel> teamModels;
    private TeamAdapter teamAdapter;
    private RecyclerView recyclerView;

    // View.
    private TextView path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_container);

        // Changes the name of path.
        path = findViewById(R.id.path);
        path.setText(R.string.teams);

        // Recycler def and settings.
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        teamModels = new ArrayList<>();
        teamAdapter = new TeamAdapter(teamModels);
        recyclerView.setAdapter(teamAdapter);

        getData();
    }


    private void getData() {
        // Intent data passed by LeagueActivity with the League's ID.
        Intent intent = getIntent();
        String id = intent.getStringExtra(LeagueModel.ID_LEAGUE);

        // Complement to complete the endpoint URL.
        String complement = "/lookup_all_teams.php?id=" + id;

        // GET request.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, Singleton.URL + complement, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray teamsArray = response.getJSONArray("teams");

                            for (int i = 0; i < teamsArray.length(); i++) {
                                JSONObject team = teamsArray.getJSONObject(i);

                                String id = team.getString("idTeam");
                                String name = team.getString("strTeam");
                                String stadium = team.getString("strStadium");
                                String badge = team.getString("strTeamBadge");
                                String jersey = team.getString("strTeamJersey");
                                String year = team.getString("intFormedYear");
                                String description = team.getString("strDescriptionEN");
                                String website = team.getString("strWebsite");
                                String facebook = team.getString("strFacebook");
                                String twitter = team.getString("strTwitter");
                                String instagram = team.getString("strInstagram");
                                //Log.d(TAG, id);

                                // Adding data to the model list.
                                teamModels.add(new TeamModel(
                                        id,
                                        name,
                                        stadium,
                                        badge,
                                        jersey,
                                        year,
                                        description,
                                        website,
                                        facebook,
                                        twitter,
                                        instagram));

                                // To reload the adapter.
                                teamAdapter.notifyDataSetChanged();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();

                            errorHandler(e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        errorHandler(error.toString());
                    }
                });

        Singleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public void errorHandler(String error) {
        Toast.makeText(TeamActivity.this, error, Toast.LENGTH_LONG).show();

        this.finish();
    }
}
