package passwordchecker;

import java.util.Scanner;

public class UserPassword {

    // ✅ For simple “scratch” programs, keep this static so main() can use it.
    private static final Scanner scanner = new Scanner(System.in);

    // ✅ Enum belongs at class level (easy to reference anywhere in this class)
    public enum PasswordStrength {
        WEAK,
        MEDIUM,
        STRONG
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Password Strength Checker");
        System.out.print("Enter the password you want to check: ");

        String password = getPassword();

        PasswordStrength strength = checkPassword(password);
        System.out.println("Password strength: " + strength);

        scanner.close();
    }

    // ✅ Static because main() is static
    public static String getPassword() {
        return scanner.nextLine();
    }

    // ✅ Static helper that returns a PasswordStrength
    public static PasswordStrength checkPassword(String password) {
        boolean longEnough = password.length() >= 10;
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecial = !password.matches("[a-zA-Z0-9]*");

        if (longEnough && hasUppercase && hasLowercase && hasNumber && hasSpecial) {
            return PasswordStrength.STRONG;
        }

        if (longEnough && hasUppercase && hasLowercase && hasNumber) {
            return PasswordStrength.MEDIUM;
        }

        // You can tweak this logic however you want; keeping your spirit:
        if (longEnough && (hasUppercase || hasLowercase)) {
            return PasswordStrength.WEAK;
        }

        return PasswordStrength.WEAK;
    }
}
