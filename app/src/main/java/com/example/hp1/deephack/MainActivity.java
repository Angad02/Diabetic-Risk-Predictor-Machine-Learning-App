package com.example.hp1.deephack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hp1.deephack.rest.DeepService;
import com.example.hp1.deephack.rest.MedicalData;
import com.example.hp1.deephack.rest.Prediction;

import org.parceler.Parcels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;


public class MainActivity extends Activity {

    EditText arg1;
    EditText arg2;
    EditText arg3;
    EditText arg4;
    EditText arg5;
    EditText arg6;
    EditText arg7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arg1 = (EditText) findViewById(R.id.arg1);
        arg2 = (EditText) findViewById(R.id.arg2);
        arg3 = (EditText) findViewById(R.id.arg3);
        arg4 = (EditText) findViewById(R.id.arg4);
        arg5 = (EditText) findViewById(R.id.arg5);
        arg6 = (EditText) findViewById(R.id.arg6);
        arg7 = (EditText) findViewById(R.id.arg7);
    }

    public void submit(View v) {
        Timber.d("Button clicked");
        try {
            int admissionSource = Integer.getInteger(arg1.getText().toString());
            int numLabProcedures = Integer.getInteger(arg2.getText().toString());
            int diag1 = Integer.getInteger(arg3.getText().toString());
            int numDiagnoses = Integer.getInteger(arg4.getText().toString());
            int numProcedures = Integer.getInteger(arg5.getText().toString());
            int numMedication = Integer.getInteger(arg6.getText().toString());
            int maxGluAmount = Integer.getInteger(arg7.getText().toString());

            MedicalData data = new MedicalData(admissionSource,
                    numLabProcedures,
                    diag1,
                    numDiagnoses,
                    numProcedures,
                    numMedication,
                    maxGluAmount);
            Intent i = new Intent(MainActivity.this, PredictionActivity.class);
            i.putExtra("data", Parcels.wrap(data));
            startActivity(i);
        } catch (NullPointerException|ClassCastException ce) {
            Toast.makeText(this, getString(R.string.error_input), Toast.LENGTH_LONG).show();
        }
    }
}
