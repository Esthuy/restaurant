package be.technifutur.restaurant.business.services;

import be.technifutur.restaurant.models.dto.ReviewDTO;
import be.technifutur.restaurant.models.dto.UserDTO;
import be.technifutur.restaurant.models.forms.ReviewForm;
import be.technifutur.restaurant.models.forms.UserForm;

import java.util.List;

public interface ReviewService {

    // CREATE
    public ReviewDTO insert(ReviewForm form);

    // READ
    public ReviewDTO getOne(int id);
    public List<ReviewDTO> getAll();

    // UPDATE
    public ReviewDTO update(int id, ReviewForm form);


    // DELETE
    public ReviewDTO delete(int id);
}
