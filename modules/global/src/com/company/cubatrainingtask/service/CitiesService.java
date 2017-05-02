package com.company.cubatrainingtask.service;


import com.company.cubatrainingtask.entity.City;

public interface CitiesService {
    String NAME = "cubatrainingtask_CitiesService";

    City getDefaultCity();
    void resetDefaultCity(String code);
}