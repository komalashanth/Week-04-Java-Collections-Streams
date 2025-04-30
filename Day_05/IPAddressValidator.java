public class IPAddressValidator {
    public static boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;

        for (String part : parts) {
            if (!part.matches("\\d+")) return false;

            int num = Integer.parseInt(part);

            if (num < 0 || num > 255 || (part.length() > 1 && part.startsWith("0"))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] ips = {"192.168.1.1", "255.255.255.0", "256.100.50.0", "01.02.03.04", "123.45.67.89"};

        for (String ip : ips) {
            System.out.println(ip + " → " + (isValidIPv4(ip) ? "Valid" : "Invalid"));
        }
    }
}

