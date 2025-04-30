public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        return color.matches("^#[0-9a-fA-F]{6}$");
    }

    public static void main(String[] args) {
        String[] colors = {"#FFA500", "#ff4500", "#123", "#12345G", "#ABCDEF", "FFA500"};

        for (String color : colors) {
            System.out.println(color + " → " + (isValidHexColor(color) ? "Valid" : "Invalid"));
        }
    }
}

