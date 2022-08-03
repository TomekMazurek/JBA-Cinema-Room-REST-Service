package cinema.handling;

public class SeatNotFoundException extends RuntimeException {

    public SeatNotFoundException() {
        super("The number of a row or a column is out of bounds!");
    }
}
