import java.util.Scanner;

public class InputHelper {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt () {

        while (true) {
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);

            }catch (NumberFormatException e){
                System.out.println("OBS! Du måste ange en siffra!");
            }
        }
    }

    public static int readIntInRange (int min, int max) {

        while (true) {

            int value = readInt();

            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("OBS! Du måste ange ett nummer mellan " + min + " och " + max + "!");
        }
    }
    public static int readPositiveInt() {

        while (true) {

            int value = readInt();

            if (value > 0){
                return value;
            }
            System.out.println("OBS! Du måste ange ett nummer större än 0!");
        }
    }
    public static Type readType() {

        System.out.println("1. FIRE");
        System.out.println("2. WATER");
        System.out.println("3. GRASS");
        System.out.println("4. ELECTRIC");
        System.out.println("5. NORMAL");

        int choice = readIntInRange(1, 5);

        return switch (choice) {
            case 1 -> Type.FIRE;
            case 2 -> Type.WATER;
            case 3 -> Type.GRASS;
            case 4 -> Type.ELECTRIC;
            case 5 -> Type.NORMAL;
            default -> throw new IllegalStateException();
        };
    }
    public static String readNonBlankString() {

        while (true) {

            String input = scanner.nextLine();

            if (input.isBlank()) {

                System.out.println("OBS! Fältet får inte vara tomt!");
            } else if (input.contains("|")) {
                System.out.println("OBS! Fältet får inte vara tomt!");
            } else {
                return input;
            }
        }
    }
    public static Attack readAttack() {
        System.out.println("Vad ska attacken heta?");
        String attackName = readNonBlankString();

        System.out.println("Hur mycket ska attacken göra i skada? (1-100)");
        int baseDamage = readIntInRange(1, 100);

        System.out.println("Hur träffsäker ska attacken vara? (1-100)");
        int accuracy = readIntInRange(1, 100);

        System.out.println("Vilken typ ska attacken ha?");
        Type attackType = readType();

        return new Attack(attackName, baseDamage, accuracy, attackType);
    }
}
