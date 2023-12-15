package br.com.infnet;

import br.com.infnet.exception.ResourceNotFoundException;
import br.com.infnet.model.Item;
import br.com.infnet.model.Pokemon;
import br.com.infnet.service.MestrePokemonService;
import br.com.infnet.util.PokemonUtil;
import br.com.infnet.util.ItemUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class App 
{
    Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {

        logger.info( "Seja Vem vindo a API de RICK N MORTY" );
        Scanner scanner = new Scanner(System.in);
        logger.info("Digite a opcao desejada");
        logger.info("1 - Buscar Item pelo ID");
        logger.info("2 - Buscar Pokemon pelo Nome");
        int opcaoUsuario = scanner.nextInt();
        ItemUtil itemUtil = new ItemUtil();

        PokemonUtil pokemonUtil = new PokemonUtil();
        switch (opcaoUsuario){
            case 1: {
                logger.info("Digite o ID do item");
                int itemId = scanner.nextInt();
                try{
                    Item item = itemUtil.getById(itemId);
                    logger.info("Nome do Item: " +  item.getName());
                    logger.info("Custo do Item: " + item.getCost());
                }catch (ResourceNotFoundException ex){
                    logger.error(ex.getMessage());
                }
                break;
            }
            case 2: {
                logger.info("Digite o nome do Pokemon");
                String pokemonName = scanner.next();
                Pokemon pokemon = pokemonUtil.getByName(pokemonName);
                try{
                    logger.info("Numero na Pokedex: " + pokemon.getId());
                    logger.info("Nome: " + pokemon.getName());
                    logger.info("Peso: " + pokemon.getWeight() + " Hectogramas");
                    logger.info("Altura: " + pokemon.getHeight() + " Decímetros");
                }catch (ResourceNotFoundException ex){
                    logger.error(ex.getMessage());
                }
                break;
            }
        }

        SpringApplication.run(App.class, args);
    }
}
