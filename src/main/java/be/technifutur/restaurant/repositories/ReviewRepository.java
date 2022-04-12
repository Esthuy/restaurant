package be.technifutur.restaurant.repositories;

import be.technifutur.restaurant.models.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
