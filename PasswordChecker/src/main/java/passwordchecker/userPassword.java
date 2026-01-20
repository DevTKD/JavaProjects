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

        //User to input password
        public String getPassword() {
            System.out.print("Enter your password: ");
            return scanner.nextLine();
        }

    }
}
