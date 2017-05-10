package com.example.hp1.deephack.rest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DeepApi {
    @Headers({"Cache-Control: max-age=640000", "User-Agent: DeepHealth"})
    @POST("/information")
    Call<Prediction> submitData(@Body MedicalData data);
}
