package be.technifutur.restaurant.business.services;


import be.technifutur.restaurant.models.dto.UserDTO;
import be.technifutur.restaurant.models.forms.UserForm;

import java.util.List;

public interface UserService {

    // CREATE
    public UserDTO insert(UserForm form);

    // READ
    public UserDTO getOne(int id);
    public List<UserDTO> getAll();
    public UserDTO getOneByUsername(String username);

    // UPDATE
    public UserDTO update(int id, UserForm form);


    // DELETE
    public UserDTO delete(int id);


    public boolean doesUsernameExist(String username);
    public boolean doesMailExist(String mail);


}
