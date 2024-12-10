package org.example;
import java.util.Scanner;

class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}

class BigLoginException extends Exception {
    public BigLoginException(String message) {
        super(message);
    }
}

class BigPasswordException extends Exception {
    public BigPasswordException(String message) {
        super(message);
    }
}

public class UserValidator {
    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            if (login.length() > 20) {
                throw new BigLoginException("Недопустимый логин! Слишком большoй логин! ");
            }
            if (password.length() > 20) {
                throw new BigPasswordException("Недопустимый пароль! Слишком большой пароль!");
            }
            if (!login.matches("^[a-zA-Z0-9_]{1,19}$")) {
                throw new WrongLoginException("Неверный логин!");
            }
            if (!password.matches("^[a-zA-Z0-9_]{1,19}$") || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Неверный пароль! Попробуйте снова!");
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException | BigLoginException | BigPasswordException e) {
            System.out.println(e.getMessage());

            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.print("Подтвердите пароль: ");
        String confirmPassword = scanner.nextLine();

        boolean isValid = validate(login, password, confirmPassword);
        System.out.println("Результат валидации: " + isValid);
    }
}