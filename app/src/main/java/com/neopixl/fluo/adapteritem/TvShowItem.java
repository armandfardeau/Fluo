package com.neopixl.fluo.adapteritem;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.neopixl.fluo.R;
import com.neopixl.fluo.model.Episode;
import com.neopixl.fluo.model.Image;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yvan Moté on 11/05/2017.
 */

public class TvShowItem extends AbstractItem<TvShowItem, TvShowItem.ViewHolder> {

    private final Episode episode;

    // Constructeur pour créer l'objet
    public TvShowItem(Episode episode) {
        this.episode = episode;
    }

    public Episode getEpisode() {
        return episode;
    }

    @Override
    public ViewHolder getViewHolder(View v) {
        ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.refresh(episode);

        return viewHolder;
    }

    @Override
    public int getType() {
        return R.id.row_tvshow_textview_name;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_tvshow;
    }

    // Méthode appelée pour le recyclage des ViewHolder
    @Override
    public void bindView(ViewHolder holder, List<Object> payloads) {
        super.bindView(holder, payloads);

        holder.refresh(episode);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.row_tvshow_textview_name)
        protected TextView textViewName;

        @BindView(R.id.row_tvshow_imageview)
        protected ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        // Refresh UI - binding
        public void refresh(Episode episode) {
            textViewName.setText(episode.getName());

            String imageUrl = episode.getImage().getMedium();

            //Chargement de l'image dans l'imageView + mise en cache
            Glide.with(imageView)
                    .load(imageUrl)
                    .into(imageView);
        }
    }

}
