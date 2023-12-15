package br.com.infnet.controllers;

import br.com.infnet.model.MestrePokemon;
import br.com.infnet.service.MestrePokemonService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/mestre-pokemon")
public class MestrePokemonController {
    @Autowired
    MestrePokemonService mestrePokemonService;

    Logger logger = LoggerFactory.getLogger(MestrePokemonController.class);
    List<MestrePokemon> mestrePokemons = initMestrePokemons();
    private List<MestrePokemon> initMestrePokemons() {
        logger.info("GET ALL MESTRES POKEMONS");
        MestrePokemon cynthia = new MestrePokemon(0L, "Cynthia");
        MestrePokemon iris = new MestrePokemon(1L, "Iris");
        MestrePokemon diantha = new MestrePokemon(2L, "Diantha");
        ArrayList<MestrePokemon> mestrePokemons = new ArrayList<>();
        mestrePokemons.add(cynthia);
        mestrePokemons.add(iris);
        mestrePokemons.add(diantha);
        return mestrePokemons;
    }

    @GetMapping
    public List<MestrePokemon> getAll(){
        logger.info("GET ALL MESTRES POKEMONS");
        return mestrePokemonService.getAll();
    }
    @GetMapping("/{id}")
    public MestrePokemon getById(@PathVariable int id){
        logger.info("GET MESTRE POKEMON: " + id);
        return mestrePokemonService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody MestrePokemon mestrePokemon){
        logger.info("CREATE MESTRE POKEMON: " + mestrePokemon);
        mestrePokemonService.save(mestrePokemon);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        logger.info("DELETE MESTRE POKEMON" + id);
        MestrePokemon removed = mestrePokemonService.delete(id);
        logger.info("MESTRE POKEMON DELETADO: " + removed);

    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody  MestrePokemon mestrePokemon){
        logger.info("UPDATE MESTRE POKEMON: " + id + " novo mestre pokemon: " + mestrePokemon );
        mestrePokemonService.update(id, mestrePokemon);
    }

}