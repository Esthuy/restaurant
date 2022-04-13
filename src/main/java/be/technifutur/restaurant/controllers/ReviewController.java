package be.technifutur.restaurant.controllers;

import be.technifutur.restaurant.business.services.ReviewService;
import be.technifutur.restaurant.models.dto.ReviewDTO;
import be.technifutur.restaurant.models.forms.ReviewForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }


    // GET - http://localhost:8080/review
    @GetMapping
    public List<ReviewDTO> getAll(){
        return service.getAll();
    }


    // GET - http://localhost:8080/review/id
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getOne (@PathVariable int id){
        return ResponseEntity.ok(service.getOne(id));
    }


    // DELETE -  http://localhost:8080/review/id
    @DeleteMapping("/{id}")
    public ResponseEntity<ReviewDTO> delete(@PathVariable int id){
        return ResponseEntity.ok(service.delete(id));
    }


    // POST -http://localhost:8080/review/add
    @PostMapping("/add")
    public ResponseEntity<ReviewDTO> insert( @RequestBody ReviewForm form){
        return ResponseEntity.ok(service.insert(form)) ;
    }


    // PUT - http://localhost:8080/review/id
    @PutMapping("/{id}")
    public ResponseEntity<ReviewDTO> update (@PathVariable int id, @RequestBody ReviewForm form) {
        return ResponseEntity.ok(service.update(id, form));
    }

}
