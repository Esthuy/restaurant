package be.technifutur.restaurant.business.services;

import be.technifutur.restaurant.models.dto.RestaurantDTO;
import be.technifutur.restaurant.models.forms.RestaurantForm;

import java.util.List;

public interface RestaurantService {

    // CREATE
    public RestaurantDTO insert(RestaurantForm form);

    // READ
    public RestaurantDTO getOne(int id);
    public List<RestaurantDTO> getAll();
    public List<RestaurantDTO> getByName(String name);
    public List<RestaurantDTO> getByAddress(String address);
    public List<RestaurantDTO> getByTypeOfFood(String typeOfFood);
    public int getStarAverage(int id);

    // UPDATE
    public RestaurantDTO update(int id, RestaurantForm form);


    // DELETE
    public RestaurantDTO delete(int id);
}
