package be.technifutur.restaurant.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "review")
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Restaurant restaurant;

    @Column(name = "review_title", nullable = false)
    private String title;

    @Column(name = "review_comment", nullable = false)
    private String comment;

    @Column(name = "review_stars", nullable = false)
    private int stars;

}
