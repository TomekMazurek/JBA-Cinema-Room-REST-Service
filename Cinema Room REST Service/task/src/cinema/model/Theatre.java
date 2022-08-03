package cinema.model;

import java.util.List;

public class Theatre {

    private int totalRows = 9;
    private int totalColumns = 9;
    private List<Seat> availableSeats;

    public Theatre() {
    }

    public Theatre(List<Seat> seats) {
        this.availableSeats = seats;
    }

    public Theatre(
            int rows,
            int columns,
            List<Seat> seats) {
        this.availableSeats = seats;
        this.totalRows = rows;
        this.totalColumns = columns;
        this.availableSeats = seats;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int rows) {
        this.totalRows = rows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }
}
