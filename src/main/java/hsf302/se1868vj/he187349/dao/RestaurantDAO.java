package hsf302.se1868vj.he187349.dao;

import hsf302.se1868vj.he187349.entity.Restaurant;

import java.util.List;

public interface RestaurantDAO {
    void save(Restaurant restaurant);
    List<Restaurant> getAllRestaurants();
    boolean isRestaurantExistsByEmail(String email);
}
