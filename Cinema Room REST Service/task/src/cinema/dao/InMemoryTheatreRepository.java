package cinema.dao;

import cinema.handling.SeatNotFoundException;
import cinema.handling.SeatPurchasedException;
import cinema.handling.TokenNotFoundException;
import cinema.model.Seat;
import cinema.model.Theatre;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryTheatreRepository implements TheatreRepository {

    private final Theatre theatre;
    private final List<UUID> tokens;

    public InMemoryTheatreRepository() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                seats.add(new Seat(i, j));
            }
        }
        this.theatre = new Theatre(seats);
        this.tokens = new ArrayList<>();
    }

    @Override
    public Theatre getSeats() {
        return theatre;
    }

    @Override
    public Seat bookTicket(Seat seat) {
        int seatIndex = findSeat(seat.getRow(), seat.getColumn());
        if (!theatre.getAvailableSeats().get(seatIndex).isPurchased()) {
            Seat bookedSeat = theatre.getAvailableSeats().get(seatIndex);
            bookedSeat.setPurchased(true);
            bookedSeat.setToken(setUuid());
            theatre.getAvailableSeats().set(seatIndex, bookedSeat);
            return bookedSeat;
        }
        throw new SeatPurchasedException();
    }

    @Override
    public Seat returnTicket(UUID token) {
        if (!tokens.contains(token)) {
            throw new TokenNotFoundException();
        }
        tokens.remove(token);
        int seatIndex = findSeat(token);
        Seat updatedSeat = theatre.getAvailableSeats().get(seatIndex);
        updatedSeat.setPurchased(false);
        theatre.getAvailableSeats().set(seatIndex, updatedSeat);
        return updatedSeat;

    }

    @Override
    public Map<String, Integer> getStatistics() {
        Map<String, Integer> statistics = new HashMap<>();
        statistics.put("currentIncome", calculateIncome());
        statistics.put("numberOfAvailableSeats", getAvailableSeats());
        statistics.put("numberOfPurchasedTickets", getBookedTickets().size());
        return statistics;
    }

    private Integer getAvailableSeats() {
        return theatre.getAvailableSeats().size() - getBookedTickets().size();
    }

    private int findSeat(int row, int column) {
        try {
            Seat matchingSeat = theatre.getAvailableSeats().stream()
                    .filter(eachSeat -> {
                        boolean matchRow = eachSeat.getRow() == row;
                        boolean matchColumn = eachSeat.getColumn() == column;
                        return matchRow && matchColumn;
                    })
                    .collect(Collectors.toList())
                    .get(0);
            return theatre.getAvailableSeats().indexOf(matchingSeat);
        } catch (Exception exc) {
            throw new SeatNotFoundException();
        }
    }

    private int findSeat(UUID token) {
        try {
            Seat matchingSeat = theatre.getAvailableSeats().stream()
                    .filter(eachSeat -> {
                        if (eachSeat.getToken() != null) {
                            return eachSeat.getToken().toString().equals(token.toString());
                        }
                        return false;
                    })
                    .collect(Collectors.toList()).get(0);

            return theatre.getAvailableSeats().indexOf(matchingSeat);
        } catch (Exception exc) {
            throw new TokenNotFoundException();
        }
    }

    private UUID setUuid() {
        while (true) {
            UUID token = UUID.randomUUID();
            if (!tokens.contains(token)) {
                tokens.add(token);
                return token;
            }
        }
    }

    private int calculateIncome() {
        List<Integer> bookedTickets = getBookedTickets().stream().map(seat -> seat.getPrice()).collect(Collectors.toList());
        int income = 0;
        for (int i = 0; i < bookedTickets.size(); i++) {
            income += bookedTickets.get(i);
        }
        return income;
    }

    private List<Seat> getBookedTickets() {
        return theatre.getAvailableSeats().stream().filter(seat -> seat.isPurchased()).collect(Collectors.toList());
    }


}

