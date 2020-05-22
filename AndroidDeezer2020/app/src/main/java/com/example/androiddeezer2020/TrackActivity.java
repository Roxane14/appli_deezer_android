package com.example.androiddeezer2020;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.androiddeezer2020.adapter.TrackAdapter;
import com.example.androiddeezer2020.service.DeezerService;
import com.example.androiddeezer2020.service.data.DataSearchTrack;

public class TrackActivity extends AppCompatActivity {
    private static final String TAG = "TrackActivity";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private String lastText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = findViewById(R.id.progress_circular);
        hideProgress();

        recyclerView = (RecyclerView) findViewById(R.id.author_recycler_view);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //récupérer l'ID de l'album de AlbumAdapter
        String idAlbum = getIntent().getStringExtra("idAlbum");
//
        //Log.d("intent", idAlbum);
//
        Response.Listener<DataSearchTrack> rep3 = new Response.Listener<DataSearchTrack>() {
            @Override
            public void onResponse(DataSearchTrack response) {
                //Log.d(TAG, "searchTrack Found " + response.getTotal() + " album");
                TrackAdapter mAdapter = new TrackAdapter(response.getData());
                recyclerView.setAdapter(mAdapter);
                hideProgress();

            }
        };

        final Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "searchTrack onErrorResponse: " + error.getMessage());
                hideProgress();
            }
        };
//
//        //Pour la recherche d'album
        DeezerService.searchTrack(idAlbum, rep3, error, TrackActivity.this);

    }

    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

}
