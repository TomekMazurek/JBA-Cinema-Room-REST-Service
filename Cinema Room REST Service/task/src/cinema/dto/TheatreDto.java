package cinema.dto;

import java.util.List;

public class TheatreDto {

    private int totalRows;
    private int totalColumns;
    private List<SeatDto> availableSeats;

    public TheatreDto() {
    }

    public TheatreDto(int rows, int columns, List<SeatDto> availableSeats) {
        this.totalRows = rows;
        this.totalColumns = columns;
        this.availableSeats = availableSeats;
    }

    public List<SeatDto> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<SeatDto> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }
}
