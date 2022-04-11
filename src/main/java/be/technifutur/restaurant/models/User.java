package be.technifutur.restaurant.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "user_birthdate", nullable = false)
    private Date birthdate;

    @OneToMany
    private List<Review> reviews;

    @OneToMany
    private List<Restaurant> favorites;

}
