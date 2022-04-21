package be.technifutur.restaurant.utils;

import be.technifutur.restaurant.models.entities.Restaurant;
import be.technifutur.restaurant.models.entities.Review;
import be.technifutur.restaurant.models.entities.User;
import be.technifutur.restaurant.repositories.RestaurantRepository;
import be.technifutur.restaurant.repositories.ReviewRepository;
import be.technifutur.restaurant.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class DatabaseFiller implements InitializingBean {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;


    public DatabaseFiller(RestaurantRepository restaurantRepository, ReviewRepository reviewRepository, UserRepository userRepository, PasswordEncoder encoder) {
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public void afterPropertiesSet() {


        Restaurant restaurant = Restaurant.builder()
                .name("Labo4")
                .address("Rue du labo")
                .description("Resto sympa")
                .phoneNumber("0498/12.12.36")
                .typeOfFood("Belge")
                .build();

        restaurantRepository.save(restaurant);

        restaurant = Restaurant.builder()
                .name("Aigle d'or")
                .address("Rue de l'aigle")
                .description("top")
                .phoneNumber("0498/14.25.65")
                .typeOfFood("Belge")
                .build();
        restaurantRepository.save(restaurant);

        restaurant = Restaurant.builder()
                .name("Smile")
                .address("Place de la gentillesse")
                .description("Restaurant chaleureux")
                .phoneNumber("0498/65.45.25")
                .typeOfFood("Italien")
                .build();
        restaurantRepository.save(restaurant);

        User user = User.builder()
                .birthdate(new Date())
                .email("blalba@gmail.com")
                .username("toto")
                .isNotLocked(true)
                .password(encoder.encode("pass"))
                .build();

        userRepository.save(user);

        Review review = Review.builder()
                .comment("Amazing")
                .restaurant(restaurant)
                .stars(5)
                .title("The besy")
                .user(user)
                .build();

        reviewRepository.save(review);

        restaurant = Restaurant.builder()
                .name("Dragibus")
                .address("Avenue du bonbon")
                .description("Restaurant chic")
                .phoneNumber("0498/45.68.75")
                .typeOfFood("Italien")
                .build();
        restaurantRepository.save(restaurant);

        user = User.builder()
                .birthdate(new Date())
                .email("coucou@yahoo.fr")
                .username("tata")
                .isNotLocked(true)
                .password(encoder.encode("psw"))
                .build();

        userRepository.save(user);

        review = Review.builder()
                .comment("très bon")
                .restaurant(restaurant)
                .stars(3)
                .title("délicieux")
                .user(user)
                .build();

        reviewRepository.save(review);


    }
}
