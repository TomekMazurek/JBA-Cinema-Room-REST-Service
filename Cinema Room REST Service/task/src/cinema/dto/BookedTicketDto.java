package cinema.dto;

public class BookedTicketDto {

    private String token;
    private TicketDto ticket;

    public BookedTicketDto() {
    }

    public BookedTicketDto(String token, TicketDto ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TicketDto getTicket() {
        return ticket;
    }

    public void setTicket(TicketDto ticket) {
        this.ticket = ticket;
    }
}
