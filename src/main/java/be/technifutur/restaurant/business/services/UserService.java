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
//    public UserDTO getOneByMail(String mail);

    // UPDATE
    public UserDTO update(int id, UserForm form);


    // DELETE
    public UserDTO delete(int id);


}
