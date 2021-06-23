package com.example.test_thymeleaf_web.service;

import com.example.test_thymeleaf_web.bean.City;

public interface CityService {
    public City getById(Long id);



    public void saveCity(City city);

}
