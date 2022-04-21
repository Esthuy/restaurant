package be.technifutur.restaurant.business.services.impl;

import be.technifutur.restaurant.business.mappers.UserMapper;
import be.technifutur.restaurant.business.services.UserService;
import be.technifutur.restaurant.exceptions.ElementNotFoundException;
import be.technifutur.restaurant.exceptions.MailAlreadyExistException;
import be.technifutur.restaurant.exceptions.UsernameAlreadyExistException;
import be.technifutur.restaurant.models.dto.RestaurantDTO;
import be.technifutur.restaurant.models.dto.UserDTO;
import be.technifutur.restaurant.models.entities.User;
import be.technifutur.restaurant.models.forms.UserForm;
import be.technifutur.restaurant.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserMapper mapper;
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserMapper mapper, UserRepository repository, PasswordEncoder encoder) {
        this.mapper = mapper;
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public UserDTO insert(UserForm form){
        if(!doesUsernameExist(form.getUsername())){
            if(!doesMailExist(form.getEmail())){
                User entity = mapper.formToEntity(form);
                entity.setNotLocked(true);
                entity.setPassword(encoder.encode(form.getPassword()));
                entity = repository.save(entity);

                return mapper.entityToDTO(entity);
            }else{
                throw new MailAlreadyExistException(RestaurantDTO.class);
            }
        }else {
            throw new UsernameAlreadyExistException(RestaurantDTO.class);
        }
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

    @Override
    public UserDTO getOneByUsername(String username) {
        return repository.findAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .map(mapper::entityToDTO).findAny().orElseThrow();
    }

    @Override
    public UserDTO update(int id, UserForm form) {
        User entity = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(id, RestaurantDTO.class));

        entity.setUsername(form.getUsername());
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

    @Override
    public boolean doesUsernameExist(String username) {
       List<User> list =  repository.findAll().stream()
                .filter(user -> user.getUsername().toLowerCase(Locale.ROOT).equals(username.toLowerCase(Locale.ROOT))).toList();

        return list.size() > 0;
    }

    @Override
    public boolean doesMailExist(String mail) {
        List<User> list =  repository.findAll().stream()
                .filter(user -> user.getEmail().toLowerCase(Locale.ROOT).equals(mail.toLowerCase(Locale.ROOT))).toList();

        return list.size() > 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));
    }
}
