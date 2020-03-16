package com.peak.restaurant.controller;

import com.peak.restaurant.exception.RestaurantNotFoundException;
import com.peak.restaurant.model.Restaurant;
import com.peak.restaurant.response.RestaurantResponse;
import com.peak.restaurant.service.RestaurantService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RestaurantControllerTest {

    @Mock
    private RestaurantService mockedRestaurantService;

    @InjectMocks
    private RestaurantController restaurantController;

    private List<RestaurantResponse> mockedThaiRestaurants = new ArrayList<>();
    private List<Restaurant> mockedRestaurants = new ArrayList<>();

    @BeforeEach
    public void setUp() {

        Restaurant mockedRestaurant1 = new Restaurant(3, "Luck Thai", "Brooklyn", "386",
                "36TH AVE", "11215", "2432435822",
                "Thai", "02G", "N", 20, "B");
        Restaurant mockedRestaurant2 = new Restaurant(4, "Lantern", "Brooklyn", "101",
                "MONTAGUE STREET", "11201", "24324352341",
                "Thai", "06D", "N", 10, "B");
        RestaurantResponse restaurantResponse1 = new RestaurantResponse( "Luck Thai", "Brooklyn", "386",
                "36TH AVE", "11215", "2432435822",
                "Thai");
        RestaurantResponse restaurantResponse2 = new RestaurantResponse( "Lantern", "Brooklyn", "101",
                "MONTAGUE STREET", "11201", "24324352341",
                "Thai");
        mockedRestaurants.add(mockedRestaurant1);
        mockedRestaurants.add(mockedRestaurant2);
        mockedThaiRestaurants.add(restaurantResponse1);
        mockedThaiRestaurants.add(restaurantResponse2);
    }

    @Test
    void testGetRestaurantsByValidCuisine() throws RestaurantNotFoundException {
        Mockito.when(mockedRestaurantService.getGoodRatedRestaurantsByCuisine("Thai")).thenReturn(mockedRestaurants);
       List< RestaurantResponse> restaurantResponse = restaurantController.getGoodRatedRestaurants
               ("Thai").getBody();
        assertEquals(2, restaurantResponse.size());
        assertEquals("Thai", restaurantResponse.get(0).getCuisine());
    }

   @Ignore
    void testGetRestaurantsByInvalidInputThrowsIllegalArguementException() throws RestaurantNotFoundException {
        Mockito.when(mockedRestaurantService.getGoodRatedRestaurantsByCuisine(null)).thenThrow(IllegalArgumentException.class);

        HttpStatus responseStatusCode =  restaurantController.getGoodRatedRestaurants
                (null).getStatusCode();

        assertEquals(HttpStatus.BAD_REQUEST, responseStatusCode);
    }


}
