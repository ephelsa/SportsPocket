package com.condorlabstest.ephelsa.sportinformation.Controller.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.condorlabstest.ephelsa.sportinformation.Model.Data.EventModel;
import com.condorlabstest.ephelsa.sportinformation.R;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    // Model array
    private List<EventModel> eventModels;
    private Context context;

    public EventAdapter(List<EventModel> eventModels) {
        this.eventModels = eventModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();

        // Item view inflater.

        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.cardview_event, viewGroup, false);

        // View holder creation.
        ViewHolder holder = new ViewHolder(itemView);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        String date = eventModels.get(i).getDate();

        // Not yet defined.
        if (!date.equals("null"))
            viewHolder.date
                    .setText(eventModels.get(i).getDate());


        viewHolder.title
                .setText(eventModels.get(i).getEvent());

        viewHolder.time
                .setText(eventModels.get(i).getTime());
    }

    @Override
    public int getItemCount() {
        return eventModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView title;
        private TextView date;
        private TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            title = itemView.findViewById(R.id.filename);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }
}
