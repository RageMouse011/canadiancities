package com.acrhipelago.canadiancities.service;

import com.acrhipelago.canadiancities.model.City;
import com.acrhipelago.canadiancities.repository.CityRestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CityServiceImp implements CityService{
    @Autowired
    CityRestRepository cityRestRepository;



    @Override
    public Optional<City> getById(int id) {
        log.info("In CityServiceImp getById {}", id);
        return cityRestRepository.findById(id);
    }

    @Override
    public void save(City city) {
        log.info("In CityServiceImp save {}", city);
        cityRestRepository.save(city);
    }

    @Override
    public void delete(int id) {
        log.info("In CityServiceImp delete {}", id);
        cityRestRepository.deleteById(id);
    }

    @Override
    public List<City> getAll() {
        log.info("In CityServiceImp getAll {}");
        return cityRestRepository.findAll();
    }
}
