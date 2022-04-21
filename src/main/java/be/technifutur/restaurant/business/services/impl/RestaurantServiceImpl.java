package be.technifutur.restaurant.business.services.impl;

import be.technifutur.restaurant.business.mappers.RestaurantMapper;
import be.technifutur.restaurant.business.services.RestaurantService;
import be.technifutur.restaurant.exceptions.ElementNotFoundException;
import be.technifutur.restaurant.models.dto.RestaurantDTO;
import be.technifutur.restaurant.models.dto.ReviewDTO;
import be.technifutur.restaurant.models.entities.Restaurant;
import be.technifutur.restaurant.models.forms.RestaurantForm;
import be.technifutur.restaurant.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantMapper mapper;
    private final RestaurantRepository repository;

    public RestaurantServiceImpl(RestaurantMapper mapper, RestaurantRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public RestaurantDTO insert(RestaurantForm form) {
        Restaurant entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public RestaurantDTO getOne(int id) {
        return repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, RestaurantDTO.class));
    }

    @Override
    public List<RestaurantDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public List<RestaurantDTO> getByName(String name) {
        return repository.findAll().stream()
                .filter(restaurant -> restaurant.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)))
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public List<RestaurantDTO> getByAddress(String address) {
        return repository.findAll().stream()
                .filter(restaurant -> restaurant.getAddress().toLowerCase(Locale.ROOT).contains(address.toLowerCase(Locale.ROOT)))
                .map(mapper::entityToDTO)
                .toList();
    }


    @Override
    public List<RestaurantDTO> getByTypeOfFood(String typeOfFood) {
        return repository.findAll().stream()
                .filter(restaurant -> restaurant.getTypeOfFood().toLowerCase(Locale.ROOT).contains(typeOfFood.toLowerCase(Locale.ROOT)))
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public int getStarAverage(int id) {
        int total = 0;

        List<RestaurantDTO.ReviewDTO> reviews  = getOne(id).getReviews();
        if(reviews.size() > 0) {
            total += reviews.stream().mapToInt(RestaurantDTO.ReviewDTO::getStars).sum();
            return total / reviews.size();
        } else{
            return -1;
        }
    }


    @Override
    public RestaurantDTO update(int id, RestaurantForm form) {
        Restaurant entity = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(id, RestaurantDTO.class));

        entity.setName(form.getName());
        entity.setAddress(form.getAddress());
        entity.setDescription(form.getDescription());
        entity.setPhoneNumber(form.getPhoneNumber());
        entity.setFavoriteOf(form.getFavoriteOf());
        entity.setReviews(form.getReviews());
        entity.setTypeOfFood(form.getTypeOfFood());

        entity = repository.save(entity);

        return mapper.entityToDTO(entity);
    }

    @Override
    public RestaurantDTO delete(int id) {
        RestaurantDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
}
