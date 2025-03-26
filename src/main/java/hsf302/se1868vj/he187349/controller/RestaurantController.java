package hsf302.se1868vj.he187349.controller;

import hsf302.se1868vj.he187349.dao.impl.RestaurantDAOImpl;
import hsf302.se1868vj.he187349.service.RestaurantService;

import hsf302.se1868vj.he187349.service.RestaurantService;
import hsf302.se1868vj.he187349.service.impl.RestaurantServiceImpl;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;


import java.io.IOException;


public class RestaurantController {
    @FXML
    private Button addButton;

    private RestaurantService restaurantService;
    @FXML
    public void initialize() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HSF302_SE1868-VJ_HE187349_Lab02");
        this.restaurantService = new RestaurantServiceImpl(new RestaurantDAOImpl(emf));
        addButton.setOnAction(event -> goSave());
    }

    private void goSave() {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hsf302/se1868vj/he187349/save.fxml"));
            Scene scene = new Scene(loader.load());

            // Get the current stage and set the new scene
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
