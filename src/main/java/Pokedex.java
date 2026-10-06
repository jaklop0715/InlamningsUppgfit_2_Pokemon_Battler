
import java.util.ArrayList;
import java.util.List;


public class Pokedex {

    private List<Pokemon> pokemons;

    public Pokedex() {
        pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }
    public boolean isEmpty(){
        return pokemons.isEmpty();
    }

    public List<Pokemon> getPokemons() {
        return List.copyOf(pokemons);
    }
    public void removePokemon(int index){
        pokemons.remove(index);
    }
    public void clear() {
        pokemons.clear();
    }
}
