package hsf302.se1868vj.he187349.service.impl;

import hsf302.se1868vj.he187349.dao.RestaurantDAO;
import hsf302.se1868vj.he187349.entity.Restaurant;
import hsf302.se1868vj.he187349.service.RestaurantService;

import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantDAO restaurantDAO;

    public RestaurantServiceImpl(RestaurantDAO restaurantDAO) {
        this.restaurantDAO = restaurantDAO;
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        if (restaurant == null) {
            throw new IllegalArgumentException("Nhà hàng không được để trống");
        }

        // Logic kiểm tra trước khi lưu vào DB (nếu cần)
        if (restaurant.getRestaurantName() == null || restaurant.getRestaurantName().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên nhà hàng không được để trống");
        }
        if (restaurant.getEmail() == null || !restaurant.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email không hợp lệ");
        }

        restaurantDAO.save(restaurant);

    }

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantDAO.getAllRestaurants();
    }

    @Override
    public boolean checkIfRestaurantExists(String email) {
        return restaurantDAO.isRestaurantExistsByEmail(email);
    }
}
