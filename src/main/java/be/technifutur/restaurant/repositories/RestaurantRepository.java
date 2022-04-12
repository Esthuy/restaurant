package be.technifutur.restaurant.repositories;

import be.technifutur.restaurant.models.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
