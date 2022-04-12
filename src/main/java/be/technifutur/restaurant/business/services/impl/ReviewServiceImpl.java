package be.technifutur.restaurant.business.services.impl;

import be.technifutur.restaurant.business.mappers.ReviewMapper;
import be.technifutur.restaurant.business.services.ReviewService;
import be.technifutur.restaurant.exceptions.ElementNotFoundException;
import be.technifutur.restaurant.models.dto.RestaurantDTO;
import be.technifutur.restaurant.models.dto.ReviewDTO;
import be.technifutur.restaurant.models.entities.Review;
import be.technifutur.restaurant.models.forms.ReviewForm;
import be.technifutur.restaurant.repositories.ReviewRepository;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper mapper;
    private final ReviewRepository repository;

    public ReviewServiceImpl(ReviewMapper mapper, ReviewRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public ReviewDTO insert(ReviewForm form) {
        Review entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public ReviewDTO getOne(int id) {
        return repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, RestaurantDTO.class));
    }

    @Override
    public List<ReviewDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public ReviewDTO update(int id, ReviewForm form) {
        Review entity = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(id, RestaurantDTO.class));

        entity.setId(form.getId());
        entity.setComment(form.getComment());
        entity.setStars(form.getStars());
        entity.setTitle(form.getTitle());
        entity.setRestaurant(form.getRestaurant());
        entity.setUser(form.getUser());

        entity = repository.save(entity);

        return mapper.entityToDTO(entity);
    }

    @Override
    public ReviewDTO delete(int id) {
        ReviewDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
}
