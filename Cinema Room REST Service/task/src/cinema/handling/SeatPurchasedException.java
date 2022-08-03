package cinema.handling;

public class SeatPurchasedException extends RuntimeException {

    public SeatPurchasedException() {
        super("The ticket has been already purchased!");
    }
}
