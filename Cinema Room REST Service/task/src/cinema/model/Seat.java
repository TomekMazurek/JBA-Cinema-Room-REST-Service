package cinema.model;

import java.util.UUID;

public class Seat {

    private int row;
    private int column;
    private int price;
    private boolean purchased;
    private UUID token;

    public Seat() {
        this.purchased = false;
        this.token = null;
    }

    public Seat(int row, int column) {
        this();
        this.column = column;
        this.row = row;
        this.price = row <= 4 ? 10 : 8;
    }

    public int getPrice() {
        return price;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
