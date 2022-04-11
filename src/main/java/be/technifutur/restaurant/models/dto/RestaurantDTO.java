package be.technifutur.restaurant.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RestaurantDTO {

    private int id;
    private String name;
    private String description;
    private String typeOfFood;
    private String address;
    private String phoneNumber;

    private List<ReviewDTO> reviews;
    private List<UserDTO> favoriteOf;

    public static class UserDTO{
        private int id;
        private String name;
    }
}
