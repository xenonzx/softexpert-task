package com.ahmed.eldakhakhny.softexpert.task.api;

import com.ahmed.eldakhakhny.softexpert.task.model.CarsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CarsService {
    @GET("/api/v1/cars")
    Call<CarsResponse> listCars(@Query("page") int page);
}
