package com.neopixl.fluo.network;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.neopixl.fluo.FluoApp;
import com.neopixl.fluo.model.Episode;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Yvan Moté on 18/05/2017.
 */

public class EpisodeService {

    public interface EpisodesListener {
        void onEpisodesReceived(List<Episode> episodes);
        void onFailed();
    }


    public static void getEpisodes(int number, final EpisodesListener listener) {

        String url = UrlBuilder.getEpisodesUrl(number);

        JacksonRequest<Episode[]> request =
                new JacksonRequest<Episode[]>(Request.Method.GET, url,
                        new JacksonRequestListener<Episode[]>() {
                    @Override
                    public void onResponse(Episode[] response, int statusCode, VolleyError error) {

                        if(listener==null) {
                            return;
                        }

                        //
                        if(response!=null) {
                            // transformation d'un tableau ([Ø]) en List<> avec Arrays.asList
                            listener.onEpisodesReceived(Arrays.asList(response));
                        }

                        if(error!=null) {
                            listener.onFailed();
                        }


                    }

                    @Override
                    public JavaType getReturnType() {

                        // Pour un simple objet en retour
                        // SimpleType.constructUnsafe(Episode.class)

                        // Pour un tableau d'objets en retour
                        return ArrayType.construct(SimpleType.constructUnsafe(Episode.class), null);
                    }
                });

        FluoApp
                .getSharedInstance()
                .getRequestQueue()
                .add(request);

    }

}
