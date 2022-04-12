package be.technifutur.restaurant.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    private List<User> favoriteOf = new ArrayList<>();


}
