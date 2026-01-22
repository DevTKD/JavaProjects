package passwordchecker;

import java.util.Scanner;

public class userPassword {
    private Scanner scanner = new Scanner(System.in);

    public class checker {
        public static void main(String[] args) {
            // more code to come
        }

        public enum PasswordStrength {
            WEAK,
            MEDIUM,
            STRONG
        }

        // User to input password
        public String getPassword() {
            System.out.print("Enter your password: ");
            return scanner.nextLine();
        }

        // Check if password is strong, medium, or weak
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

            if (longEnough && hasUppercase && hasLowercase) {
                return PasswordStrength.WEAK;
            }

            return PasswordStrength.WEAK; // Default return if password doesn't meet minimum requirements
        }
    }
}
