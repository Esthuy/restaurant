package be.technifutur.restaurant.models.dto;

import lombok.AllArgsConstructor;
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

    @AllArgsConstructor
    @Data
    public static class UserDTO{
        private int id;
        private String username;
    }

    @AllArgsConstructor
    @Data
    public static class RestaurantDTO{
        private int id;
        private String name;
    }


}
