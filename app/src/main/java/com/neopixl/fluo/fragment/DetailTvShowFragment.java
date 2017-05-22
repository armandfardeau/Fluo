package com.neopixl.fluo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.neopixl.fluo.R;
import com.neopixl.fluo.model.Episode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailTvShowFragment extends Fragment {

    private static final String ARGUMENT_TVSHOW = "tv_show";

    @BindView(R.id.fragment_detail_tvshow_title_textview)
    protected TextView titleTextView;

    // On affiche un TvShow (thumbs up!!!)
    private Episode episode;

    // Don't remove.
    public DetailTvShowFragment() {
        // Required empty public constructor
    }

    public static DetailTvShowFragment newInstance(Episode episode) {
        DetailTvShowFragment detailTvShowFragment = new DetailTvShowFragment();

        // Bundle = espace de stockage
        Bundle arguments = new Bundle();

        arguments.putParcelable(ARGUMENT_TVSHOW, episode);

        return detailTvShowFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail_tv_show, container, false);

        // Utilisation de butterknife pour relier les composants (BindView)
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    // Méthode appelée quand notre fragment est démarré (la vue a déjà été chargée)
    @Override
    public void onStart() {
        super.onStart();

        // récupérer l'espace de stockage sauvegardé
        // entre deux instances d'un même (Bundle arguments)
        Bundle arguments = getArguments();

        if(arguments!=null) {
            Episode episode = arguments.getParcelable(ARGUMENT_TVSHOW);

            setEpisode(episode);

            // Refresh UI
            refreshUI(episode);
        }

    }

    public void refreshUI(Episode episode) {
        if(episode !=null) {
            titleTextView.setText(episode.getName());
        }
    }


}
