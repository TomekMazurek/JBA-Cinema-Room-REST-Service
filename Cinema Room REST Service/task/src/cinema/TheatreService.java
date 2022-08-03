package cinema;

import cinema.dao.TheatreRepository;
import cinema.dto.*;
import cinema.model.Seat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public TheatreDto getSeats() {
        List<SeatDto> seats = theatreRepository.getSeats().getAvailableSeats().stream()
                .map(seat -> new SeatDto(seat.getRow(), seat.getColumn(), seat.getPrice()))
                .collect(Collectors.toList());

        return new TheatreDto(
                theatreRepository.getSeats().getTotalRows(),
                theatreRepository.getSeats().getTotalColumns(),
                seats);
    }

    public BookedTicketDto purchaseTicket(Seat seat) throws Exception {
        Seat bookedSeat = theatreRepository.bookTicket(seat);
        return new BookedTicketDto(bookedSeat.getToken().toString(), new TicketDto(bookedSeat.getRow(), bookedSeat.getColumn(), bookedSeat.getPrice()));
    }

    public ReturnedTicketDto returnTicket(UUID token) {
        Seat returnedSeat = theatreRepository.returnTicket(token);
        return new ReturnedTicketDto(new TicketDto(
                returnedSeat.getRow(),
                returnedSeat.getColumn(),
                returnedSeat.getPrice()));
    }

    public StatisticsDto getStats() {
        Map<String, Integer> statictics = theatreRepository.getStatistics();
        return new StatisticsDto(statictics.get("currentIncome"), statictics.get("numberOfAvailableSeats"), statictics.get("numberOfPurchasedTickets"));
    }
}
