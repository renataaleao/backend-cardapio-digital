package br.com.cardapio.controller;

import br.com.cardapio.food.Food;
import br.com.cardapio.food.FoodRepository;
import br.com.cardapio.food.FoodRequestDTO;
import br.com.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowCredentials = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
    }

    @CrossOrigin(origins = "*", allowCredentials = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll() {

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
