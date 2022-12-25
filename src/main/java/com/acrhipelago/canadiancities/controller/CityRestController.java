package com.acrhipelago.canadiancities.controller;

import com.acrhipelago.canadiancities.model.City;
import com.acrhipelago.canadiancities.repository.CityGraphQLRepository;
import com.acrhipelago.canadiancities.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cities/")
public class CityRestController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CityGraphQLRepository CityGraphQLRepository;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<City>> getCity(@PathVariable("id") int cityId) {
        if(cityId == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<City> city = this.cityService.getById(cityId);

        if(city.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> saveCity(@RequestBody @Validated City city) {
        HttpHeaders headers = new HttpHeaders();

        if(city == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.cityService.save(city);
        return new ResponseEntity<>(city, headers, HttpStatus.CREATED);
    }
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> updateCity(@RequestBody @Validated City city) {
        HttpHeaders headers = new HttpHeaders();

        if(city == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.cityService.save(city);

        return new ResponseEntity<>(city, headers, HttpStatus.OK);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> deleteCity(@PathVariable("id") int id) {
        Optional<City> city = this.cityService.getById(id);

        if(city.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.cityService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAll();
        if(cities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @QueryMapping
    Iterable<City> cities() {
        return CityGraphQLRepository.findAll();
    }

    @QueryMapping
    Optional<City> cityById(@Argument int id) {
        return CityGraphQLRepository.findById(id);
    }
}
