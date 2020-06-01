package com.ahmed.eldakhakhny.softexpert.task.api;

import com.ahmed.eldakhakhny.softexpert.task.model.CarsResponse;
import com.ahmed.eldakhakhny.softexpert.task.view.CarsListViewInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CarsInteractor {

    // todo move to separtate class for the builder
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://demo1286023.mockable.io/")
            .build();

    CarsService service = retrofit.create(CarsService.class);

    void getCars(int page, final CarsListViewInterface view ){
        service.listCars(page).enqueue(new Callback<CarsResponse>() {
            @Override
            public void onResponse(Call<CarsResponse> call, Response<CarsResponse> response) {
                if (response.isSuccessful()){
                    if (response.body().getStatus() == 0){
                        // handling server error state
                        view.onError(response.body().getServerError().getCode(),response.body().getServerError().getMessage());
                    } else {
                        // handling  success state
                        view.onGetCarsResponse(response.body().getCars());
                    }
                } else {
                  // handling not successful response
                    view.onError();
                }

            }

            @Override
            public void onFailure(Call<CarsResponse> call, Throwable t) {
                // TODO log error
                view.onFailure();
            }
        });
    }
}
