import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHelper {
    public static void saveToFile(Pokedex pokedex){

        try (FileWriter writer = new FileWriter("pokedex.txt")) {

            for (Pokemon pokemon : pokedex.getPokemons()){

                writer.write("POKEMON|" + pokemon.getName() + "|" + pokemon.getType() + "|" + pokemon.getMaxHP() + "|" + pokemon.getCurrentHP() + "\n");

                for (Attack attack : pokemon.getAttacks()){

                    writer.write("ATTACK|" + attack.getName() + "|" + attack.getBaseDamage() + "|" + attack.getAccuracy() + "|" + attack.getType() + "\n");

                }
            }

        } catch (IOException e){
            System.out.println("Kunde inte spara Pokédexen!");
        }
    }
    public static boolean loadFromFile(Pokedex pokedex) {

        try (Scanner fileScanner = new Scanner(new File("pokedex.txt"))) {

            pokedex.clear();

            Pokemon currentPokemon = null;

            while (fileScanner.hasNextLine()) {

                String readFile = fileScanner.nextLine();

                if (readFile.isBlank()) {
                    continue;
                }

                String[] parts = readFile.split("\\|");

                if (parts[0].equals("POKEMON")) {

                    if (parts.length != 5) {
                        System.out.println("OBS! Ogiltig Pokémon-data i filen.");
                        continue;
                    }

                    String name = parts[1];
                    Type type = Type.valueOf(parts[2]);
                    int maxHP = Integer.parseInt(parts[3]);
                    int currentHP = Integer.parseInt(parts[4]);

                    Pokemon pokemon = new Pokemon(name, type, maxHP, currentHP);

                    pokedex.addPokemon(pokemon);
                    currentPokemon = pokemon;

                } else if (parts[0].equals("ATTACK")) {

                    if (currentPokemon == null) {
                        System.out.println("OBS! Attacken saknar en Pokémon.");
                        continue;
                    }

                    if (parts.length != 5) {
                        System.out.println("OBS! Ogiltig attack-data i filen.");
                        continue;
                    }

                    String name = parts[1];
                    int baseDamage = Integer.parseInt(parts[2]);
                    int accuracy = Integer.parseInt(parts[3]);
                    Type type = Type.valueOf(parts[4]);

                    Attack attack = new Attack(name, baseDamage, accuracy, type);

                    currentPokemon.addAttack(attack);
                }
            }
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("Ingen sparad Pokédex hittades.");
            return false;

        } catch (IllegalArgumentException e) {
            System.out.println("OBS! Den sparade filen innehåller ogiltig data.");
            return false;
        }
    }
}
