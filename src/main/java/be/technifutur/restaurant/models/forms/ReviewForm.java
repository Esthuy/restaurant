package be.technifutur.restaurant.models.forms;

import be.technifutur.restaurant.models.dto.RestaurantDTO;
import be.technifutur.restaurant.models.dto.UserDTO;
import be.technifutur.restaurant.models.entities.Restaurant;
import be.technifutur.restaurant.models.entities.User;
import lombok.Data;

@Data
public class ReviewForm {

    private int id;
    private User user;
    private Restaurant restaurant;
    private String title;
    private String comment;
    private int stars;
}
