package be.technifutur.restaurant.utils;

import be.technifutur.restaurant.models.entities.Restaurant;
import be.technifutur.restaurant.repositories.RestaurantRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;



@Component
public class DatabaseFiller implements InitializingBean {

    private final RestaurantRepository restaurantRepository;


    public DatabaseFiller(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
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
    }
}
