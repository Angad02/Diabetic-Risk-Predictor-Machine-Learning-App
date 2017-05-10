package com.example.hp1.deephack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hp1.deephack.rest.DeepService;
import com.example.hp1.deephack.rest.MedicalData;
import com.example.hp1.deephack.rest.Prediction;

import org.parceler.Parcels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PredictionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        Intent i = getIntent();
        MedicalData data = Parcels.unwrap(i.getParcelableExtra("data"));
        DeepService.getInstance().submitData(data, new Callback<Prediction>() {
            @Override
            public void onResponse(Call<Prediction> call, Response<Prediction> response) {

            }

            @Override
            public void onFailure(Call<Prediction> call, Throwable t) {

            }
        });
    }
}
