package be.technifutur.restaurant.controllers;

import be.technifutur.restaurant.business.services.RestaurantService;
import be.technifutur.restaurant.models.dto.RestaurantDTO;
import be.technifutur.restaurant.models.forms.RestaurantForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService service;


    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/restaurant
    @GetMapping
    public List<RestaurantDTO> getAll(){
        return service.getAll();
    }


    // GET - http://localhost:8080/restaurant/id
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> getOne (@PathVariable int id){
        RestaurantDTO restaurantDTO = service.getOne(id);
        return ResponseEntity.ok(restaurantDTO);
    }

    // GET - http://localhost:8080/restaurant/searchByName/name
    @GetMapping("/searchByName/{name}")
    public List<RestaurantDTO> getByName (@PathVariable String name){
        return service.getByName(name);
    }

    // GET - http://localhost:8080/restaurant/searchByAddress/address
    @GetMapping("/searchByAddress/{address}")
    public List<RestaurantDTO> getByAddress (@PathVariable String address){
        return service.getByAddress(address);
    }

    // GET - http://localhost:8080/restaurant/searchByName/address
    @GetMapping("/searchByTypeOfFood/{typeOfFood}")
    public List<RestaurantDTO> getByTypeOfFood (@PathVariable String typeOfFood){
        return service.getByTypeOfFood(typeOfFood);
    }

    // GET - http://localhost:8080/restaurant/stars/id
    @GetMapping("/stars/{id}")
    public int getStarAverage(@PathVariable int id){
        return service.getStarAverage(id);
    }



    // DELETE -  http://localhost:8080/restaurant/id
    @DeleteMapping("/{id}")
    public ResponseEntity<RestaurantDTO> delete(@PathVariable int id){
        return ResponseEntity.ok(service.delete(id));
    }


    // POST -http://localhost:8080/restaurant/add
    @PostMapping("/add")
    public ResponseEntity<RestaurantDTO> insert( @RequestBody RestaurantForm form){
        return ResponseEntity.ok( service.insert(form)) ;
    }


    // PUT - http://localhost:8080/restaurant/id
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDTO> update (@PathVariable int id, @RequestBody RestaurantForm form) {
        return ResponseEntity.ok(service.update(id, form));
    }

}
