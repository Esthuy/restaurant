package be.technifutur.restaurant.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
@Builder
public class UserDTO {

    private int id;
    private String username;
    private String email;
    private String password;
    private Date birthdate;
    private List<ReviewDTO> reviews;
    private List<RestaurantDTO> favorites;

    @AllArgsConstructor
    @Data
    public static class ReviewDTO{
        private int id;
        private String title;
        private String comment;
        private int stars;
        private RestaurantDTO restaurantDTO;
    }

    @AllArgsConstructor
    @Data
    public static class RestaurantDTO{
        private int id;
        private String name;
    }

}
