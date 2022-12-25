package com.acrhipelago.canadiancities.service;

import com.acrhipelago.canadiancities.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    Optional<City> getById(int id);
    void save(City city);
    void delete(int id);
    List<City> getAll();
}
