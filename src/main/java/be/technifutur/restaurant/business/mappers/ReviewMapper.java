package be.technifutur.restaurant.business.mappers;

import be.technifutur.restaurant.models.dto.ReviewDTO;
import be.technifutur.restaurant.models.entities.Restaurant;
import be.technifutur.restaurant.models.entities.Review;
import be.technifutur.restaurant.models.entities.User;
import be.technifutur.restaurant.models.forms.RestaurantForm;
import be.technifutur.restaurant.models.forms.ReviewForm;
import be.technifutur.restaurant.models.forms.UserForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewMapper {

    public ReviewDTO entityToDTO(Review entity){

        if (entity == null)
            return null;

        User user = entity.getUser();
        ReviewDTO.UserDTO userDTO =
                user == null ? null :
                        new ReviewDTO.UserDTO(user.getId(), user.getName());


        Restaurant restaurant = entity.getRestaurant();
        ReviewDTO.RestaurantDTO restaurantDTO =
                restaurant == null ? null :
                        new ReviewDTO.RestaurantDTO(restaurant.getId(), restaurant.getName());

        return ReviewDTO.builder()
                .id(entity.getId())
                .comment(entity.getComment())
                .stars(entity.getStars())
                .title(entity.getTitle())
                .restaurant(restaurantDTO)
                .user(userDTO)
                .build();
    }

    public Review formToEntity(ReviewForm form){
        if(form == null){
            return null;
        }

        return Review.builder()
                .id(form.getId())
                .comment(form.getComment())
                .stars(form.getStars())
                .title(form.getTitle())
                .restaurant(form.getRestaurant())
                .user(form.getUser())
                .build();
    }
}
