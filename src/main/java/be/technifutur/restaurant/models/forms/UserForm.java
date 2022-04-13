package be.technifutur.restaurant.models.forms;

import be.technifutur.restaurant.models.entities.Restaurant;
import be.technifutur.restaurant.models.entities.Review;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserForm {

    private int id;
    private String name;
    private String email;
    private String password;
    private Date birthdate;
    private List<Review> reviews;
    private List<Restaurant> favorites;

}
