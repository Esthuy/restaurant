package be.technifutur.restaurant.models.forms;

import be.technifutur.restaurant.models.entities.Review;
import be.technifutur.restaurant.models.entities.User;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantForm {

    private int id;
    private String name;
    private String description;
    private String typeOfFood;
    private String address;
    private String phoneNumber;
    private List<Review> reviews;
    private List<User> favoriteOf;
}
