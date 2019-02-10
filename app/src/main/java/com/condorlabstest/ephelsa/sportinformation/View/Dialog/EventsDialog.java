package com.condorlabstest.ephelsa.sportinformation.View.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.condorlabstest.ephelsa.sportinformation.Controller.Adapter.EventAdapter;
import com.condorlabstest.ephelsa.sportinformation.Controller.Singleton.Singleton;
import com.condorlabstest.ephelsa.sportinformation.Model.Data.EventModel;
import com.condorlabstest.ephelsa.sportinformation.Model.Interface.VolleyErrorHandler;
import com.condorlabstest.ephelsa.sportinformation.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EventsDialog extends Dialog implements VolleyErrorHandler {

    private final static String TAG = EventsDialog.class.getSimpleName();

    private String teamID;
    private Context context;

    // View
    private TextView title;

    // Recyclerview Elements
    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<EventModel> eventModels;

    public EventsDialog(Context context, String title, String teamID) {
        super(context);
        this.teamID = teamID;
        this.context = context;

        // View def.
        this.setContentView(R.layout.dialog_events);
        this.title = findViewById(R.id.title);
        this.recyclerView = findViewById(R.id.recyclerView);

        // Def
        this.eventModels = new ArrayList<>();
        this.eventAdapter = new EventAdapter(eventModels);

        // Setting view.
        this.title.setText(title);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setAdapter(eventAdapter);

        getData();
    }

    private void getData() {
        // Complement to the endpoint.
        String complement = "/eventsnext.php?id=" + teamID;

        // GET Request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, Singleton.URL + complement, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        //Log.i(TAG, response.toString());

                        try {
                            JSONArray eventsArray = response.getJSONArray("events");


                            for (int i = 0; i < eventsArray.length(); i++) {
                                JSONObject event = eventsArray.getJSONObject(i);

                                String eventName = event.getString("strEvent");
                                String date = event.getString("strDate");
                                String time = event.getString("strTime");

                                eventModels.add(new EventModel(
                                        eventName,
                                        date,
                                        time));

                                eventAdapter.notifyDataSetChanged();
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

        Singleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public void errorHandler(String error) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show();

        this.dismiss();
    }
}
