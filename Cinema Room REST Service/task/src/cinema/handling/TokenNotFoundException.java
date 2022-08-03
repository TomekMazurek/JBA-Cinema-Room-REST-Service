package cinema.handling;

public class TokenNotFoundException extends RuntimeException {

    public TokenNotFoundException() {
        super("Wrong token!");
    }
}
