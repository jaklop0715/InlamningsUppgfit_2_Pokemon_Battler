import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Pokemon {
    //Ett namn, en typ, maxHp, nuvarande HP.
    private String name;
    private Type type;
    private int maxHP;
    private int currentHP;
    private int speed;
    private List<Attack> attacks;

    public Pokemon(String name, Type type, int maxHP, int currentHP, int speed) {

        if (speed <= 0){
            throw new IllegalArgumentException("OBS! Hastigheten måste vara större än 0!");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("OBS! Namnet får inte va tomt!");
        }

        if (type == null) {
            throw new IllegalArgumentException("Obs! Typen får inte vara tomt!");
        }

        if (maxHP <= 0) {
            throw new IllegalArgumentException("OBS! Max HP måste vara större än 0!");
        }

        if (currentHP < 0 || currentHP > maxHP) {
            throw new IllegalArgumentException("OBS! Aktuellt HP måste vara mellan 0 och max HP!");
        }

        this.name = name;
        this.type = type;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.speed =speed;
        this.attacks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("OBS! Namnet får inte vara tomt!");
        }
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {

        if (type == null) {
            throw new IllegalArgumentException("OBS! Typen får inte vara tom!");
        }
        this.type = type;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {

        if (maxHP <= 0) {
            throw new IllegalArgumentException("OBS! Max HP måste vara större än 0!");
        }
        if (maxHP < currentHP) {
            throw new IllegalArgumentException("OBS! Max HP får inte vara lägre än aktuellt HP!");
        }
        this.maxHP = maxHP;
    }


    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {

        if (currentHP < 0) {
            throw new IllegalArgumentException("OBS! Aktuellt HP får inte vara negativt!");
        }
        if (currentHP > maxHP) {
            throw new IllegalArgumentException("OBS! Aktuellt HP får inte vara större än MaxHP!");
        }
        this.currentHP = currentHP;
    }

    public int getSpeed() {
        return speed;
    }

    public List<Attack> getAttacks() {
        return Collections.unmodifiableList(attacks);
    }

    public void addAttack(Attack attack) {

        if (attack == null) {
            throw new IllegalArgumentException("OBS! Attack får inte vara tom!");
        }
        if (attacks.size() >= 4) {
            throw new IllegalArgumentException("OBS! En Pokémon får ha max 4 attacker!");
        }
        attacks.add(attack);
    }

    public void removeAttack(int index) {

        if (index < 0 || index >= attacks.size()) {
            throw new IllegalArgumentException("Obs! Du måste välja en attack som finns i listan!");
        }
        if (attacks.size() <= 1) {
            throw new IllegalArgumentException("OBS! En Pokémon måste ha minst en attack!");
        }
        attacks.remove(index);
    }

    @Override
    public String toString() {
        String text = "Name: " + name + ", Type: " + type + ", HP: " + currentHP + "/" + maxHP + ", Speed: " + speed;

        for (Attack attack : attacks) {
            text += "\n  - " + attack;
        }
        return text;
    }
}
