

public class SeedData {

    public static void seedPokedex(Pokedex pokedex) {

        Pokemon pikachu = new Pokemon("Pikachu", Type.ELECTRIC, 100, 100, 90);
        pikachu.addAttack(new Attack("Thunder Jolt", 40, 95, Type.ELECTRIC));
        pikachu.addAttack(new Attack("Spark Rush", 55, 85, Type.ELECTRIC));
        pokedex.addPokemon(pikachu);

        Pokemon emberon = new Pokemon("Emberon", Type.FIRE, 120, 120, 50);
        emberon.addAttack(new Attack("Flame Bite", 50, 90, Type.FIRE));
        emberon.addAttack(new Attack("Blaze Rush", 70, 80, Type.FIRE));
        pokedex.addPokemon(emberon);

        Pokemon mossfang = new Pokemon("Mossfang", Type.GRASS, 110, 110, 60);
        mossfang.addAttack(new Attack("Leaf Slash", 45, 95, Type.GRASS));
        mossfang.addAttack(new Attack("Vine Crash", 65, 80, Type.GRASS));
        pokedex.addPokemon(mossfang);

        Pokemon voltclaw = new Pokemon("Voltclaw", Type.ELECTRIC, 95, 95, 100);
        voltclaw.addAttack(new Attack("Static Claw", 40, 100, Type.ELECTRIC));
        voltclaw.addAttack(new Attack("Thunder Fang", 75, 75, Type.ELECTRIC));
        pokedex.addPokemon(voltclaw);

        Pokemon aquaphin = new Pokemon("Aquaphin", Type.WATER, 130, 130,75);
        aquaphin.addAttack(new Attack("Bubble Shot", 35, 100, Type.WATER));
        aquaphin.addAttack(new Attack("Tidal Crash", 80, 75, Type.WATER));
        pokedex.addPokemon(aquaphin);

        Pokemon jakCat = new Pokemon("Jakcat", Type.WATER, 120, 120, 95);
        jakCat.addAttack(new Attack("Meow Meow", 35, 95, Type.WATER));
        jakCat.addAttack(new Attack("Purr", 90, 75, Type.WATER));
        pokedex.addPokemon(jakCat);
    }
}