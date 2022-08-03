package cinema.dto;

public class PurchasedTicketDto {

    private int row;
    private int column;
    private int price;

    public PurchasedTicketDto() {

    }

    public PurchasedTicketDto(int row, int column, int price) {
        this.column = column;
        this.row = row;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
