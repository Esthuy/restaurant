package be.technifutur.restaurant.business.mappers;

import be.technifutur.restaurant.models.dto.UserDTO;
import be.technifutur.restaurant.models.entities.Restaurant;
import be.technifutur.restaurant.models.entities.Review;
import be.technifutur.restaurant.models.entities.User;
import be.technifutur.restaurant.models.forms.UserForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapper {

    public UserDTO entityToDTO(User entity){
        if (entity == null)
            return null;

        List<Restaurant> favorites = entity.getFavorites();
        List<UserDTO.RestaurantDTO> favoritesDTO =
                favorites == null ? null :
                        favorites.stream().map((restaurant -> new UserDTO.RestaurantDTO(restaurant.getId(), restaurant.getName()))).toList();

        List<Review> reviews = entity.getReviews();
        List<UserDTO.ReviewDTO> reviewsDTO =
                reviews == null ? null :
                        reviews.stream().map((review -> new UserDTO.ReviewDTO(review.getId(), review.getTitle(), review.getComment(), review.getStars()))).toList();

        return UserDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .birthdate(entity.getBirthdate())
                .email(entity.getEmail())
                .favorites(favoritesDTO)
                .reviews(reviewsDTO)
                .password(entity.getPassword())
                .build();
    }

    public User formToEntity(UserForm form){
        if(form == null){
            return null;
        }

        return User.builder()
                .name(form.getName())
                .birthdate(form.getBirthdate())
                .id(form.getId())
                .email(form.getEmail())
                .favorites(form.getFavorites())
                .reviews(form.getReviews())
                .password(form.getPassword())
                .build();
    }
}
