package be.technifutur.restaurant.controllers;

import be.technifutur.restaurant.business.services.UserService;
import be.technifutur.restaurant.models.dto.ReviewDTO;
import be.technifutur.restaurant.models.dto.UserDTO;
import be.technifutur.restaurant.models.forms.ReviewForm;
import be.technifutur.restaurant.models.forms.UserForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    // GET - http://localhost:8080/user
    @GetMapping
    public List<UserDTO> getAll(){
        return service.getAll();
    }


    // GET - http://localhost:8080/user/id
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getOne (@PathVariable int id){
        return ResponseEntity.ok(service.getOne(id));
    }


    // DELETE -  http://localhost:8080/user/id
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable int id){
        return ResponseEntity.ok(service.delete(id));
    }


    // POST -http://localhost:8080/user/add
    @PostMapping("/add")
    public ResponseEntity<UserDTO> insert( @RequestBody UserForm form){
        return ResponseEntity.ok(  service.insert(form)) ;
    }


    // PUT - http://localhost:8080/user/id
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update (@PathVariable int id, @RequestBody UserForm form) {
        return ResponseEntity.ok(service.update(id, form));
    }
}
