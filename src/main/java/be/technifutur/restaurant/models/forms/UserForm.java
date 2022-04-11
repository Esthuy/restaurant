package be.technifutur.restaurant.models.forms;

import lombok.Data;

import java.util.Date;

@Data
public class UserForm {

    private int id;
    private String name;
    private String email;
    private Date birthdate;
}
