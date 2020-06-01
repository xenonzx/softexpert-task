package com.ahmed.eldakhakhny.softexpert.task.view;

import com.ahmed.eldakhakhny.softexpert.task.model.Car;

import java.util.ArrayList;

public interface CarsListViewInterface {
    void onGetCarsResponse(ArrayList<Car> cars);
    void onError(Integer errorCode,String message);
    void onError();
    void onFailure();

}
