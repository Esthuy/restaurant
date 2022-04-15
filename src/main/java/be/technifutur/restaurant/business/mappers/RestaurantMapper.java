package be.technifutur.restaurant.business.mappers;

import be.technifutur.restaurant.models.dto.RestaurantDTO;
import be.technifutur.restaurant.models.entities.Restaurant;
import be.technifutur.restaurant.models.entities.Review;
import be.technifutur.restaurant.models.entities.User;
import be.technifutur.restaurant.models.forms.RestaurantForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantMapper {

    public RestaurantDTO entityToDTO(Restaurant entity){

        if (entity == null)
            return null;

        List<User> favoriteOf = entity.getFavoriteOf();
        List<RestaurantDTO.UserDTO> favoriteOfDto =
                favoriteOf == null ? null :
                        favoriteOf.stream().map((user -> new RestaurantDTO.UserDTO(user.getId(), user.getUsername()))).toList();


        List<Review> reviews = entity.getReviews();
        List<RestaurantDTO.ReviewDTO> reviewDTOS =
                reviews == null ? null :
                        reviews.stream().map(review -> new RestaurantDTO.ReviewDTO(review.getId(), review.getTitle(), review.getComment(), review.getStars(),
                                new RestaurantDTO.UserDTO(review.getUser().getId(), review.getUser().getUsername()))).toList();

        return RestaurantDTO.builder()
                .id(entity.getId())
                .address(entity.getAddress())
                .description(entity.getDescription())
                .name(entity.getName())
                .typeOfFood(entity.getTypeOfFood())
                .phoneNumber(entity.getPhoneNumber())
                .favoriteOf(favoriteOfDto)
                .reviews(reviewDTOS)
                .build();
    }

    public Restaurant formToEntity(RestaurantForm form){
        if(form == null){
            return null;
        }

        return Restaurant.builder()
                .name(form.getName())
                .address(form.getAddress())
                .description(form.getDescription())
                .phoneNumber(form.getPhoneNumber())
                .typeOfFood(form.getTypeOfFood())
                .id(form.getId())
                .favoriteOf(form.getFavoriteOf())
                .reviews(form.getReviews())
                .build();
    }
}
