package be.technifutur.restaurant.business.services.impl;

import be.technifutur.restaurant.business.mappers.UserMapper;
import be.technifutur.restaurant.business.services.UserService;
import be.technifutur.restaurant.exceptions.ElementNotFoundException;
import be.technifutur.restaurant.models.dto.RestaurantDTO;
import be.technifutur.restaurant.models.dto.UserDTO;
import be.technifutur.restaurant.models.entities.User;
import be.technifutur.restaurant.models.forms.UserForm;
import be.technifutur.restaurant.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserRepository repository;

    public UserServiceImpl(UserMapper mapper, UserRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public UserDTO insert(UserForm form) {
        User entity = mapper.formToEntity(form);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public UserDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, RestaurantDTO.class));
    }

    @Override
    public List<UserDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDTO)
                .toList();
    }

//    @Override
//    public UserDTO getOneByMail(String mail) {
//         User usr = repository.findAll().stream()
//                .filter(user -> user.getEmail().equals(mail)).findFirst().orElseThrow();
//
//         return mapper.entityToDTO(usr);
//    }

    @Override
    public UserDTO update(int id, UserForm form) {
        User entity = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(id, RestaurantDTO.class));

        entity.setName(form.getName());
        entity.setBirthdate(form.getBirthdate());
        entity.setEmail(form.getEmail());
        entity.setFavorites(form.getFavorites());
        entity.setReviews(form.getReviews());
        entity.setId(form.getId());

        entity = repository.save(entity);

        return mapper.entityToDTO(entity);
    }

    @Override
    public UserDTO delete(int id) {
        UserDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
}
