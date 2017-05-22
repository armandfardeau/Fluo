package com.neopixl.fluo.network;

/**
 * Created by Yvan Moté on 18/05/2017.
 */

public class UrlBuilder {

    private static final String baseUrl = "http://api.tvmaze.com/";

    public static String getEpisodesUrl(int number) {
        return baseUrl+"shows/"+number+"/episodes";
    }

}
