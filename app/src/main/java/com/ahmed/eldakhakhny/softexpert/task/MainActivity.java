package com.ahmed.eldakhakhny.softexpert.task;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ahmed.eldakhakhny.softexpert.task.api.CarsInteractor;
import com.ahmed.eldakhakhny.softexpert.task.model.Car;
import com.ahmed.eldakhakhny.softexpert.task.view.CarsListViewInterface;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CarsListViewInterface {
    private EndlessRecyclerViewScrollListener scrollListener;
    private CarsInteractor carsInteractor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvItems = (RecyclerView) findViewById(R.id.rv_cars);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvItems.setLayoutManager(linearLayoutManager);
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                loadNextDataFromApi(page);
            }
        };
    }

    public void loadNextDataFromApi(int offset) {
        carsInteractor.getCars(offset, this);
    }

    void appendCars(ArrayList<Car> cars){

    }
    void restCarsList(){
        //to be used with pull to refresh
    }

    @Override
    public void onGetCarsResponse(ArrayList<Car> cars) {
        // TODO append  cars and notify change
    }

    @Override
    public void onError(Integer errorCode, String message) {
        // TODO display server error response
    }

    @Override
    public void onError() {
        // TODO display default error message
    }

    @Override
    public void onFailure() {
        // TODO display default failure response
    }
}
