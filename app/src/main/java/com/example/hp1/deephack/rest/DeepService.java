package com.example.hp1.deephack.rest;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class DeepService {
    public static final String BASE_URL = "http://10.0.2.2:8000";
    public final Retrofit retrofit;
    final DeepApi deepApi;
    private static DeepService instance = null;

    private DeepService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        deepApi = retrofit.create(DeepApi.class);
    }

    public static DeepService getInstance() {
        if (instance == null) {
            instance = new DeepService();
        }
        return instance;
    }

    public void submitData(MedicalData data, final Callback<Prediction> callback) {
        final Call<Prediction> call = deepApi.submitData(data);
        call.enqueue(new Callback<Prediction>() {
            @Override
            public void onResponse(Call<Prediction> call, Response<Prediction> response) {
                Timber.d("Response received!");
                if (response.isSuccessful()) {
                    Timber.d("Response:" + response.body().getRespsonse());
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<Prediction> call, Throwable t) {
                callback.onFailure(call, new Throwable(t.getLocalizedMessage()));
            }
        });
    }

}


