package com.peak.restaurant.service;

import com.peak.restaurant.exception.RestaurantNotFoundException;
import com.peak.restaurant.model.Restaurant;
import com.peak.restaurant.repository.RestaurantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {

    @Mock
    private RestaurantRepository mockedRestaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    private List<Restaurant> mockedRestaurants = new ArrayList<>();
    private List<Restaurant> mockedThaiRestaurants = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Restaurant mockedRestaurant1 = new Restaurant(1, "Japanese Restaurant", "Queens", "4511",
                "QUEENS BLVD", "11104", "243243553",
                "Japanese", "Nfdsf", "N", 20, "A");
        Restaurant mockedRestaurant2 = new Restaurant(2, "Chela", "Queens", "3309",
                "36TH AVE", "11106", "243243587",
                "Mexican", "04M", "Y", 20, "A");
        Restaurant mockedRestaurant3 = new Restaurant(3, "Luck Thai", "Brooklyn", "386",
                "36TH AVE", "11215", "2432435822",
                "Thai", "02G", "N", 20, "B");
        Restaurant mockedRestaurant4 = new Restaurant(4, "Lantern", "Brooklyn", "101",
                "MONTAGUE STREET", "11201", "24324352341",
                "Thai", "06D", "N", 10, "B");
        mockedRestaurants.add(mockedRestaurant1);
        mockedRestaurants.add(mockedRestaurant2);
        mockedRestaurants.add(mockedRestaurant3);
        mockedRestaurants.add(mockedRestaurant4);
        mockedThaiRestaurants.add(mockedRestaurant3);
        mockedThaiRestaurants.add(mockedRestaurant4);
    }

    @Test
    public void testGetAllRestaurants() throws RestaurantNotFoundException {
        List<Restaurant> mockedResponseRestaurants = new ArrayList<>(mockedRestaurants);
        Mockito.when(mockedRestaurantRepository.findAll()).thenReturn(mockedResponseRestaurants);
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        assertEquals(mockedResponseRestaurants, restaurants);
    }

    @Test
    void testGetAllRestaurantsThrowsException() throws RestaurantNotFoundException {
        Mockito.when(mockedRestaurantRepository.findAll()).thenReturn(new ArrayList<>());
        Assertions.assertThrows(RestaurantNotFoundException.class, ()-> restaurantService.getAllRestaurants());
    }

    @Test
    public void testGetThaiRestaurants() throws RestaurantNotFoundException, IllegalArgumentException {
        List<Restaurant> mockedResponseRestaurants = new ArrayList<>(mockedThaiRestaurants);
        Mockito.when(mockedRestaurantRepository.findByCuisineIgnoreCase("Thai")).thenReturn(mockedResponseRestaurants);
        List<Restaurant> restaurants = restaurantService.getGoodRatedRestaurantsByCuisine("Thai");
        assertEquals(mockedResponseRestaurants, restaurants);
    }

    @Test
    public void testGetThaiRestaurantsForInvalidCuisine() throws  IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> restaurantService.getGoodRatedRestaurantsByCuisine("f"));
    }

    @Test
    public void testGetThaiRestaurantsForNullCuisine() throws  IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> restaurantService.getGoodRatedRestaurantsByCuisine(null));
    }

    @Test
    void testGetThaiRestaurantsForNonExistentCuisine() {
        Assertions.assertThrows(RestaurantNotFoundException.class, ()-> restaurantService.getGoodRatedRestaurantsByCuisine("123"));
    }
}
