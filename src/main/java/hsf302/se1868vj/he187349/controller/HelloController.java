package hsf302.se1868vj.he187349.controller;

import hsf302.se1868vj.he187349.dao.impl.RestaurantDAOImpl;
import hsf302.se1868vj.he187349.entity.Restaurant;
import hsf302.se1868vj.he187349.service.RestaurantService;
import hsf302.se1868vj.he187349.service.impl.RestaurantServiceImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class HelloController {
    @FXML private TextField name;
    @FXML private TextField email;
    @FXML private TextField address;
    @FXML private Button btnSave;
    @FXML private Button btnBack;
    @FXML
    private Label errorLabel;
    @FXML
    private Label success;
    private RestaurantService restaurantService;


    @FXML
    public void initialize() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HSF302_SE1868-VJ_HE187349_Lab02");
        this.restaurantService = new RestaurantServiceImpl(new RestaurantDAOImpl(emf));
        btnSave.setOnAction(event -> save());
        btnBack.setOnAction(event -> goBack());
    }

    private void save() {
        String name = this.name.getText();
        String email = this.email.getText();
        String address = this.address.getText();

        if (name.isEmpty() || email.isEmpty() || address.isEmpty()) {
            System.out.println("Vui lòng nhập đầy đủ thông tin!");
            success.setText("");
            errorLabel.setText("Tên, email, address không được để trống");
            return;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        if (!email.matches(emailRegex) && !email.isEmpty()) {
            success.setText("");
            errorLabel.setText("Email không hợp lệ");
            return;
        }

        if (restaurantService.checkIfRestaurantExists(email)) {
            success.setText("");
            errorLabel.setText("Email đã tồn tại");
            return;
        }
        try {
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantName(name);
            restaurant.setEmail(email);
            restaurant.setAddress(address);
            LocalDate currentLocalDate = LocalDate.now();
            Date currentDate = Date.valueOf(currentLocalDate);
            restaurant.setCreatedDate(currentDate);

            restaurantService.createRestaurant(restaurant);
            success.setText("Tạo nhà hàng thành công");
            System.out.println("Lưu thành công: " + name);
            clearFields();
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private void clearFields() {
        this.name.clear();
        this.email.clear();
        this.address.clear();
        this.errorLabel.setText("");
    }

    private void goBack() {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hsf302/se1868vj/he187349/list-restaurant.fxml"));
            Scene scene = new Scene(loader.load());

            // Get the current stage and set the new scene
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}