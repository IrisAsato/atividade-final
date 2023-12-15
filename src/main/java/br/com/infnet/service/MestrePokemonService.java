package br.com.infnet.service;

import br.com.infnet.model.MestrePokemon;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class MestrePokemonService {
    Logger logger = LoggerFactory.getLogger(MestrePokemonService.class);
    List<MestrePokemon> mestresPokemons = initMestrePokemons();
    private List<MestrePokemon> initMestrePokemons() {
        logger.info("GET ALL MESTRES POKEMONS");
        MestrePokemon cynthia = new MestrePokemon(0L, "Cynthia");
        MestrePokemon iris = new MestrePokemon(1L, "Iris");
        MestrePokemon diantha = new MestrePokemon(2L, "Dyantha");
        ArrayList<MestrePokemon> mestresPokemons = new ArrayList<>();
        mestresPokemons.add(cynthia);
        mestresPokemons.add(iris);
        mestresPokemons.add(diantha);
        return mestresPokemons;
    }
    public List<MestrePokemon> getAll(){
        return mestresPokemons;
    }
    public MestrePokemon getById(int id){
        return mestresPokemons.get(id);
    }
    public void save(MestrePokemon mestresPokemons){
        mestresPokemons.add(mestresPokemons);
    }
    public MestrePokemon delete(int id){
        return mestresPokemons.remove(id);
    }
    public void update(int id, MestrePokemon mestresPokemons){
        mestresPokemons.remove(id);
        mestresPokemons.setId((long)id);
        mestresPokemons.add(id,mestresPokemons);
    }
}