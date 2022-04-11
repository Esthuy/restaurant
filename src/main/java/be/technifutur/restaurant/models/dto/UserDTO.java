package be.technifutur.restaurant.models.dto;

import lombok.Builder;
import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
@Builder
public class UserDTO {

    private int id;
    private String name;
    private String email;
    private Date birthdate;
    private List<ReviewDTO> reviews;
    private List<RestaurantDTO> favorites;

}
