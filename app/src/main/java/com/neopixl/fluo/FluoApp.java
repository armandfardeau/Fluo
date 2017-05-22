package com.neopixl.fluo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Yvan Moté on 11/05/2017.
 */

public class FluoApp extends Application {

    private RequestQueue requestQueue;

    // Singleton
    private static FluoApp sharedInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        // On assigne notre singleton au démarrage
        FluoApp.sharedInstance = this;

        // 1 queue par application (pour l'exemple ici)
        // mais possibilité d'en avoir plusieurs
        requestQueue = Volley.newRequestQueue(this);
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static FluoApp getSharedInstance() {
        return sharedInstance;
    }
}
