package cinema.dao;

import cinema.handling.SeatNotFoundException;
import cinema.handling.SeatPurchasedException;
import cinema.model.Seat;
import cinema.model.Theatre;

import java.util.Map;
import java.util.UUID;

public interface TheatreRepository {

    Theatre getSeats();

    Seat bookTicket(Seat seat) throws SeatNotFoundException, Exception, SeatPurchasedException;

    Seat returnTicket(UUID token);

    Map<String, Integer> getStatistics();
}
