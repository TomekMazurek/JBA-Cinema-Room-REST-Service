package cinema.handling;

public class PasswordValidationException extends RuntimeException {

    public PasswordValidationException() {
        super("The password is wrong!");
    }
}
