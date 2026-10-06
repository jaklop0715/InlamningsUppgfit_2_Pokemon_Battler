

public class Attack {

    private String name;
    private int baseDamage;
    private int accuracy;
    private Type type;

    public Attack(String name, int baseDamage, int accuracy, Type type) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("OBS! Attackens namn får inte vara tomt!");
        }

        if (baseDamage < 1 || baseDamage > 100) {
            throw new IllegalArgumentException("OBS! Det måste vara en siffra mellan 1 och 100!");
        }
        if (accuracy < 1 || accuracy > 100) {
            throw new IllegalArgumentException("OBS! Det måste vara en siffra mellan 1 och 100!");
        }
        if (type == null) {
            throw new IllegalArgumentException("OBS! välj en befintlig attack!");
        }
        this.name = name;
        this.baseDamage = baseDamage;
        this.accuracy = accuracy;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("OBS! Name får inte lämnas tom!");
        }
        this.name = name;
    }


    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {

        if (baseDamage < 1 || baseDamage > 100) {
            throw new IllegalArgumentException("OBS! Du har valt ett ogiltigt nummer!");
        }
        this.baseDamage = baseDamage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {

        if (accuracy < 1 || accuracy > 100) {
            throw new IllegalArgumentException("OBS! Du har valt ett ogiltigt nummer!");
        }
        this.accuracy = accuracy;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        if (type == null){
            throw new IllegalArgumentException("OBS! Du måste välja en typ!");
        }
        this.type = type;
    }

    @Override
    public String toString() {
        return name + "(Skada: " + baseDamage + ",Träffsäkerhet: " + accuracy + ", Typ: " + type + ")";
    }
}
