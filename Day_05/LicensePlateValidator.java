public class LicensePlateValidator {
    public static boolean isValidPlate(String plate) {
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }

    public static void main(String[] args) {
        String[] plates = {"AB1234", "A12345", "XY5678", "ab1234", "ABC123", "A1B234"};

        for (String plate : plates) {
            System.out.println(plate + " → " + (isValidPlate(plate) ? "Valid" : "Invalid"));
        }
    }
}

