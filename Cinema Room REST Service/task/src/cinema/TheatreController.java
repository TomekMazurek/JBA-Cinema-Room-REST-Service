package cinema;

import cinema.dto.*;
import cinema.handling.PasswordValidationException;
import cinema.model.Seat;
import cinema.validators.PasswordValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
public class TheatreController {

    private final TheatreService theatreService;
    private final PasswordValidator validator;

    public TheatreController(TheatreService theatreService, PasswordValidator validator) {
        this.theatreService = theatreService;
        this.validator = validator;
    }

    @GetMapping("/seats")
    public ResponseEntity<TheatreDto> getSeats() {
        return ResponseEntity.ok(theatreService.getSeats());
    }

    @PostMapping("/purchase")
    public ResponseEntity<BookedTicketDto> purchaseTicket(@RequestBody Seat seat) throws Exception {
        return ResponseEntity.ok(theatreService.purchaseTicket(seat));
    }

    @PostMapping("/return")
    public ResponseEntity<ReturnedTicketDto> returnTicket(@RequestBody Token token) {
        UUID uuid = UUID.fromString(token.getToken());
        return ResponseEntity.ok(theatreService.returnTicket(uuid));
    }

    @PostMapping("/stats")
    public ResponseEntity<StatisticsDto> getStats(@RequestParam(value = "password", defaultValue = "") String password) {
        if (password.isEmpty()) {
            throw new PasswordValidationException();
        }
        validator.validatePassword(password);
        return ResponseEntity.ok(theatreService.getStats());
    }
}
