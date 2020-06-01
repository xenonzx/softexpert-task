package com.ahmed.eldakhakhny.softexpert.task.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarsResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("cars")
    @Expose
    private List<Car> cars = null;
    @SerializedName("error")
    @Expose
    private ServerError serverError;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public ServerError getServerError() {
        return serverError;
    }

    public void setServerError(ServerError serverError) {
        this.serverError = serverError;
    }

}
