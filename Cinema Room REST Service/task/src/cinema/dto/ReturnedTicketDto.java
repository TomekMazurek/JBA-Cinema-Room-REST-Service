package cinema.dto;

public class ReturnedTicketDto {

    private TicketDto returnedTicket;

    public ReturnedTicketDto() {
    }

    public ReturnedTicketDto(TicketDto returnedTicket) {
        this.returnedTicket = returnedTicket;
    }


    public TicketDto getReturnedTicket() {
        return returnedTicket;
    }

    public void setReturnedTicket(TicketDto returnedTicket) {
        this.returnedTicket = returnedTicket;
    }
}
