package hsf302.se1868vj.he187349.entity;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name = "Restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Restaurant_ID")
    private int restaurantId;
    @Column(name = "Restaurant_Name", length = 50, nullable = false, columnDefinition = "NVARCHAR(50)")
    private String restaurantName;
    @Column(name = "Email", length = 50, nullable = false, columnDefinition = "NVARCHAR(50)")
    private String email;
    @Column(name = "Address", length = 100, nullable = false, columnDefinition = "NVARCHAR(100)")
    private String address;
    @Column(name = "Created_Date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    public Restaurant() {
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
