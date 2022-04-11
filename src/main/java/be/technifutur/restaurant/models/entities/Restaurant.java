package be.technifutur.restaurant.models.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(nullable = false, name = "restaurant_name")
    private String name;

    @Column(name = "restaurant_description")
    private String description;

    @Column(name = "restaurant_typeOfFood")
    private String typeOfFood; //Enum ? plusieurs possible TODO

    @Column(nullable = false, name = "restaurant_address")
    private String address;

    @Column(nullable = false, name = "restaurant_phoneNumber")
    private String phoneNumber;

    @OneToMany
    private List<Review> reviews;

    private List<User> favoriteOf;


}
