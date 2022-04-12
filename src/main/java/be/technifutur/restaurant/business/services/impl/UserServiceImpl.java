package be.technifutur.restaurant.business.services.impl;

import be.technifutur.restaurant.business.mappers.UserMapper;
import be.technifutur.restaurant.business.services.UserService;
import be.technifutur.restaurant.models.dto.UserDTO;
import be.technifutur.restaurant.models.forms.UserForm;
import be.technifutur.restaurant.repositories.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserRepository repository;

    public UserServiceImpl(UserMapper mapper, UserRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public UserDTO insert(UserForm form) {
        return null;
    }

    @Override
    public UserDTO getOne(int id) {
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public UserDTO update(int id, UserForm form) {
        return null;
    }

    @Override
    public UserDTO delete(int id) {
        return null;
    }
}
