package com.example.androiddeezer2020.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddeezer2020.R;
import com.example.androiddeezer2020.service.data.Track;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {
    private static final String TAG = "AdapterTrack";

    private List<Track> listTrack;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textTrackName;
        private ImageView imageView;
        private View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            //c'est ici que l'on fait nos findView
            textTrackName = (TextView) itemView.findViewById(R.id.textTrackName);
            imageView = (ImageView) itemView.findViewById(R.id.imageTrack);
        }
    }

    public TrackAdapter(List<Track> listTrack) {
        this.listTrack = listTrack;

    }

    @NonNull
    @Override
    public TrackAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_track, parent, false);
        TrackAdapter.ViewHolder vh = new TrackAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TrackAdapter.ViewHolder holder, int position) {
        final Track track = listTrack.get(position);

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textTrackName.setText(track.getName());


        Picasso.get().load(track.getPicture()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "click on <" + track.getId() + ">");

            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
