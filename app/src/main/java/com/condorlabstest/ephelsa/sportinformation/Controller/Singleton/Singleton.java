package com.condorlabstest.ephelsa.sportinformation.Controller.Singleton;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Singleton {

    // URL prefix used to consume the endpoints.
    public final static String URL = "https://www.thesportsdb.com/api/v1/json/1";


    /* Code from Android Developers: https://developer.android.com/training/volley/requestqueue#singleton
     * */
    private static Singleton mInstance;
    private RequestQueue mRequestQueue;
    private Context context;

    public Singleton(Context context) {
        this.context = context;
    }

    public static synchronized Singleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Singleton(context);
        }

        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
