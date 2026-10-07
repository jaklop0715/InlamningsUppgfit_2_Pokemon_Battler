

public class Main {
    public static void main(String[] args) {


        //Alla Pokémon som användaren skapar
        Pokedex pokedex = new Pokedex();
        FileHelper.loadFromFile(pokedex);

        if (pokedex.isEmpty()) {
            SeedData.seedPokedex(pokedex);
        }


        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("========================");
            System.out.println("        POKÉDEX         ");
            System.out.println("========================");
            System.out.println("1. Visa alla dina Pokémon ");
            System.out.println("2. Skapa en ny Pokémon");
            System.out.println("3. Redigera Pokémon");
            System.out.println("4. Ta bort Pokémon");
            System.out.println("5. Spara till fil");
            System.out.println("6. Ladda från fil");
            System.out.println("7. Återställ till seedad data");
            System.out.println("8. Avsluta");

            System.out.println("Gör ett val i menyn");
            String choice = InputHelper.readNonBlankString();

            switch (choice) {

                case "1" -> {
                    System.out.println("Du valde att visa alla dina Pokémon");

                    if (pokedex.isEmpty()) {
                        System.out.println("Din Pokédex är tom!");
                    } else {
                        for (Pokemon pokemon : pokedex.getPokemons()) {
                            System.out.println(pokemon);
                        }
                    }
                }
                case "2" -> {
                    System.out.println("Du valde att skapa en Pokémon");

                    Pokemon pokemon = createPokemon();
                    pokedex.addPokemon(pokemon);

                    System.out.println(pokemon.getName() + " har nu lagts till i din Pokédex!");
                }
                case "3" -> {
                    editPokemon(pokedex);
                }
                case "4" -> {
                    removePokemon(pokedex);
                }
                case "5" -> {
                    FileHelper.saveToFile(pokedex);
                    System.out.println("Pokédexen har sparats!");
                }
                case "6" -> {
                    if (FileHelper.loadFromFile(pokedex)) {
                        System.out.println("Pokédexen har laddats!");
                    }
                }

                case "7" -> {
                    pokedex.clear();
                    SeedData.seedPokedex(pokedex);
                    System.out.println("Pokédex har återställts till seedad data!");
                }

                case "8" -> {
                    FileHelper.saveToFile(pokedex);
                    running = false;
                }
                default -> System.out.println("OBS! du gjorde ett ogiltigt val. Välj mellan 1 och 8");

            }
        }
        System.out.println("Syns snart igen! Pickaout");
    }

    private static Pokemon createPokemon() {

        System.out.println("Vad ska din Pokémon heta?");
        String name = InputHelper.readNonBlankString();

        System.out.println("Vilken typ ska din Pokémon ha?");
        Type type = InputHelper.readType();

        System.out.println("Vad är Pokémons Max HP?");
        int maxHP = InputHelper.readPositiveInt();

        System.out.println("Vad är Pokémons aktuella HP?");
        int currentHP = InputHelper.readIntInRange(0, maxHP);

        System.out.println("Vad är Pokémons hastighet? (1-100)");
        int speed = InputHelper.readIntInRange(1, 100);

        Pokemon pokemon = new Pokemon(name, type, maxHP, currentHP, speed);

        System.out.println("Hur många attacker vill du lägga till? (1-4)");

        int antalAttacker = InputHelper.readIntInRange(1, 4);

        for (int i = 0; i < antalAttacker; i++) {

            System.out.println();
            System.out.println("Attack " + (i + 1));

            Attack attack = InputHelper.readAttack();

            pokemon.addAttack(attack);
        }
        return pokemon;
    }

    private static void removePokemon(Pokedex pokedex) {

        if (pokedex.isEmpty()) {
            System.out.println("Din Pokédex är tom!");
            return;
        }

        for (int i = 0; i < pokedex.getPokemons().size(); i++) {
            System.out.println((i + 1) + ". " + pokedex.getPokemons().get(i).getName());
        }

        System.out.println("Vilken Pokémon vill du ta bort? ");

        int choice = InputHelper.readIntInRange(1, pokedex.getPokemons().size());

        String removedName = pokedex.getPokemons().get(choice - 1).getName();

        pokedex.removePokemon(choice - 1);

        System.out.println(removedName + " har tagits bort! ");
    }

    private static void editPokemon(Pokedex pokedex) {

        if (pokedex.isEmpty()) {
            System.out.println("Du har ingen Pokémon att uppdatera!");
            return;
        }
        for (int i = 0; i < pokedex.getPokemons().size(); i++) {
            System.out.println((i + 1) + "." + pokedex.getPokemons().get(i).getName());
        }
        System.out.println("Vilken Pokémon önskas redigera?");

        int choice = InputHelper.readIntInRange(1, pokedex.getPokemons().size());

        Pokemon pokemon = pokedex.getPokemons().get(choice - 1);

        System.out.println("Vad önskar du redigera?");
        System.out.println("1.Namn");
        System.out.println("2.HP");
        System.out.println("3.Typ");
        System.out.println("4.Attacker");

        int editChoice = InputHelper.readIntInRange(1, 4);

        switch (editChoice) {

            case 1 -> {
                System.out.println("Vad är de nya namnet? ");

                String newName = InputHelper.readNonBlankString();

                pokemon.setName(newName);

                System.out.println("Pokémon har redigerats!");
            }

            case 2 -> {

                System.out.println("Vad ska Pokémonens nya Max HP vara?");
                int inputHP = InputHelper.readPositiveInt();

                try {
                    pokemon.setMaxHP(inputHP);

                    System.out.println("Vad ska Pokémonens nya aktuella HP vara?");
                    int inputCurrentHp = InputHelper.readIntInRange(0, inputHP);

                    pokemon.setCurrentHP(inputCurrentHp);

                    System.out.println("Pokémons HP har nu uppdaterats!");

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            case 3 -> {
                System.out.println("Vilken är den nya typen?");

                Type newType = InputHelper.readType();

                pokemon.setType(newType);

                System.out.println("Pokémons typ är nu " + newType + "!");
            }

            case 4 -> {
                System.out.println("Vad önskar du göra med attackerna?");
                System.out.println("1. Lägg till attack");
                System.out.println("2. Ta bort attack");

                int attackChoice = InputHelper.readIntInRange(1, 2);

                switch (attackChoice) {
                    case 1 -> {

                        Attack attack = InputHelper.readAttack();

                        try {
                            pokemon.addAttack(attack);
                            System.out.println("Attacken har lagts till!");

                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 2 -> {

                        if (pokemon.getAttacks().size() <= 1) {
                            System.out.println("OBS! En Pokémon måste ha minst en attack!");

                        } else {
                            System.out.println("Vilken attack vill du ta bort?");

                            for (int i = 0; i < pokemon.getAttacks().size(); i++) {
                                System.out.println((i + 1) + ". " + pokemon.getAttacks().get(i).getName());
                            }

                            int attackToRemove = InputHelper.readIntInRange(1, pokemon.getAttacks().size());

                            pokemon.removeAttack(attackToRemove - 1);

                            System.out.println("Attacken har nu tagits bort!");
                        }
                    }
                }
            }
        }
    }
}
