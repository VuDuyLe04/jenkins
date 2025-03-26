package hsf302.se1868vj.he187349.service;

import hsf302.se1868vj.he187349.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    void createRestaurant(Restaurant restaurant);
    List<Restaurant> getRestaurants();
    boolean checkIfRestaurantExists(String email);
}
