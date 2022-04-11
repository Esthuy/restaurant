package be.technifutur.restaurant.models.forms;

import lombok.Data;

@Data
public class RestaurantForm {
    private int id;
    private String name;
    private String description;
    private String typeOfFood;
    private String address;
    private String phoneNumber;
}
