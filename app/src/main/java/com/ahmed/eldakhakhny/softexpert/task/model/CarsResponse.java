package com.ahmed.eldakhakhny.softexpert.task.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CarsResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("cars")
    @Expose
    private ArrayList<Car> cars = null;
    @SerializedName("error")
    @Expose
    private ServerError serverError;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
    public ServerError getServerError() {
        return serverError;
    }

    public void setServerError(ServerError serverError) {
        this.serverError = serverError;
    }

}
