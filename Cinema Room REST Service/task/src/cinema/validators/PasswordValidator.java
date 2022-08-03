package cinema.validators;

import cinema.handling.PasswordValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

    @Value("${stats.password}")
    private  String password;

    public PasswordValidator() {
    }

    public void validatePassword(String provided) {
        if (!password.toString().equals(provided.toString())) {
            throw new PasswordValidationException();
        }
    }
}
