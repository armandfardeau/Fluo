package com.neopixl.fluo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.neopixl.fluo.R;
import com.neopixl.fluo.fragment.DetailTvShowFragment;
import com.neopixl.fluo.model.Episode;

public class DetailTvShowActivity extends AppCompatActivity {

    public static final String EXTRA_TVSHOW = "tv_show";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        // Extra = metadata (informations supplémentaires)
        Episode episode = getIntent().getParcelableExtra(EXTRA_TVSHOW);

        // transfert du TvShow au fragment

        DetailTvShowFragment detailTvShowFragment =
                (DetailTvShowFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.fragment_detail_tvshow);

        if(detailTvShowFragment!=null) {
            detailTvShowFragment.refreshUI(episode);
        }


    }
}
