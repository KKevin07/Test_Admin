package com.example.test_thymeleaf_web.service.impl;

import com.example.test_thymeleaf_web.bean.City;
import com.example.test_thymeleaf_web.mapper.CityMapper;
import com.example.test_thymeleaf_web.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;

    Counter counter;

    public CityServiceImpl(MeterRegistry meterRegistry){

         counter = meterRegistry.counter("CityService.saveCity.count");
    }

    public City getById(Long id){
       return cityMapper.getById(id);

    }

    public void saveCity(City city) {
        counter.increment();
        cityMapper.insert(city);
    }
}
