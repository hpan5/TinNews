package com.laioffer.tinnews.network;

import android.content.Context;
import android.util.Log;

import com.ashokvarma.gander.GanderInterceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {
    // TODO: Assign your API_KEY here
    private static final String API_KEY = "5892d5948e9c4c8bb6a2391f0924db36";
    private static final String BASE_URL = "https://newsapi.org/v2/";

    public static Retrofit newInstance(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(new GanderInterceptor(context).showNotification(true))
                .build();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    private static class HeaderInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request original = chain.request();
            Request request = original
                    .newBuilder()
                    .header("X-Api-Key", API_KEY)
                    .build();
            Log.d("getTopHeadlines", "request is" + request.toString());
            Log.d("getTopHeadlines", "header is " + request.header("X-Api-Key").toString());
            return chain.proceed(request);
        }
    }
}