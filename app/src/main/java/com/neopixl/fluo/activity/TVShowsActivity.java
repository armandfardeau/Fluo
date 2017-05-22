package com.neopixl.fluo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;
import com.neopixl.fluo.R;
import com.neopixl.fluo.adapteritem.TvShowItem;
import com.neopixl.fluo.model.Episode;
import com.neopixl.fluo.network.EpisodeService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TVShowsActivity extends AppCompatActivity {

    // équivalent à = (RecyclerView)findViewById(R.id.recyclerview_tvshows)
    @BindView(R.id.recyclerview_tvshows)
    protected RecyclerView recyclerView;

    private List<Episode> episodes;
    private FastItemAdapter<TvShowItem> tvShowsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshows);

        ButterKnife.bind(this);

        //recyclerView = (RecyclerView)findViewById(R.id.recyclerview_tvshows);

        episodes = new ArrayList<>();

        episodes.add(new Episode("Arrested Development"));
        episodes.add(new Episode("Shameless"));
        episodes.add(new Episode("X-Files"));
        episodes.add(new Episode("Twin Peaks"));
        episodes.add(new Episode("Friends"));
        episodes.add(new Episode("The Walking Dead"));
        episodes.add(new Episode("Black Mirror"));
        episodes.add(new Episode("Silicon Valley"));
        episodes.add(new Episode("Viking"));
        episodes.add(new Episode("Iron Fist"));
        episodes.add(new Episode("Xena"));
        episodes.add(new Episode("Le caméléon"));
        episodes.add(new Episode("Highlander"));
        episodes.add(new Episode("Louis La Brocante"));
        episodes.add(new Episode("Mr Robot"));
        episodes.add(new Episode("Navarro"));
        episodes.add(new Episode("Hélène et les garçons"));
        episodes.add(new Episode("Le bureau des légendes"));
        episodes.add(new Episode("Joséphine"));

        // Adapter = composant responsable de fournir les cellules à la RecyclerView
        tvShowsAdapter = new FastItemAdapter<TvShowItem>();

        /*
        for(Episode episode : episodes) {
            tvShowsAdapter.add(new TvShowItem(episode));
        }
        */

        EpisodeService.getEpisodes(73, new EpisodeService.EpisodesListener() {
            @Override
            public void onEpisodesReceived(List<Episode> episodes) {

                for(Episode episode : episodes) {
                    tvShowsAdapter.add(new TvShowItem(episode));
                }

            }

            @Override
            public void onFailed() {

            }
        });




        // Configuration de l'affichage des cellules dans le RecyclerView (Horizontal / Vertical)

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        // Liaison de l'adapter à notre RecyclerView
        recyclerView.setAdapter(tvShowsAdapter);

        tvShowsAdapter.withOnClickListener(new FastAdapter.OnClickListener<TvShowItem>() {
            @Override
            public boolean onClick(View v, IAdapter<TvShowItem> adapter,
                                   TvShowItem item, int position) {

                // Interception du tap sur une cellule

                Episode episode = item.getEpisode();

                // Démarrage de l'activité

                Intent intent = new Intent(TVShowsActivity.this,
                        DetailTvShowActivity.class);

                // transfert le tvShow à l'activité future
                intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, episode);

                startActivity(intent);

                return true;
            }
        });

    }



}
