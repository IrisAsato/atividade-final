package br.com.infnet;

import br.com.infnet.exception.ResourceNotFoundException;
import br.com.infnet.model.Pokemon;
import br.com.infnet.util.PokemonUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class PokemonTests {
    @Test
    @DisplayName("Deve retornar um pokemon pelo Nome")
    public void testaPokemonPeloNome(){
        PokemonUtil pokemonUtil = new PokemonUtil();
        Pokemon pokemon = pokemonUtil.getByName('bulbasaur');
        assertEquals('bulbasaur', pokemon.getName());
        assertEquals(1, pokemon.getId());
    }
    @Test
    @DisplayName("Deve retornar uma exception para um pokemon Inexistente")
    public void testaPokemonInexistente(){
        PokemonUtil pokemonUtil = new PokemonUtil();
        assertThrows(ResourceNotFoundException.class, () ->{
            pokemonUtil.getByName('pokemon_inexistente');
        });
    }
}