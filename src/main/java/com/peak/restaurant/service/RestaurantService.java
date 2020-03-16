package com.peak.restaurant.service;

import com.peak.restaurant.exception.RestaurantNotFoundException;
import com.peak.restaurant.model.Restaurant;
import com.peak.restaurant.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService  {

    private RestaurantRepository restaurantRepository;
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAllRestaurants() throws RestaurantNotFoundException{
        List<Restaurant> restaurantList = new ArrayList<>((Collection<? extends Restaurant>) restaurantRepository.findAll());
        if(restaurantList.isEmpty()){
            throw new RestaurantNotFoundException("Restaurants not found");
        }
        return restaurantList;
    }

    public List<Restaurant> getGoodRatedRestaurantsByCuisine(String cuisineType) throws IllegalArgumentException, RestaurantNotFoundException {
        List<Restaurant> cuisineTypeRestaurants = new ArrayList<>();
        if(cuisineType != null && !cuisineType.isEmpty() && cuisineType.length() >=2) {
            List<Restaurant> allRestaurants = restaurantRepository.findByCuisineIgnoreCase(cuisineType);
            cuisineTypeRestaurants = (List<Restaurant>)
                    allRestaurants.stream().filter(restaurant -> "N".equalsIgnoreCase(restaurant.getCriticalFlag())
                            && restaurant.getScore() <= 20)
                            .collect(Collectors.toList());
            if(cuisineTypeRestaurants.isEmpty()){
                throw new RestaurantNotFoundException("Restaurants with good rating not found of cuisine type "+ cuisineType);
            }
        }else{
            throw new IllegalArgumentException("cuisineType must not be null and should be min 2 characters");
        }
        return cuisineTypeRestaurants;
    }
}
