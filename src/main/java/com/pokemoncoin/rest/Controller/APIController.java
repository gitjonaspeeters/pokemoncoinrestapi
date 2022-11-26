package com.pokemoncoin.rest.Controller;

import com.pokemoncoin.rest.Model.pokemoncoin;
import com.pokemoncoin.rest.Repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIController {

    @Autowired
    private Repo repo;

    @GetMapping("/")
    public String getPage(){
        return "Welcome to the pokemon coin page.<br><br>" +
                "To get a list of all coins, go to /coins <br>" +
                "To get a random coin, go to /randomCoin <br>" +
                "To get a coin by id, go to /coins/{id} <br>" +
                "To add a coin, go to /new <br>" +
                "To delete a coin, go to /delete/{id} <br>" +
                "To update a coin, go to /update/{id} <br>";
    }

    @GetMapping("/coins")
    public List<pokemoncoin> getCoins(){
        return repo.findAll();
    }

    @GetMapping("/randomCoin")
    public pokemoncoin getRandomCoin(){
        List<pokemoncoin> coins = repo.findAll();
        int random = (int) (Math.random() * coins.size());
        return coins.get(random);
    }

    @GetMapping("/coins/{id}")
    public pokemoncoin getCoinById(@PathVariable Long id) {
        return repo.findById(id).get();
    }

    @PostMapping("/new")
    public pokemoncoin addCoin(@RequestBody pokemoncoin coin){
        return repo.save(coin);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCoin(@PathVariable Long id){
        repo.deleteById(id);
        return "Coin deleted";
    }

    @PutMapping("/update/{id}")
    public pokemoncoin updateCoin(@PathVariable Long id, @RequestBody pokemoncoin coin){
        pokemoncoin coinToUpdate = repo.findById(id).get();
        coinToUpdate.setName(coin.getName());
        coinToUpdate.setColor(coin.getColor());
        coinToUpdate.setPack(coin.getPack());
        coinToUpdate.setYear(coin.getYear());
        coinToUpdate.setRarity(coin.getRarity());
        return repo.save(coinToUpdate);
    }











}
