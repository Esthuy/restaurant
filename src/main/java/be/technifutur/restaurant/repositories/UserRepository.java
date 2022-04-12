package be.technifutur.restaurant.repositories;

import be.technifutur.restaurant.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
