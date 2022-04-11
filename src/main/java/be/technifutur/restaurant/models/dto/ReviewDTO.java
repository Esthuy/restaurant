package be.technifutur.restaurant.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDTO {

    private int id;
    private UserDTO user;
    private RestaurantDTO restaurant;
    private String title;
    private String comment;
    private int stars;

}
