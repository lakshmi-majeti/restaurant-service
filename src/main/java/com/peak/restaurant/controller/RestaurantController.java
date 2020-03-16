package com.peak.restaurant.controller;

import com.peak.restaurant.exception.RestaurantNotFoundException;
import com.peak.restaurant.model.Restaurant;
import com.peak.restaurant.response.RestaurantResponse;
import com.peak.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(path = "/restaurants/{cuisine-type}")
    public ResponseEntity<List<RestaurantResponse>> getGoodRatedRestaurants(@PathVariable(value = "cuisine-type") String cuisineType) throws RestaurantNotFoundException {
            List<Restaurant> restaurantList = restaurantService.getGoodRatedRestaurantsByCuisine(cuisineType);
            List<RestaurantResponse> restaurantResponse =  restaurantList.stream().map(restaurant ->
                  new RestaurantResponse(restaurant.getName(), restaurant.getBoro(), restaurant.getBuilding(),
                         restaurant.getStreet(), restaurant.getZipCode(), restaurant.getPhone(), restaurant.getCuisine())
            ).collect(Collectors.toList());
            return new ResponseEntity<>(restaurantResponse, HttpStatus.OK);
        }

}
